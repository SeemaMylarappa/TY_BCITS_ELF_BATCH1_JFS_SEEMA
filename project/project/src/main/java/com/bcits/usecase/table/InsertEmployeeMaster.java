package com.bcits.usecase.table;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.usecase.bean.ConsumerMaster;
import com.bcits.usecase.bean.EmployeeMaster;

public class InsertEmployeeMaster {

	public static void main(String[] args) {

		EntityTransaction transaction = null;

		EmployeeMaster emp = new EmployeeMaster();

		EntityManager manager = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projectpersistence");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(emp);
			System.out.println("Record saved");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

	}// end of main

}// end of class
