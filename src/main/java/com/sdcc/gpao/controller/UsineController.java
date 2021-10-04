package com.sdcc.gpao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdcc.gpao.entity.Usine;
import com.sdcc.gpao.exception.NoDuplicationException;
import com.sdcc.gpao.exception.ResourceNotFoundException;
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
	    return usineService.getElement(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/ajouter")
    public Mono<Usine> ajouter(@RequestBody Mono<Usine> usineMono){
        //return usineService.ajouter(usineMono);
		return usineMono.flatMap(this.usineService::ajouter);
    }
	
	@PutMapping("/modifier/{id}")
    public Mono<ResponseEntity<Usine>> modifier(@PathVariable(value = "id") Integer id, @RequestBody Mono<Usine> usineMono) throws ResourceNotFoundException{
        return usineService.modifier(id, usineMono)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
	
	@PutMapping("/supprimer/{id}")
    public void supprimer(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException{
        usineService.supprimer(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
	
}
