package com.Practice.StageTwo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
}
