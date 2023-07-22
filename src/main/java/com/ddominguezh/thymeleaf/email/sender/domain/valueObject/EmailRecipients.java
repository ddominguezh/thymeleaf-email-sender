package com.ddominguezh.thymeleaf.email.sender.domain.valueObject;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.mail.Address;

public class EmailRecipients {

	private List<EmailRecipient> values;

	protected EmailRecipients(List<EmailRecipient> values) {
		this.values = values;
	}
	
	public static EmailRecipients create(String[] values) {
		return new EmailRecipients(Stream.of(values).map(EmailRecipient::create).collect(Collectors.toList()));
	}

	public Address[] values() {
		return this.values.stream().map(EmailRecipient::value).toArray(Address[]::new);
	}
}
