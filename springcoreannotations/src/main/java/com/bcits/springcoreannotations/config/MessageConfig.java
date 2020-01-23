package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bcits.springcoreannotations.bean.MessageBean;
import com.bcits.springcoreannotations.mypostprocessor.MyBeanFactoryPostProcessor;
import com.bcits.springcoreannotations.mypostprocessor.MyBeanPostProcessor;

@Configuration
public class MessageConfig {
	
	@Bean(name="messageBean")
	public MessageBean getMessageBean() {
		
		MessageBean messageBean =new MessageBean();
		messageBean.setMessage("Welcome back to Spring Core...");
		return messageBean;
		
	}//end of getMessageBean()
	
	@Bean
	public MyBeanPostProcessor getMyBPP() {
		return new MyBeanPostProcessor();
	}
	
	@Bean
	public MyBeanFactoryPostProcessor  getMyBFPP() {
		return new MyBeanFactoryPostProcessor();
	}
	
	

}//end of class
