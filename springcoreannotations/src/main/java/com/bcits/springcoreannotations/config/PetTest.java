package com.bcits.springcoreannotations.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bcits.springcoreannotations.bean.Pet;

public class PetTest {

	public static void main(String[] args) {
		
		ApplicationContext context=new AnnotationConfigApplicationContext(PetConfig.class);
		Pet myPet=context.getBean(Pet.class);
		
		System.out.println("Pet Name = " +myPet.getName());
		myPet.getAnimal().speak();
		myPet.getAnimal().eat();
	}
}
