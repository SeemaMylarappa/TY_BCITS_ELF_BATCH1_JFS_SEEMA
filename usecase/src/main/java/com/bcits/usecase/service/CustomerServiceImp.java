package com.bcits.usecase.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.usecase.beans.BillHistoryBean;
import com.bcits.usecase.beans.ConsumerMaster;
import com.bcits.usecase.beans.CurrentBill;
import com.bcits.usecase.beans.MonthlyConsumption;

import com.bcits.usecase.dao.CustomerDAO;

@Service
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	private CustomerDAO dao;

	@Override
	public boolean consumerSignUp(ConsumerMaster consumerMaster, String password) {
		
		return dao.consumerSignUp(consumerMaster, password);
	}

	@Override
	public ConsumerMaster consumerLogin(String emailID, String password) {
				return dao.consumerLogin(emailID, password);
	}

	

	@Override
	public CurrentBill getCurrentBill(String rrNumber) {
		
		return dao.getCurrentBill(rrNumber);
	}

	@Override
	public List<MonthlyConsumption> getMonthlyConsumption(String rrNumber) {
		
		return dao.getMonthlyConsumption(rrNumber);
	}

	@Override
	public List<BillHistoryBean> getBillHistory(String rrNumber) {
		
		return dao.getBillHistory(rrNumber);
	}

	@Override
	public boolean payment(String rrNumber, Date date, int amount) {
		
		return dao.payment(rrNumber, date, amount);
	}

	@Override
	public ConsumerMaster getRRNumber(String rrNumber) {
		
		return dao.getRRNumber(rrNumber);
	}

	@Override
	public double previousReading(String rrNumber) {
		
		return 0;
	}

	@Override
	public List<MonthlyConsumption> getGeneratedBills(String region) {
		
		return dao.getGeneratedBills(region);
	}

	@Override
	public boolean querySupport(String msg, String rrNumber, String region) {
		
		return dao.querySupport(msg, rrNumber, region);
	}

	

}
