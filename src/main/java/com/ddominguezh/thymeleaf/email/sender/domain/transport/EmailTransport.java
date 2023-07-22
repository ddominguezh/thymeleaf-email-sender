package com.ddominguezh.thymeleaf.email.sender.domain.transport;

import com.ddominguezh.thymeleaf.email.sender.domain.Email;

public interface EmailTransport {

	void send(Email email);
	
}
