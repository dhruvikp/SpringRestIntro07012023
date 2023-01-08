package com.simplilearn.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionConfig {

	@ExceptionHandler(value = ArithmeticException.class)
	public String arithmaticHandler() {
		return "Arithmatic exceptoin thrown!";
	}

	@ExceptionHandler(value = Exception.class)
	public String handleAllException() {
		return "Exception exceptoin thrown! Please contact administrator!!";
	}
}
