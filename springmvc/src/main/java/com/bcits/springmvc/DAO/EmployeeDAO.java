package com.bcits.springmvc.DAO;

import java.util.List;

import com.bcits.springmvc.bean.EmployeeInfoBean;

public interface EmployeeDAO {
	
	public EmployeeInfoBean authenticate(int empId,String password);
	
	public boolean addEmployee(EmployeeInfoBean bean);
	public boolean deleteEmployee(int empId);
	public boolean updateEmployee(EmployeeInfoBean bean);
	public EmployeeInfoBean getEmployee(int empId);
	public List<EmployeeInfoBean> getAllEmployees();

}
