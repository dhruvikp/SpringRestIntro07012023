package com.simplilearn.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

	@GetMapping("/calculate")
	public String calculate() {
		int a = 5;
		int b = 0;

		int c = a / b;

		return "Result calculated successfully";
	}
}
