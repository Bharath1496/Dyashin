package com.employee.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
//	@Autowired
	public EmployeeDAOImpl(EntityManager theEM)
	{
		entityManager = theEM;
	}
	
	@Override
	public List<Employee> findAll()
	{
		TypedQuery<Employee> query = entityManager.createQuery("from Employee" , Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee findById(Integer ID) {
		return entityManager.find(Employee.class, ID);
	}

	@Override
	public Employee Update(Employee e) {
		Employee ey = entityManager.merge(e);
		return ey;
		
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Employee e = entityManager.find(Employee.class, id);
		entityManager.remove(e);
//		return "Employee deleted";
		
	}
		

}
