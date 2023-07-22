package com.ddominguezh.thymeleaf.email.sender.domain.valueObject;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.ddominguezh.thymeleaf.email.sender.domain.exceptions.EmailRecipientParseException;

public class EmailRecipientTest {

	@Test
	public void parse_email() {
		assertDoesNotThrow(() -> EmailRecipient.create("patatamango@gmail.com"));
	}
	
	@Test
	public void parse_email_excetion() {
		assertThrows(EmailRecipientParseException.class, () -> EmailRecipient.create(UUID.randomUUID().toString()+"<pata@gmail.com"));
	}
}
