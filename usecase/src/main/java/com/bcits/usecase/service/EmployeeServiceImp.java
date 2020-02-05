package com.bcits.usecase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.usecase.beans.ConsumerMaster;
import com.bcits.usecase.beans.EmployeeMaster;
import com.bcits.usecase.dao.EmployeeDAO;

@Service
public class EmployeeServiceImp implements EmployeeService{

	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeMaster employeeLogin(int empId, String password) {
		
		return dao.employeeLogin(empId, password);
	}

	@Override
	public List<ConsumerMaster> consumerDetailsPage(String region) {
		
		return dao.consumerDetailsPage(region);
	}
	
	

}
