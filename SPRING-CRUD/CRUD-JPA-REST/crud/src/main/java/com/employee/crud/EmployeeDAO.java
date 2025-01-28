package com.employee.crud;

import java.util.List;

public interface EmployeeDAO {
	
	List<Employee> findAll();
	
	public Employee findById(Integer Id);
	public Employee Update(Employee e);
	public void deleteById(int ID);
}
