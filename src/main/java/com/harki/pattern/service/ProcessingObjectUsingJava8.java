package com.harki.pattern.service;

import java.util.function.Function;
import java.util.function.UnaryOperator;

import org.springframework.stereotype.Service;

@Service
public class ProcessingObjectUsingJava8 {

	private UnaryOperator<String> headerProcessing = (String text) -> "From Harki: " + text;

	private UnaryOperator<String> spellcheckerProcessing = (String text) -> text.replaceAll("labda", "lambda");

	public Function<String, String> pipeline = headerProcessing.andThen(spellcheckerProcessing);
}
