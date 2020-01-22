package com.bcits.springcore;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bcits.beans.EmployeeBean;

public class EmployeeTest {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		
		EmployeeBean employeeBean =(EmployeeBean) context.getBean("employee");
		
		System.out.println("Enter Name : ");
		employeeBean.setName(sc.nextLine());
		System.out.println("Enter Age : ");
		employeeBean.setAge(sc.nextInt());
		sc.nextLine();
		
		EmployeeBean employeeBean2=(EmployeeBean) context.getBean("employee");
		System.out.println("Enter Name : ");
		employeeBean2.setName(sc.nextLine());
		System.out.println("Enter Age : ");
		employeeBean2.setAge(sc.nextInt());
		
				
		
		System.out.println(" Name = " + employeeBean.getName());
		System.out.println(" Age = " + employeeBean.getAge());
	    System.out.println(" Name = " + employeeBean2.getName());
		System.out.println(" Age = " + employeeBean2.getAge());
		
	}

}
