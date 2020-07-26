package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// create a string array
	private String[] fortune = {
			"Your lucky!",
			"You unlucky!",
			"I don`t know"
	};
	
	// create a random number generation
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		// pick a random string from the array
		int index = random.nextInt(fortune.length);
		
		return fortune[index];
	}

}
