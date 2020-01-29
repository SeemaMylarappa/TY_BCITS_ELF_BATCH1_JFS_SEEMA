package com.bcits.springrest.dao;

import java.util.List;

import com.bcits.springrest.beans.EmployeeInfoBean;

public interface EmployeeDAO {
	
public EmployeeInfoBean authenticate(int empId,String password);
	
	public boolean addEmployee(EmployeeInfoBean bean);
	public boolean deleteEmployee(int empId);
	public boolean updateEmployee(EmployeeInfoBean bean);
	public EmployeeInfoBean getEmployee(int empId);
	public List<EmployeeInfoBean> getAllEmployees();

}
