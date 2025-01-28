package com.employee.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud")
public class EmployeeController {
	
	private EmployeeService es;
	
	@Autowired
	public EmployeeController(EmployeeService theEs)
	{
		es = theEs;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAllEmployees()
	{
		return es.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public Employee findEmployeeByID(@PathVariable int id)
	{
		return es.findById(id);
	}
		
	@PostMapping("/employees")
	public ResponseEntity<Employee> add(@RequestBody Employee employee) {
	    Employee savedEmployee = es.Update(employee);
	    return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> update(@PathVariable int id , @RequestBody Employee employee) {
	    employee.setId(id);
		Employee updatedEmployee = es.Update(employee);
	    return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/employees/{id}")
	public String delete(@PathVariable int id)
	{
		es.deleteById(id);
		return "Employee " + id + "deleted";
	}
	
}
