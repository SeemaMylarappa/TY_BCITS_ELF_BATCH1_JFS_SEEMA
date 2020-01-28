package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeJSONUnmarshalling {
	
	public static void main(String[] args) {
		
		try {
			ObjectMapper mapper=new ObjectMapper();
			EmployeeInfoBean employeeInfoBean=mapper.readValue(new File("empJson3.json"), EmployeeInfoBean.class);
		
			System.out.println("ID = " + employeeInfoBean.getEmpId());
			System.out.println("Name = " +employeeInfoBean.getEName());
			System.out.println("DOB = " +employeeInfoBean.getDateOfBirth());
		   System.out.println("Password =" + employeeInfoBean.getPassword());
		
		
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
