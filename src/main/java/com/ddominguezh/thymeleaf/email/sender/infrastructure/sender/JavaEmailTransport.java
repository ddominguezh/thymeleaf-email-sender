package com.ddominguezh.thymeleaf.email.sender.infrastructure.sender;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.ddominguezh.thymeleaf.email.sender.domain.Email;
import com.ddominguezh.thymeleaf.email.sender.domain.exceptions.SendEmailException;
import com.ddominguezh.thymeleaf.email.sender.domain.transport.EmailTransport;

public class JavaEmailTransport implements EmailTransport {

	@Override
	public void send(Email email) {
        try {
            Message message = new MimeMessage(createSession());
            message.setFrom(new InternetAddress(username()));
            message.setRecipients(Message.RecipientType.TO, email.recipients());
            message.setSubject(email.subject());
            message.setContent(email.html(), "text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new SendEmailException(e.getMessage());
        }
	}
	
	private Session createSession() {
		Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username(), password());
            }
        };
		return Session.getInstance(properties(), authenticator);
	}
	
	private Properties properties() {
		Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", property("javax.mail.host"));
        props.put("mail.smtp.port", property("javax.mail.port"));
        return props;
	}
	
	private String username() {
		return property("javax.mail.username");
	}
	
	private String password(){
		return property("javax.mail.password");
	}

	private String property(String key) {
		return System.getenv(key);
	}
}
