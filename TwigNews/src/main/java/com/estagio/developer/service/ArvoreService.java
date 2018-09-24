package com.estagio.developer.service;

import java.util.List;

import com.estagio.developer.model.Arvore;

public interface ArvoreService {
    Iterable<Arvore> findAll();

    List<Arvore> search(String q);

    Arvore findOne(int id);

    void save(Arvore tree);

    void delete(int id);

	
}