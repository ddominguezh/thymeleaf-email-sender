package com.ddominguezh.thymeleaf.email.sender.domain;

import javax.mail.Address;

import com.ddominguezh.thymeleaf.email.sender.domain.valueObject.EmailJsonData;
import com.ddominguezh.thymeleaf.email.sender.domain.valueObject.EmailRecipients;
import com.ddominguezh.thymeleaf.email.sender.domain.valueObject.EmailLocale;
import com.ddominguezh.thymeleaf.email.sender.domain.valueObject.EmailTemplateFileName;

public class Email {

	private EmailTemplateFileName template;
	private EmailLocale locale;
	private EmailJsonData json;
	private EmailRecipients recipients;
	
	protected Email(EmailTemplateFileName template, EmailLocale locale, EmailJsonData json,
			EmailRecipients recipients) {
		this.template = template;
		this.locale = locale;
		this.json = json;
		this.recipients = recipients;
	}

	public static Email create(String template, String locale, String json, String[] recipients) {
		return new Email(
				EmailTemplateFileName.create(template), 
				EmailLocale.create(locale), 
				EmailJsonData.create(json), 
				EmailRecipients.create(recipients)
			);
	}
	public String html() {
		return this.template.proccessHTML(this.locale.value(), this.json.toMap());
	}

	public Address[] recipients() {
		return this.recipients.values();
	}

}
