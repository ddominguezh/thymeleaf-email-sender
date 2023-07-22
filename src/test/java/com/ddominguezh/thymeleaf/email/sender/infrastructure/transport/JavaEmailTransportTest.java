package com.ddominguezh.thymeleaf.email.sender.infrastructure.transport;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.ddominguezh.thymeleaf.email.sender.domain.Email;
import com.ddominguezh.thymeleaf.email.sender.domain.EmailMother;
import com.ddominguezh.thymeleaf.email.sender.infrastructure.sender.JavaEmailTransport;

public class JavaEmailTransportTest {

	@Test
	public void send_email() {
		Email email = EmailMother.create();
		JavaEmailTransport sender = new JavaEmailTransport();
		assertDoesNotThrow(() -> sender.send(email));
	}
	
}
