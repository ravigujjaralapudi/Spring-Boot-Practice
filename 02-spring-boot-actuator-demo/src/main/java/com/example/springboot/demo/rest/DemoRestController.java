package com.example.springboot.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoRestController {
	
	
	@GetMapping("/welcome")
	public String getWelomceMessage() {
		return "Welcome to the Spring Boot - Practice";
	}

}
