package com.bcits.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.springrest.beans.EmployeeInfoBean;
import com.bcits.springrest.dao.EmployeeDAO;
import com.bcits.springrest.exceptions.EmployeeException;
@Service
public class EmployeeImpService implements EmployeeService{
	
	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		
		return dao.authenticate(empId, password);
	}

	@Override
	public boolean addEmployee(EmployeeInfoBean bean) {
		
		return dao.addEmployee(bean);
	}

	@Override
	public boolean deleteEmployee(int empId) {
		
		return dao.deleteEmployee(empId);
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean bean) {
		
		return dao.updateEmployee(bean);
	}

	@Override
	public EmployeeInfoBean getEmployee(int empId) {
		
		if(empId<1) {
			throw new EmployeeException("Invalid Employee ID");
		}
		
		return dao.getEmployee(empId);
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		
		return dao.getAllEmployees();
	}

}
