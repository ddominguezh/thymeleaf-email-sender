package com.ddominguezh.thymeleaf.email.sender.domain;

import javax.mail.Address;

import com.ddominguezh.thymeleaf.email.sender.domain.valueObject.EmailJsonData;
import com.ddominguezh.thymeleaf.email.sender.domain.valueObject.EmailRecipients;
import com.ddominguezh.thymeleaf.email.sender.domain.valueObject.EmailSubject;
import com.ddominguezh.thymeleaf.email.sender.domain.valueObject.EmailTemplateFileName;

public class Email {

	private EmailTemplateFileName template;
	private EmailSubject subject;
	private EmailJsonData json;
	private EmailRecipients recipients;
	
	protected Email(EmailTemplateFileName template, EmailSubject subject, EmailJsonData json,
			EmailRecipients recipients) {
		this.template = template;
		this.subject = subject;
		this.json = json;
		this.recipients = recipients;
	}

	public static Email create(String template, String subject, String json, String[] recipients) {
		return new Email(
				EmailTemplateFileName.create(template), 
				EmailSubject.create(subject), 
				EmailJsonData.create(json), 
				EmailRecipients.create(recipients)
			);
	}
	public String html() {
		return this.template.proccessHTML(this.json.toMap());
	}

	public String subject() {
		return this.subject.value();
	}

	public Address[] recipients() {
		return this.recipients.values();
	}

}
