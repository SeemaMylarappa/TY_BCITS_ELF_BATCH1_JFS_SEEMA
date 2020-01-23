package com.bcits.springcoreannotations.config;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bcits.springcoreannotations.bean.EmployeeBean;

public class EmployeeTest {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		
		ApplicationContext context=new AnnotationConfigApplicationContext(EmployeeConfig.class);
	    ((ConfigurableApplicationContext)context).registerShutdownHook();
		
		EmployeeBean employeeBean1=context.getBean(EmployeeBean.class);
		System.out.println("Enter Employee1 Name: ");
		employeeBean1.setName(sc.nextLine());
		System.out.println(" Enter Employee1 age");
		employeeBean1.setAge(sc.nextInt());
		sc.nextLine();
		
		EmployeeBean employeeBean2=context.getBean(EmployeeBean.class);
		System.out.println("Enter Employee2 Name: ");
		employeeBean2.setName(sc.nextLine());
		System.out.println("Enter Employee2 Age: ");
		employeeBean2.setAge(sc.nextInt());
		
		
		System.out.println("Employee1 Name = " +employeeBean1.getName());
		System.out.println("Employee1 Age = " +employeeBean1.getAge());
		System.out.println("-------------------------------------");
		System.out.println("Employee2 Name = " +employeeBean2.getName());
		System.out.println("Employee2 Age = " +employeeBean2.getAge());
	}

}
