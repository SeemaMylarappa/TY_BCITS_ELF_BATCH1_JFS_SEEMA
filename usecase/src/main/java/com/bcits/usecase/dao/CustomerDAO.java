package com.bcits.usecase.dao;

import java.util.Date;
import java.util.List;

import com.bcits.usecase.beans.BillHistoryBean;
import com.bcits.usecase.beans.BillHistoryPK;
import com.bcits.usecase.beans.ConsumerMaster;
import com.bcits.usecase.beans.CurrentBill;
import com.bcits.usecase.beans.MonthlyConsumption;


public interface CustomerDAO {
	
	public boolean consumerSignUp(ConsumerMaster consumer,String password);
	public ConsumerMaster consumerLogin(String emailId,String password);
	public boolean payment(String rrNumber,Date date,int amount);
	public CurrentBill getCurrentBill(String rrNumber);
	public List<MonthlyConsumption> getMonthlyConsumption(String rrNumber);
	public List<BillHistoryBean> getBillHistory(String rrNumber);
	public ConsumerMaster getRRNumber(String rrNumber);
    public double previousReading(String rrNumber); 
}
