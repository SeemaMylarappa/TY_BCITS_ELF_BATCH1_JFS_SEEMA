package com.bcits.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bcits.springrest.beans.EmployeeInfoBean;
import com.bcits.springrest.beans.EmployeeResponse;
import com.bcits.springrest.service.EmployeeService;

/*@Controller*/
@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService service;

	@GetMapping(path = "/getEmployee", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	/* @ResponseBody */
	public EmployeeResponse getEmployee(int empId) {
		EmployeeInfoBean employeeInfoBean = service.getEmployee(empId);
		
		EmployeeResponse response=new EmployeeResponse();
		if(employeeInfoBean != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Employee Record Found for ID " +empId);
			response.setEmployeeInfoBean(employeeInfoBean);
			
		}else {
			response.setStatusCode(404);
			response.setMessage("Failed");
			response.setDescription("Employee ID not Found");
		}
		

		return response;

	}// end of getEmployee()
	
	@GetMapping(path="/getAllEmployee",
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	/* @ResponseBody */
	public EmployeeResponse getAllEmployees(){
		
		List<EmployeeInfoBean> employeeList=service.getAllEmployees();
		
		EmployeeResponse response=new EmployeeResponse();
		if(employeeList != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Employee Record fetched successfully ");
			response.setEmployeeList(employeeList);
			
		}else {
			response.setStatusCode(404);
			response.setMessage("Failed");
			response.setDescription("Employee Record not Found");
		}
		
		return response;
		
	}//end of getAllEmployees()
	
	@DeleteMapping(path = "/deleteEmployee/{employeeID}",
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse deleteEmployee(@PathVariable(name="employeeID")  int empId) {
		
		EmployeeResponse response=new EmployeeResponse();
		boolean isdeleted= service.deleteEmployee(empId);
		
		
		if (isdeleted) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Employee ID Deleted Successfully");
			
		}else {
			response.setStatusCode(404);
			response.setMessage("Failed");
			response.setDescription("Employee Record not Deleted");
		}
		
		
		return response;
		
	}//end of deleteEmployee()
	
	@PostMapping(path="/addEmployee",
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse addEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {
		
		EmployeeResponse response=new EmployeeResponse();
		boolean isAdded=service.addEmployee(employeeInfoBean);
		if (isAdded) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Employee ID Added Successfully");
			
		}else {
			response.setStatusCode(404);
			response.setMessage("Failed");
			response.setDescription("Employee ID not Found");
		}
		
		
		return response;
	}//end of addEmployee()
	
	@PutMapping(path="/updateEmployee",
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse updateEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {
	
		EmployeeResponse response=new EmployeeResponse();
	 boolean isUpdated=service.updateEmployee(employeeInfoBean);
	 if (isUpdated) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Employee ID Updated Successfully");
			
		}else {
			response.setStatusCode(404);
			response.setMessage("Failed");
			response.setDescription("Employee ID not Found");
		}
	 return response;
	}

}// end of controller
