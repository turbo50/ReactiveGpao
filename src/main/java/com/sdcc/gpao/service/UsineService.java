package com.sdcc.gpao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sdcc.gpao.entity.Usine;
import com.sdcc.gpao.repository.IUsineRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsineService {
	
	private IUsineRepository usineRepository;
	
	
	@Autowired
	public UsineService(IUsineRepository usineRepository) {
		super();
		this.usineRepository = usineRepository;
	}
	
	public Mono<ResponseEntity<Usine>> getElement(int id) throws Exception {
	    return this.usineRepository.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	
	public Flux<Usine> getListe() {
	    return usineRepository.findAll();
	}
	
}
	
