package com.bcits.usecase.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.bcits.usecase.beans.ConsumerMaster;
import com.bcits.usecase.beans.EmployeeMaster;

@Repository
public interface EmployeeDAO {
	
	
	public EmployeeMaster employeeLogin(int empId,String password);
	public List<ConsumerMaster> consumerDetailsPage(String region);
	
}
