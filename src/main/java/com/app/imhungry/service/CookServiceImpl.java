package com.app.imhungry.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.imhungry.model.Cook;
import com.app.imhungry.repository.CookRepository;

@Service
public class CookServiceImpl implements CookService {
	
	@Inject private CookRepository cookRepository; 
	
	@Transactional
	public void add(Cook cook) {
		this.cookRepository.save(cook);		
	}

	@Transactional
	public void update(Cook cook) {
		this.cookRepository.save(cook);	
	}

	public List<Cook> list(Sort sort) {		
		return this.cookRepository.findAll(sort);
	}
	
	public Cook getById(long id) {		
		return this.cookRepository.findOne(id);
	}

	@Transactional
	public void remove(long id) {
	   this.cookRepository.delete(id);
	}
	
	public Page<Cook> list(Integer pageNumber, Integer pageSize, Sort sort) {	
		PageRequest pageRequest =
	            new PageRequest(pageNumber - 1, pageSize, sort);
		
		return cookRepository.findAll(pageRequest);		  
    }
    
    public Sort orderBy() {
    	return new Sort(Sort.Direction.ASC, "id");
    }
}
