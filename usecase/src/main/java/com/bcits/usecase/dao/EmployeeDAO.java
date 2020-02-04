package com.bcits.usecase.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.bcits.usecase.beans.ConsumerMaster;
import com.bcits.usecase.beans.EmployeeMaster;

@Repository
public interface EmployeeDAO {
	
	
	public EmployeeMaster employeeLogin(String empId,String password);
}
