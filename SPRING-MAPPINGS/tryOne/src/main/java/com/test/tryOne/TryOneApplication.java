package com.test.tryOne;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TryOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(TryOneApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			createInstructor(appDAO);
		 };
		
	}
	
	
		private void createInstructor(AppDAO appDAO) {
			// create the instructor
			Instructor tempInstructor =  new Instructor("Chad", "Darby", "darby@luv2code.com");
			// create the instructor detail
			InstructorDetail tempInstructorDetail =new InstructorDetail("http://www.luv2code.com/youtube","Luv 2 code!!!");
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			// save the instructor
			System.out.println("Saving instructor: " + tempInstructor);
			appDAO.save(tempInstructor);
			System.out.println("Done!");
		
		}
	

}
