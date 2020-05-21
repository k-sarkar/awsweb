package com.aws.awsweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeControler {
	
	@GetMapping("/welcome/{name}")
	public String getWelComeMessage(@PathVariable String name) {
		
		return name;
	}

}
