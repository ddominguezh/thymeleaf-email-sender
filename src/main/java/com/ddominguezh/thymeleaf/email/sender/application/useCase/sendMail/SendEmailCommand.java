package com.ddominguezh.thymeleaf.email.sender.application.useCase.sendMail;

public class SendEmailCommand {

	private String template;
	private String locale;
	private String json;
	private String[] recipients;
	public SendEmailCommand(String template, String locale, String json, String[] recipients) {
		this.template = template;
		this.locale = locale;
		this.json = json;
		this.recipients = recipients;
	}
	public String template() {
		return template;
	}
	public String locale() {
		return locale;
	}
	public String json() {
		return json;
	}
	public String[] recipients() {
		return recipients;
	}
	
}
