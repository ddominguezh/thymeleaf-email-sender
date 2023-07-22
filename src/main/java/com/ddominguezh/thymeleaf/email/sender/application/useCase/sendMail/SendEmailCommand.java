package com.ddominguezh.thymeleaf.email.sender.application.useCase.sendMail;

public class SendEmailCommand {

	private String template;
	private String subject;
	private String json;
	private String[] recipients;
	public SendEmailCommand(String template, String subject, String json, String[] recipients) {
		this.template = template;
		this.subject = subject;
		this.json = json;
		this.recipients = recipients;
	}
	public String template() {
		return template;
	}
	public String subject() {
		return subject;
	}
	public String json() {
		return json;
	}
	public String[] recipients() {
		return recipients;
	}
	
}
