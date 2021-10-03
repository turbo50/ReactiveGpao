package com.sdcc.gpao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

	@GetMapping("/")
	public String home () {
	    return "Bienvenu sur l'API GPAO Reactive";
	}
}
