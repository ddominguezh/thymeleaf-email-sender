package com.ddominguezh.thymeleaf.email.sender.domain.exceptions;

@SuppressWarnings("serial")
public class JsonDataParseException extends RuntimeException{

	public JsonDataParseException(String jsonData) {
		super("El json: " + jsonData + " no se ha podido parsear.");
	}
}
