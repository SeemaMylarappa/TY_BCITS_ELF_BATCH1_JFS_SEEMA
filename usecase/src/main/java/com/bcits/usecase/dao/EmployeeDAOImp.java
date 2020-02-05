package com.bcits.usecase.dao;

import java.util.List;

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
	public EmployeeMaster employeeLogin(int empId, String password) {
		EntityManager manager=factoryBean.createEntityManager();
		String jpql=" from EmployeeMaster where empId= :empId ";
		Query query = manager.createQuery(jpql);
		query.setParameter("empId", empId);
		EmployeeMaster employeeMaster=(EmployeeMaster) query.getSingleResult();
		if (employeeMaster != null && employeeMaster.getPassword().equals(password)) {
			return employeeMaster;	
		}
		manager.close();
		return null;
	}


	@Override
	public List<ConsumerMaster> consumerDetailsPage(String region) {
		 System.out.println(region);
			EntityManager manager=factoryBean.createEntityManager();
		String jpql	=" from ConsumerMaster where region = :region ";
			 Query query=manager.createQuery(jpql);
			query.setParameter("region", region);
		List<ConsumerMaster> consumerMaster=(List<ConsumerMaster>)query.getResultList();
		System.out.println(consumerMaster);
			if (consumerMaster != null) {
				return consumerMaster;	
			}
			manager.close();
			return null;
	}

}
