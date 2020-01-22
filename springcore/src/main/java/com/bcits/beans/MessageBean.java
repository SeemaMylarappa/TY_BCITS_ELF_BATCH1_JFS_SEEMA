package com.bcits.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageBean implements InitializingBean,DisposableBean{
	
	private String message;
	
	//default constructor
	public MessageBean() {
		System.out.println("Is is instantiation phase");
	}

	//Getters and Setters
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("It is destruction phase!!");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("It is intialisation phase");
	}
	
	/*
	 * //init and destroy phase public void init() {
	 * System.out.println("It is intialisation phase"); }
	 * 
	 * public void destroy() { 
	 * System.out.println("It is destruction phase"); }
	 */
	
	

}//end of class
