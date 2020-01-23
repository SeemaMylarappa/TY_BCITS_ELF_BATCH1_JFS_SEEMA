package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bcits.springcoreannotations.bean.EmployeeBean;

@Configuration
public class EmployeeConfig {
	@Bean
	/* @Scope("prototype") */
	public EmployeeBean getEmployeeBean() {

		EmployeeBean employeeBean = new EmployeeBean();
		/*
		 * employeeBean.setName("Asin"); employeeBean.setAge(16);
		 */

		return employeeBean;

	}// end of getEmployeeBean()

}// end of class
