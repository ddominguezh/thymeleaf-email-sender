package com.ddominguezh.thymeleaf.email.sender.domain.valueObject;

import java.util.Map;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

public class EmailTemplateFileName {
	
	private String value;
	protected EmailTemplateFileName(String value) {
		this.value = value;
	}
	public static EmailTemplateFileName create(String value) {
		return new EmailTemplateFileName(value);
	}
	
	public String proccessHTML(String locale, Map<String, Object> data) {
		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.addTemplateResolver(templateResolver(locale));
		
		Context context = new Context();
        context.setVariables(data);
        return templateEngine.process("index", context);
	}
	
	private ITemplateResolver templateResolver(String locale) {
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setSuffix(".html");
		templateResolver.setPrefix("/email/template/" + this.value + "/" +  locale + "/");
		templateResolver.setTemplateMode("HTML");
		return templateResolver;
	}
}
