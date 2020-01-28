package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;

public class EmployeeJSONMarshalling {
	
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
		
		//marshalling 
		
		
		try {
			ObjectMapper mapper=new ObjectMapper();
			mapper.writerWithDefaultPrettyPrinter();  //formated JSON Object
			mapper.writeValue(new File("empJson5.json"), employeeInfoBean);
			mapper.writeValue(System.out, employeeInfoBean);
		} catch (IOException e) {
			e.printStackTrace();
			
		} 	
		
		
	}//end of main()

}//end of class
