package com.bcits.springcoreannotations.bean;

import com.bcits.springcoreannotations.interfaces.Animal;

public class Goat implements Animal{

	@Override
	public void eat() {
		System.out.println("Eating grass");
		
	}

	@Override
	public void speak() {
		System.out.println("Mehhhhh!!");
		
	}

}
