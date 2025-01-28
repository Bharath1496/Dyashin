package com.Practice.StageTwo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	private StudentDAO sdao; 
	
	@Autowired
	public StudentController(StudentDAO theDAO)
	{
		sdao = theDAO;
	}
	
	@GetMapping("/saveStudent")
	public String add()
	{
		Student s1 = new Student("heman" , "turner" , "john@doe.com");
		sdao.save(s1);
		return "Student saved";
	}
	
	
	@GetMapping("/allStudents")
	public List<Student> allStudents()
	{
		List<Student> l1 = sdao.findAll();
		
		for(Student s : l1)
		{
			System.out.println(s);
		}
		
		return l1;
	}
	
	
	@GetMapping("/findStudent")
	public Student findStudent()
	{
		Student s1 = new Student("john" , "doe" , "john@doe.com");
		sdao.save(s1);
		
		Student s2 = sdao.Retrieve(s1.getId());
		
		return s2;
	}
	
	@GetMapping("/update")
	public Student Update()
	{
		int id = 10;
		Student s = sdao.Retrieve(id);
		
		s.setFirst_name("gerard");
		
		sdao.Update(s);
	
		
		return s;
	}
	
	@GetMapping("/delete")
	public String delete()
	{
		int id = 11;
		Student s = sdao.Retrieve(id);
		
		sdao.delete(s);
		
		return "Deleted Student : " + s.getFirst_name();
	}
	
	
	@GetMapping("/deleteCondition")
	public String deleteCondition()
	{
		int DeletedRows = sdao.deleteOnCondition();
		return "numberOfRowsDeleted"+ DeletedRows;
	}
	
	@GetMapping("/deleteAll")
	public String deleteAll()
	{
		int DeleteRows = sdao.deleteAll();
		return "number of rows deleted" + DeleteRows;
	}
	
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable int id)
	{
		List<Student> l1 = sdao.findAll();
		
		if(id >= l1.size() || id<0)
		{
			throw new StudentNotFoundException("Student with id : " +id +" is not found");
		}
		
		Student s = sdao.Retrieve(id);
		
		return  s;
	}
	
	
	
	
	
}
