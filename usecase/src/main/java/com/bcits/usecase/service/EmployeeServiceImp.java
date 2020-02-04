package com.bcits.usecase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.usecase.beans.EmployeeMaster;
import com.bcits.usecase.dao.EmployeeDAO;

@Service
public class EmployeeServiceImp implements EmployeeService{

	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeMaster employeeLogin(String empId, String password) {
		
		return dao.employeeLogin(empId, password);
	}
	
	

}
