package com.bcits.usecase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class EntityManagerFactoryConfig {
	
	@Bean
	public LocalEntityManagerFactoryBean getEntityManagerFactoryBean() {

		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("projectpersistence");
		return factoryBean;

	}// end of getEntityManagerFactoryBean()

}
