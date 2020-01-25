package com.bcits.springmvc.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.bcits.springmvc.DAO.EmployeeDAO;
import com.bcits.springmvc.bean.EmployeeInfoBean;

@Repository
public class EmployeeImpClass implements EmployeeDAO {
    
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean addEmployee(EmployeeInfoBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		EmployeeInfoBean employeeInfo = new EmployeeInfoBean();
		boolean isAdded = false;
		try {
			tx.begin();
			manager.persist(employeeInfo);
			tx.commit();
			isAdded = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			manager.close();

		}

		return isAdded;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		boolean isDeleted = false;
		
		EntityManager manager = factory.createEntityManager();
		EmployeeInfoBean employeeInfo = manager.find(EmployeeInfoBean.class, empId);
		if (employeeInfo != null) {
			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			manager.remove(employeeInfo);
			tx.commit();
			isDeleted = true;
		}

		manager.close();

		return isDeleted;

	}

	@Override
	
	 public boolean updateEmployee(EmployeeInfoBean bean) {
		return false;
	 
	 }
	 

	@Override
	public EmployeeInfoBean getEmployee(int empId) {
		EntityManager manager = factory.createEntityManager();
		EmployeeInfoBean employeeInfo = manager.find(EmployeeInfoBean.class, empId);
		manager.close();
		return employeeInfo;

	}

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		EntityManager manager = factory.createEntityManager();

		String jpql = " from EmployeeInfoBean  ";
		Query query = manager.createQuery(jpql);

		List<EmployeeInfoBean> list = query.getResultList();

		manager.close();
		return list;

	}// end of

	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		EntityManager manager = factory.createEntityManager();
		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, empId);

		if (employeeInfoBean != null && employeeInfoBean.getPassword().equals(password)) {
			return employeeInfoBean;

		} else {
			return null;
		}
	}// end of authenticate()

}
