package com.ddominguezh.thymeleaf.email.sender.domain.exceptions;

@SuppressWarnings("serial")
public class EmailRecipientParseException extends RuntimeException {

	public EmailRecipientParseException(String value) {
		super("El email " + value + " no se ha podido parsear.");
	}

}
