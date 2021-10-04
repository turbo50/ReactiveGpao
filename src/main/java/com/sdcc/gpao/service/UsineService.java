package com.sdcc.gpao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdcc.gpao.entity.Usine;
import com.sdcc.gpao.repository.IUsineRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsineService implements IBaseService<Usine, Integer>{
	
	private IUsineRepository usineRepository;
	
	
	@Autowired
	public UsineService(IUsineRepository usineRepository) {
		super();
		this.usineRepository = usineRepository;
	}
	
	
	@Override
	public Flux<Usine> getListe() {
		  return usineRepository.findAll();
	}

	@Override
	public Mono<Usine> getElement(Integer id)  {
		return this.usineRepository.findById(id);
	}

	@Override
	public Mono<Usine> ajouter(final Usine t)  {
		//Mono<Usine> usineDb = usineRepository.findByNom_usine(t.getNom_usine());
		//if(usineDb.block() == null) {
			return usineRepository.save(t);
			//return null;
		/*}else {
			throw new NoDuplicationException("Cette usine existe déjà");
		}*/
	}

	@Override
	public Mono<Usine> modifier(Integer v, Mono<Usine> t) {
		return usineRepository.findById(v).
				flatMap( us -> t.map( usine ->{
					us.setId_usine(usine.getId_usine());
					us.setCode_usine(usine.getCode_usine());
					us.setNom_usine(usine.getNom_usine());
					return us;
				})).
				flatMap(us -> usineRepository.save(us));
	}

	@Override
	public Mono<Void> supprimer(Integer v)  {
		//Mono<Usine> usineDb = usineRepository.findById(v);
		//if(usineDb.block() != null) {
			return usineRepository.deleteById(v);
		//}else {
			//throw new ResourceNotFoundException("Cette usine n'existe pas");
		//}
	}
	
	public Mono<Usine> getElement(String nom) {
		return this.usineRepository.findByNom_usine(nom);
	}
	
}
	
