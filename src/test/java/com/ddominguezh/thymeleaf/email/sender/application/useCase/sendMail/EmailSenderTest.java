package com.ddominguezh.thymeleaf.email.sender.application.useCase.sendMail;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import com.ddominguezh.thymeleaf.email.sender.domain.Email;
import com.ddominguezh.thymeleaf.email.sender.domain.EmailMother;
import com.ddominguezh.thymeleaf.email.sender.domain.transport.EmailTransport;

public class EmailSenderTest {

	@Test
	public void send_email() {
		SendEmailCommand command = EmailMother.command();
		EmailTransport transport = mock(EmailTransport.class);
		EmailSender sender = new EmailSender(transport);
		sender.invoke(command);
		verify(transport, times(1)).send(any(Email.class));
	}
	
}
