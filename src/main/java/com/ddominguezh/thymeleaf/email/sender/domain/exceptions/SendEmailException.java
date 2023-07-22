package com.ddominguezh.thymeleaf.email.sender.domain.exceptions;

@SuppressWarnings("serial")
public class SendEmailException extends RuntimeException{

	public SendEmailException(String message) {
		super("No se ha podido realizar el envio: " + message);
	}
	
}
