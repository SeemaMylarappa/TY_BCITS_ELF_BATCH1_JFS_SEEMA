package com.bcits.usecase.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.swing.plaf.synth.Region;

import org.springframework.stereotype.Repository;

import com.bcits.usecase.beans.ConsumerMaster;
import com.bcits.usecase.beans.CurrentBill;
import com.bcits.usecase.beans.EmployeeMaster;
import com.bcits.usecase.beans.QueryInfoBean;

@Repository
public interface EmployeeDAO {
	
	
	public EmployeeMaster employeeLogin(int empId,String password);
	public List<ConsumerMaster> consumerDetailsPage(String region);
	public boolean currentBillGeneration(CurrentBill currentBill, String region);
	public boolean queryResponse(String rrNumber,String response,Date date);
	public List<QueryInfoBean> queryList(String region);
}
