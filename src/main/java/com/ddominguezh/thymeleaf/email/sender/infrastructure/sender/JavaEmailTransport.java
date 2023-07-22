package com.ddominguezh.thymeleaf.email.sender.infrastructure.sender;

import java.util.Properties;

import com.ddominguezh.thymeleaf.email.sender.domain.Email;
import com.ddominguezh.thymeleaf.email.sender.domain.exceptions.SendEmailException;
import com.ddominguezh.thymeleaf.email.sender.domain.transport.EmailTransport;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class JavaEmailTransport implements EmailTransport {

	@Override
	public void send(Email email) {
        try {
            Message message = new MimeMessage(createSession());
            message.setFrom(new InternetAddress(username()));
            message.setRecipients(Message.RecipientType.TO, email.recipients());
            String html = email.html();
            message.setSubject(subject(html));
            message.setContent(html, "text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new SendEmailException(e.getMessage());
        }
	}
	
	private String subject(String html) {
		String tag = "title";
		int startIndex = html.indexOf("<" + tag + ">");
        int endIndex = html.indexOf("</" + tag + ">");
		return html.substring(startIndex + tag.length() + 2, endIndex);
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
