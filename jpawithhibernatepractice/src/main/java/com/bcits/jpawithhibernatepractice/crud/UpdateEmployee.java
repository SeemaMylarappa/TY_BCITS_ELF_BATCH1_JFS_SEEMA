package com.bcits.jpawithhibernatepractice.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateprac.bean.EmployeePrimaryInfo;

public class UpdateEmployee {
	public static void main(String[] args) {

		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("pr");
			manager = entitymanagerfactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			EmployeePrimaryInfo imp = manager.find(EmployeePrimaryInfo.class, 30);
			imp.setSALARY(63000);
			transaction.commit();
			System.out.println("Record updated");
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

	}// end of main

}// end of class
