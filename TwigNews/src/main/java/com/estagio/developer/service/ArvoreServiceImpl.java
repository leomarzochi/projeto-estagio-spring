package com.estagio.developer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estagio.developer.model.Arvore;
import com.estagio.developer.repository.ArvoreRepository;

@Service
public class ArvoreServiceImpl implements ArvoreService {
    @Autowired
    private ArvoreRepository repo;

    @Override
    public Iterable<Arvore> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Arvore> search(String q) {
        return repo.findByNameContaining(q);
    }

    @Override
    public Arvore getOne(int id) {
        return repo.findOne(id);
    }

    @Override
    public void save(Arvore tree) {
    	repo.save(tree);
    }

    @Override
    public void delete(int id) {
    	repo.delete(id);
    }

	@Override
	public List<Arvore> search(String q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Arvore findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Arvore tree) {
		// TODO Auto-generated method stub
		
	}
}
