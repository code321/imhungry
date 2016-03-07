package com.app.imhungry.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.app.imhungry.model.Cook;

@Repository
public class CookDAOImpl implements CookDAO {
   
    private static final Logger logger = LoggerFactory.getLogger(CookDAOImpl.class);
	
    @PersistenceContext
    private EntityManager em;

	@Override
	public void add(Cook cook) {       
       em.persist(cook);
       logger.info("Cook saved successfully, Cook Details="+cook);	
	}

	@Override
	public void update(Cook cook) {
        em.merge(cook);
        logger.info("Cook updated successfully, Cook Details="+cook);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cook> list() {
        List<Cook> cookList = em.createQuery("from Cook").getResultList();
        for(Cook cook : cookList){
            logger.info("Cook List::"+cook);
        }
        return cookList;
	}

	@Override
	public Cook getById(long id) {              
        Cook cook = (Cook) em.find(Cook.class, new Long(id));
        logger.info("Cook loaded successfully, Cook details="+cook);
        return cook;
	}

	@Override
	public void remove(long id) {		
        Cook cook = (Cook) em.find(Cook.class, new Long(id));
        if(null != cook){
            em.remove(cook);
            em.persist(cook);
        }
        logger.info("Cook deleted successfully, Cook details="+cook);		
	}

	
}
