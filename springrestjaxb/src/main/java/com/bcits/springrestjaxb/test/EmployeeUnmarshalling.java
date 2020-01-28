package com.bcits.springrestjaxb.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeUnmarshalling {
	
	public static void main(String[] args) {
		
		try {
			JAXBContext jaxbContext=JAXBContext.newInstance(EmployeeInfoBean.class);
			Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
			EmployeeInfoBean employeeInfoBean=(EmployeeInfoBean) unmarshaller.unmarshal(new File("employeeInfo2.xml"));
			
			System.out.println("Emp ID = " + employeeInfoBean.getEmpId());
			System.out.println("Emp Name = " + employeeInfoBean.getEName());
			System.out.println("Emp Designation = " + employeeInfoBean.getDesignation());
			System.out.println("Emp Salary = " + employeeInfoBean.getSalary());
			System.out.println("DOB = " +employeeInfoBean.getDateOfBirth());
		} catch (JAXBException e) {
			e.printStackTrace();
			
		}
		
	}//end of main

}//end of class
