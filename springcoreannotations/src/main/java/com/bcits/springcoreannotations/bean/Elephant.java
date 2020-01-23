package com.bcits.springcoreannotations.bean;

import com.bcits.springcoreannotations.interfaces.Animal;

public class Elephant implements Animal{

	@Override
	public void eat() {
		System.out.println("Eating Sugarcane");
		
	}

	@Override
	public void speak() {
		System.out.println("Trumpet noise");
		
	}

}
