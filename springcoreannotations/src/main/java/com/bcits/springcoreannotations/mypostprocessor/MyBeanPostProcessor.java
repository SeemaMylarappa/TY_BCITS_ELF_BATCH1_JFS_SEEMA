package com.bcits.springcoreannotations.mypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{
	
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
	System.out.println("Before init-phase");	
	return bean;
	
		}//end of postProcessBeforeInitialization()
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
	System.out.println("After init-phase");	
	return bean;	
		
	}//end of postProcessAfterInitialization()
	
	

}//end of class
