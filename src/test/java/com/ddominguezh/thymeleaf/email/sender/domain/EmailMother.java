package com.ddominguezh.thymeleaf.email.sender.domain;

import java.util.UUID;

import com.ddominguezh.thymeleaf.email.sender.application.useCase.sendMail.SendEmailCommand;

public class EmailMother {

	public static Email create() {
		String json = "{\"name\": \"John Doe\", \"email\": \"john.doe@example.com\", \"cities\": [{\"id\":\"1\", \"name\":\"Albacete\"}, {\"id\":\"2\", \"name\":\"Toledo\"}, {\"id\":\"3\", \"name\":\"Ronda\"}]}";
		return Email.create("test", UUID.randomUUID().toString(), json, new String[] {"diegoalbert500@gmail.com"});
	}
	
	public static SendEmailCommand command() {
		String json = "{\"name\": \"John Doe\", \"email\": \"john.doe@example.com\", \"cities\": [{\"id\":\"1\", \"name\":\"Albacete\"}, {\"id\":\"2\", \"name\":\"Toledo\"}, {\"id\":\"3\", \"name\":\"Ronda\"}]}";
		return new SendEmailCommand("test", UUID.randomUUID().toString(), json, new String[] {"diegoalbert500@gmail.com"});
	}
}
