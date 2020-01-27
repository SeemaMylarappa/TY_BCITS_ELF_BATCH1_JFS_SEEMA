package com.bcits.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class EntityManagerFactoryConfig {
	
	
	  @Bean 
	  public LocalEntityManagerFactoryBean getEntityManager() {
		  LocalEntityManagerFactoryBean factoryBean=new
				  LocalEntityManagerFactoryBean();
	  factoryBean.setPersistenceUnitName("emsPersistenceUnit");
	  
	  return factoryBean; }//end of class
	 
	
//	  @Bean public LocalContainerEntityManagerFactoryBean
//	  getEntityManagerFactoryBean() { LocalContainerEntityManagerFactoryBean
//	  factoryBean=new LocalContainerEntityManagerFactoryBean();
//	  factoryBean.setPersistenceUnitName("emsPersistenceUnit"); return factoryBean;
//	  
//	  }//end of getEntityManagerFactoryBean()
	 
}
