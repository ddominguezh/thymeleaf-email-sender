package com.ddominguezh.thymeleaf.email.sender.domain.valueObject;

import java.io.IOException;
import java.util.Map;

import com.ddominguezh.thymeleaf.email.sender.domain.exceptions.JsonDataParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmailJsonData {

	private String value;
	protected EmailJsonData(String value) {
		this.value = value;
	}
	public static EmailJsonData create(String value) {
		return new EmailJsonData(value);
	}
	public Map<String, Object> toMap() {
		ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(this.value, new TypeReference<Map<String, Object>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            throw new JsonDataParseException(value);
        }
	}
}
