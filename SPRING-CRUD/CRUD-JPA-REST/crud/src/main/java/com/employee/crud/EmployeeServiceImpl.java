package com.employee.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDAO employeeDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO eDAO)
	{
		employeeDao = eDAO;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll()
	{
		return employeeDao.findAll();
	}

	@Override
	public Employee findById(Integer Id) {
		return employeeDao.findById(Id);
	}

	@Override
	@Transactional
	public Employee Update(Employee e) {
		return employeeDao.Update(e);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		employeeDao.deleteById(id);
	}
		
}
