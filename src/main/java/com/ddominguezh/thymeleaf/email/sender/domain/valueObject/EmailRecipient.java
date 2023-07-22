package com.ddominguezh.thymeleaf.email.sender.domain.valueObject;

import com.ddominguezh.thymeleaf.email.sender.domain.exceptions.EmailRecipientParseException;

import jakarta.mail.Address;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;

public class EmailRecipient {

	private Address value;
	protected EmailRecipient(Address value) {
		this.value = value;
	}
	public static EmailRecipient create(String value) {
		Address[] addreses;
		try {
			addreses = InternetAddress.parse(value, true);
		} catch (AddressException e) {
			throw new EmailRecipientParseException(value);
		}
		return new EmailRecipient(addreses[0]);
	}
	public Address value() {
		return value;
	}
	
	
}
