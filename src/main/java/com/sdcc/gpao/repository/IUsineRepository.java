package com.sdcc.gpao.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.sdcc.gpao.entity.Usine;

import reactor.core.publisher.Mono;


@Repository
public interface IUsineRepository extends R2dbcRepository<Usine, Integer> {
	@Query("select * from Usine u where u.Nom_usine = :nom")
	Mono<Usine> findByNom_usine(String nom);
}
