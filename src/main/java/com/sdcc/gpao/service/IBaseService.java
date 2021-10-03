package com.sdcc.gpao.service;

import com.sdcc.gpao.exception.NoDuplicationException;
import com.sdcc.gpao.exception.ResourceNotFoundException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBaseService<T, V> {	
	public Flux<T> getliste();
	public Mono<T> getElement(V v) throws ResourceNotFoundException;
	public Mono<T> ajouter(T t) throws NoDuplicationException;
	public Mono<T> modifier(V v, T t)throws ResourceNotFoundException;
	public Mono<Void> supprimer(V v) throws ResourceNotFoundException;
}
