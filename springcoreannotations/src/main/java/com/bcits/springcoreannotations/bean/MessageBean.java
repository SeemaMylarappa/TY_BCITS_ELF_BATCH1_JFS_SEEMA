package com.bcits.springcoreannotations.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Data;

@Data
public class MessageBean implements InitializingBean,DisposableBean {
	
	private String message;
	
	public MessageBean() {
		System.out.println("It is instantiation phase");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("It is destroy phase");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
	System.out.println("It is initialisation phase");
		
	}

}//end of class
