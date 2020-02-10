package com.bcits.usecase.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.usecase.beans.ConsumerMaster;
import com.bcits.usecase.beans.CurrentBill;
import com.bcits.usecase.beans.EmployeeMaster;
import com.bcits.usecase.beans.QueryInfoBean;
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

	@Override
	public boolean currentBillGeneration(CurrentBill currentBill ,String region) {
		
		return dao.currentBillGeneration(currentBill,region);
	}

	@Override
	public List<QueryInfoBean> queryList(String region) {
		
		return dao.queryList(region);
	}

	@Override
	public boolean queryResponse(String rrNumber, String response, Date date) {
		
		return dao.queryResponse(rrNumber, response, date);
	}

	

	
	
	
	

}
