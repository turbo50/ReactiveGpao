package com.sdcc.gpao.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.sdcc.gpao.entity.Usine;


@Repository
public interface IUsineRepository extends ReactiveCrudRepository<Usine, Integer> {
}
