package com.bcits.usecase.service;

import com.bcits.usecase.beans.EmployeeMaster;

public interface EmployeeService {
	
	public EmployeeMaster employeeLogin(String empId,String password);

}
