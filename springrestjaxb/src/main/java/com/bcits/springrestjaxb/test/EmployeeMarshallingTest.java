package com.bcits.springrestjaxb.test;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeMarshallingTest {

	public static void main(String[] args) {

		EmployeeInfoBean employeeInfoBean = new EmployeeInfoBean();
		employeeInfoBean.setEmpId(999);
		employeeInfoBean.setEName("Pooja");
		employeeInfoBean.setDateOfBirth(new Date());
		employeeInfoBean.setDateOfJoin(new Date());
		employeeInfoBean.setDepartmentId(20);
		employeeInfoBean.setDesignation("Developer");
		employeeInfoBean.setManagerId(120);
		employeeInfoBean.setMobile(9631234567L);
		employeeInfoBean.setSalary(32000);
		employeeInfoBean.setOfficialMailid("pooja@gmail.com");
		employeeInfoBean.setPassword("qwerty");

		try {
			JAXBContext context = JAXBContext.newInstance(EmployeeInfoBean.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// For Formatted XML
			marshaller.marshal(employeeInfoBean, System.out);
			marshaller.marshal(employeeInfoBean, new File("employeeInfo.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
			System.out.println("Unable to Marshaal");

		}

	}// end of main

}// end of class
