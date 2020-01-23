package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import com.bcits.springcoreannotations.bean.DepartmentBean;
import com.bcits.springcoreannotations.bean.EmployeeBean;

@Import(DepartmentConfig.class)
@Configuration
public class EmployeeConfig2 {

	@Bean
	public EmployeeBean getEmployeeBean() {

		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setName("Abhilash");
		employeeBean.setAge(22);

		/* employeeBean.setDepartmentBean(getDepartmentBean()); */

		return employeeBean;

	}// end of getEmployeeBean()

	
}// end of class
