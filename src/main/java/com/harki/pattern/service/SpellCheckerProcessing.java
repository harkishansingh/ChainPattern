package com.harki.pattern.service;

import org.springframework.stereotype.Service;

@Service
public class SpellCheckerProcessing extends ProcessingObject<String> {

	@Override
	protected String handleWork(String input) {
		return input.replaceAll("labda", "lambda");
	}

}
