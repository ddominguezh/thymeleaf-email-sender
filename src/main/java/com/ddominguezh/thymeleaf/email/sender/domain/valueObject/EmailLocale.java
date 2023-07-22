package com.ddominguezh.thymeleaf.email.sender.domain.valueObject;

public class EmailLocale {

	private String value;
	protected EmailLocale(String value) {
		this.value = value;
	}
	public static EmailLocale create(String value) {
		return new EmailLocale(value);
	}
	public String value() {
		return this.value;
	}
	
}
