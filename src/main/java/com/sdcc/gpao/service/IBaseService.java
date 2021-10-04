package com.sdcc.gpao.service;

import org.springframework.http.ResponseEntity;

import com.sdcc.gpao.entity.Usine;
import com.sdcc.gpao.exception.NoDuplicationException;
import com.sdcc.gpao.exception.ResourceNotFoundException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBaseService<T, V> {	
	public Flux<T> getListe();
	public Mono<T> getElement(V v) throws ResourceNotFoundException;
	public Mono<T> ajouter(T t);
	public Mono<T> modifier(V v, Mono<T> t)throws ResourceNotFoundException;
	public Mono<Void> supprimer(V v) throws ResourceNotFoundException;
}
