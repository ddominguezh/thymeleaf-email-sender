package com.ddominguezh.thymeleaf.email.sender.domain.valueObject;

public class EmailSubject {

	private String value;
	protected EmailSubject(String value) {
		this.value = value;
	}
	public static EmailSubject create(String value) {
		return new EmailSubject(value);
	}
	public String value() {
		return this.value;
	}
	
}
