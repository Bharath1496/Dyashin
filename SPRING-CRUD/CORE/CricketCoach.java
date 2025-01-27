package com.simple.testOne;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
//@Lazy
public class CricketCoach implements Coach{
	
	public CricketCoach()
	{
		System.out.println("CricketCoach");
	}
	
	@Override
	public String getDailyWorkout()
	{
		return "Cricket practice";
	}
	
	@PostConstruct
	public void checking()
	{
		System.out.println("after constructing cricket object");
	}
	
	@PreDestroy
	public void checkingTwo()
	{
		System.out.println("before destroying cricket object");
	}
	
	
}
