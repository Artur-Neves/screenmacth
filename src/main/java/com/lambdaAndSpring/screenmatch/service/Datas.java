package com.lambdaAndSpring.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Datas implements DataConverter {
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public <T> T getDatas(String json, Class<T> clas) {
		try {
			return mapper.readValue(json, clas);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
