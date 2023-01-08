package com.simplilearn.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.model.Greet;

// @RestController = @Controller + @ResponseBody(On each method)
@RestController
public class GreetController {

	//@GetMapping("/greetMe")
	@RequestMapping(value="/greetMe", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Greet greet() {
		Greet greet = new Greet();
		greet.setUser("Lokesh");
		greet.setMessage("Hello world!!");
		return greet;
	}

}