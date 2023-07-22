package com.ddominguezh.thymeleaf.email.sender.application.useCase.sendMail;

import com.ddominguezh.thymeleaf.email.sender.domain.Email;
import com.ddominguezh.thymeleaf.email.sender.domain.transport.EmailTransport;

public class EmailSender {

	private final EmailTransport transport;
	public EmailSender(EmailTransport transport) {
		this.transport = transport;
	}
	
	public void invoke(SendEmailCommand command) {
		this.transport.send(
				Email.create(
						command.template(), 
						command.locale(), 
						command.json(), 
						command.recipients()
					)
			);
	}
}
