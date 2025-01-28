package com.Practice.StageTwo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StageTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StageTwoApplication.class, args);
	}
//	
//	@Bean
//	public CommandLineRunner commandLineRunner(StudentDAO studentDao)
//	{
//		return runner -> 
//		{
//			System.out.println("Hello World");
//			
////			createStudent(studentDao);
//			retrieveStudent(studentDao);
//			allStudents(studentDao);
//				
//		};
//		
//	}
//	
//	private void createStudent(StudentDAO studentdao)
//	{
//		Student s1 = new Student("john" , "doe" , "john@doe.com");
//		studentdao.save(s1);
//		
//	}
//	
//	
//	private void retrieveStudent(StudentDAO studentdao)
//	{
//		Student s1 = new Student("john" , "doe" , "john@doe.com");
//		studentdao.save(s1);
//		
//		Student s2 = studentdao.Retrieve(s1.getId());
//		
//		System.out.println(s2);
//	}
//	
//	private void allStudents(StudentDAO studentdao)
//	{
//		List<Student> l1 = studentdao.findAll();
//		
//		for(Student s : l1)
//		{
//			System.out.println(s);
//		}
//		
//	}
//	
	

}
