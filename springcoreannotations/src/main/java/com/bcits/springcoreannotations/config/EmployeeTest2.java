package com.bcits.springcoreannotations.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bcits.springcoreannotations.bean.EmployeeBean;

public class EmployeeTest2 {
	
	public static void main(String[] args) {
		
		ApplicationContext context=new AnnotationConfigApplicationContext(EmployeeConfig2.class);
		EmployeeBean employeeBean= context.getBean(EmployeeBean.class);
		
		System.out.println("Name = " + employeeBean.getName());
		System.out.println("Age= " + employeeBean.getAge());
		System.out.println("Dept Name = " + employeeBean.getDepartmentBean().getDeptName());
		System.out.println("Dept ID = " + employeeBean.getDepartmentBean().getDeptId());
		
		
	}//end of main()

}//end of class
