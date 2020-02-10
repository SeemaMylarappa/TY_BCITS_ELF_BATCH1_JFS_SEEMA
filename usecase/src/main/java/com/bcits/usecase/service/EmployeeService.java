package com.bcits.usecase.service;

import java.util.Date;
import java.util.List;

import com.bcits.usecase.beans.ConsumerMaster;
import com.bcits.usecase.beans.CurrentBill;
import com.bcits.usecase.beans.EmployeeMaster;
import com.bcits.usecase.beans.QueryInfoBean;

public interface EmployeeService {
	
	public EmployeeMaster employeeLogin(int empId,String password);
	public List<ConsumerMaster> consumerDetailsPage(String region);
	public boolean currentBillGeneration(CurrentBill currentBill, String region);
	public List<QueryInfoBean> queryList(String region);
	public boolean queryResponse(String rrNumber,String response,Date date);
}
