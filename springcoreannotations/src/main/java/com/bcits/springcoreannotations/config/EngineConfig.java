package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bcits.springcoreannotations.bean.Engine;

@Configuration
public class EngineConfig {
	
	@Bean
	public Engine getEngine() {
		Engine engine=new Engine();
		engine.setCc(2300);
		engine.setType("Diesel");
		
		return engine;
		
	}//end of getEngine()
	
	
	

}//end of class
