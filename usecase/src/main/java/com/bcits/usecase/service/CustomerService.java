package com.bcits.usecase.service;

import java.util.Date;
import java.util.List;

import com.bcits.usecase.beans.BillHistoryBean;
import com.bcits.usecase.beans.ConsumerMaster;
import com.bcits.usecase.beans.CurrentBill;
import com.bcits.usecase.beans.MonthlyConsumption;


public interface CustomerService {
	
	public boolean consumerSignUp(ConsumerMaster consumerMaster,String password);
	public ConsumerMaster consumerLogin(String emailId,String pwd);
	public boolean payment(String rrNumber,Date date,int amount);
	public CurrentBill getCurrentBill(String rrNumber);
	public  List<MonthlyConsumption> getMonthlyConsumption(String rrNumber);
	public List<BillHistoryBean> getBillHistory(String rrNumber);
	

}
