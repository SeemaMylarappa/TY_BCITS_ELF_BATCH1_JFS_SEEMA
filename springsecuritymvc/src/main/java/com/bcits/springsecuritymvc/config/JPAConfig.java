package com.bcits.springsecuritymvc.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class JPAConfig {
	
	@Bean
	public LocalEntityManagerFactoryBean getEntityManagerFactoryBean() {
		LocalEntityManagerFactoryBean factorybean = new LocalEntityManagerFactoryBean();
		factorybean.setPersistenceUnitName("emsPersistenceUnit");
		return factorybean;
	}

}
