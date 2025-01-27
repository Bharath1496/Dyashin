package com.simple.testOne.Another;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.simple.testOne.Coach;

@Configuration
public class SportConfig {
	
	@Bean
	public Coach kabaddiCoach()
	{
		System.out.println("inside sports config");
		return new KabaddiCoach();
	}
	
}
