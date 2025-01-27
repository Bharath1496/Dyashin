package com.simple.testOne.Another;

import com.simple.testOne.Coach;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class KabaddiCoach implements Coach {
	
	@PostConstruct
	public void checking()
	{
		System.out.println("after constructing kabaddi object");
	}
	
	@PreDestroy
	public void checkingTwo()
	{
		System.out.println("before destroying kabaddi object.");
	}
	
	public KabaddiCoach()
	{
		System.out.println("kabaddi coach");
	}
	
	@Override
	public String getDailyWorkout()
	{
		System.out.println("inside kabaddi workout method");
		return "practice kabaddi";
	}
	
}
