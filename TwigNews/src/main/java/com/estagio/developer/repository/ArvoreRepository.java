package com.estagio.developer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.estagio.developer.model.Arvore;

public interface ArvoreRepository extends CrudRepository<Arvore, Integer>{

	

	//List<Arvore> findByNameContaining(String q);
	
}
