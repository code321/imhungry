package com.app.imhungry.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.app.imhungry.model.Cook;

public interface CookService {

	public void add(Cook cook);
	
	public void update(Cook cook);

	public List<Cook> list(Sort sort);
	
	public Cook getById(long id);

	public void remove(long id);
	
	public Page<Cook> list(Integer pageNumber, Integer pageSize, Sort sort);
	
	public Sort orderBy();
	
}
