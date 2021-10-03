package com.sdcc.gpao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdcc.gpao.entity.Usine;
import com.sdcc.gpao.service.UsineService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping("/api/usine/")
public class UsineController {
	
	@Autowired
	private UsineService usineService;
	
	@GetMapping("/liste")
	public Flux<Usine> getListe () {
	    return usineService.getListe();
	}
	
	@GetMapping("/liste/{id}")
	public Mono<ResponseEntity<Usine>> getElement(@PathVariable(value = "id") int id) throws Exception {
	    return usineService.getElement(id);
	}
	
	
}
