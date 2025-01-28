package com.employee.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository er)
	{
		employeeRepository = er;
	}
	
	@Override
	public List<Employee> findAll()
	{
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(Integer Id) {
		Optional<Employee> result = employeeRepository.findById(Id);
		Employee theEmployee = result.get();
		return theEmployee;
	}

	@Override
	public Employee Update(Employee e) {
		return employeeRepository.save(e);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}
		
}
