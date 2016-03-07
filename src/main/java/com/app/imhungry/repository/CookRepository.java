package com.app.imhungry.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.imhungry.model.Cook;

@Repository
public interface CookRepository extends CrudRepository<Cook, Long> {

	List<Cook> findAll(Sort sort);	
	Page<Cook> findAll(Pageable pageable);
	
	
}
