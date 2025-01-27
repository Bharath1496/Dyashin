package com.simple.testOne.Another;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.simple.testOne.Coach;

@Component
@Primary
//@Lazy
public class TennisCoach implements Coach{
	
	public TennisCoach()
	{
		System.out.println("Tennis Coach");
	}
	
	@Override
	public String getDailyWorkout()
	{
		return "Tennis Practice";
	}
	
}
