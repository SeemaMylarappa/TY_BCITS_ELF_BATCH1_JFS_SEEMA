package com.bcits.springcoreannotations.bean;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class Car {
	
	private String company;
	@Autowired
	 private Engine engine;

}
