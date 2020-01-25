package com.bcits.springmvc.service;

import java.util.List;

import com.bcits.springmvc.bean.EmployeeInfoBean;

public interface EmployeeService {

public EmployeeInfoBean authenticate(int empId,String password);
	
	public boolean addEmployee(EmployeeInfoBean bean);
	public boolean deleteEmployee(int empId);
	public boolean updateEmployee(EmployeeInfoBean bean);
	public EmployeeInfoBean getEmployee(int empId);
	public List<EmployeeInfoBean> getAllEmployees();
	
}//end of service
