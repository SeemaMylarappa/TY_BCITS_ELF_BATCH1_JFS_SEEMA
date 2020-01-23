package com.bcits.springcoreannotations.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.Data;

@Data
public class EmployeeBean {
	
	private String name;
	private int age;
	
	@Autowired(required = false)
	@Qualifier("hr")
	private DepartmentBean departmentBean;
	
	/*
	 * @PostConstruct public void init() {
	 * System.out.println("Its is intialisation phase"); }
	 * 
	 * @PreDestroy public void destroy() {
	 * System.out.println("It id destroy phase"); }
	 */

}//end of class
