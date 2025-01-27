package com.simple.testOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
	
	@Value("${name}")
	private String name;
		
	@GetMapping("/Hello")
	public String sayHello()
	{
		return "Hello";
	}
	
//	@Autowired
	private Coach myCoach;
	
	private Coach kabaddi;
	
	@Autowired
	public SimpleController(@Qualifier("cricketCoach") Coach theCoach,
							@Qualifier("kabaddiCoach") Coach kabaddiCoach)
	{
		System.out.println("constructor injection");
		myCoach = theCoach;
		kabaddi = kabaddiCoach;
	}
	
//	public SimpleController()
//	{
//		System.out.println("Simple Controller");
//	}
	
//	@Autowired
//	public void setCoach(Coach theCoach)
//	{
//		System.out.println("setter injection");
//		myCoach = theCoach;
//	}
	
	
//	@Autowired
//	public void someMethod(Coach theCoach)
//	{
//		System.out.println("method injection");
//		myCoach = theCoach;
//	}
	
	@GetMapping("/Coaching")
	public String Coaching()
	{
		return myCoach.getDailyWorkout();
	}
	
	@GetMapping("/check")
	public boolean checkBeanScope()
	{
		return myCoach==kabaddi;
	}
	
	@GetMapping("/kabaddi")
	public String twoCoaches()
	{
		return kabaddi.getDailyWorkout();
	}
	
	
}
