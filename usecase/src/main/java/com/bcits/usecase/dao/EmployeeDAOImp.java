package com.bcits.usecase.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.usecase.beans.ConsumerMaster;
import com.bcits.usecase.beans.EmployeeMaster;

@Repository
public class EmployeeDAOImp implements EmployeeDAO{
	
	@PersistenceUnit
	EntityManagerFactory factoryBean;


	@Override
	public EmployeeMaster employeeLogin(String empId, String password) {
		EntityManager manager=factoryBean.createEntityManager();
		Query query = manager.createQuery(" from EmployeeMaster where empId= :empId  ");
		query.setParameter("empId", empId);
		EmployeeMaster employeeMaster=(EmployeeMaster) query.getSingleResult();
		if (employeeMaster != null && employeeMaster.getPassword().equals(password)) {
			return employeeMaster;	
		}
		manager.close();
		return null;
	}

}
