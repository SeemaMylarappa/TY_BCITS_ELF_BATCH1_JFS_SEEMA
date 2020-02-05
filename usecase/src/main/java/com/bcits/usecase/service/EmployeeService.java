package com.bcits.usecase.service;

import java.util.List;

import com.bcits.usecase.beans.ConsumerMaster;
import com.bcits.usecase.beans.EmployeeMaster;

public interface EmployeeService {
	
	public EmployeeMaster employeeLogin(int empId,String password);
	public List<ConsumerMaster> consumerDetailsPage(String region);
}
