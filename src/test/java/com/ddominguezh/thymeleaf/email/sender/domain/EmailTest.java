package com.ddominguezh.thymeleaf.email.sender.domain;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class EmailTest {

	@Test
	public void generate_html() {
		Email email = EmailMother.create();
		String html = email.html();
		assertTrue(html.contains("John Doe"));
		assertTrue(html.contains("john.doe@example.com"));
		assertTrue(html.contains("Ronda"));
	}
}
