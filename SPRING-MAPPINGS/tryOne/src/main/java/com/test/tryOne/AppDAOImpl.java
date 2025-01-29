package com.test.tryOne;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	public AppDAOImpl(EntityManager em)
	{
		entityManager = em;
	}
	
	@Override
	@Transactional
	public void save(Instructor theInstructor)
	{
		entityManager.persist(theInstructor);
	}
	
}
