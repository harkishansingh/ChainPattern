package com.harki.pattern.service;

import org.springframework.stereotype.Service;

@Service
public class HeaderTextProcessing extends ProcessingObject<String> {

	@Override
	protected String handleWork(String input) {
		return "From Harki: " + input;
	}

}
