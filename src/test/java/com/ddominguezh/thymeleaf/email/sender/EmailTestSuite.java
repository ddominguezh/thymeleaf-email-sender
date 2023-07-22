package com.ddominguezh.thymeleaf.email.sender;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.ddominguezh.thymeleaf.email.sender.application.useCase.sendMail.EmailSenderTest;
import com.ddominguezh.thymeleaf.email.sender.domain.EmailTest;
import com.ddominguezh.thymeleaf.email.sender.domain.valueObject.EmailRecipientTest;
import com.ddominguezh.thymeleaf.email.sender.infrastructure.transport.JavaEmailTransportTest;

@SelectClasses
(
	{
		EmailSenderTest.class,
		EmailRecipientTest.class,
		EmailTest.class,
		JavaEmailTransportTest.class
	}
)
@Suite
public class EmailTestSuite {

}
