package com.Practice.StageTwo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentImpl implements StudentDAO{
	
	public EntityManager theEntityManager;
	
	@Autowired
	public StudentImpl(EntityManager newEntityManager)
	{
		theEntityManager = newEntityManager;
	}
	
	@Override
	@Transactional
	public void save(Student theStudent)
	{
		theEntityManager.persist(theStudent);
	}
	
	@Override
	public Student Retrieve(Integer id)
	{
		return theEntityManager.find(Student.class ,id);
	}
	
	@Override
	public List<Student> findAll()
	{
		TypedQuery<Student> theQuery = theEntityManager.createQuery("FROM Student" , Student.class);
		return theQuery.getResultList();
	}
	
	
}
