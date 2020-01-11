package com.bcits.jpawithhibernatepractice.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateprac.bean.InsertEmployee;

public class EmployeePrimaryInfo {
	public static void main(String[] args) {
		EntityTransaction transaction = null;

		InsertEmployee pr = new InsertEmployee();
		pr.setEMP_ID(170);
		pr.setE_NAME("Suresh");
		pr.setDATE_OF_BIRTH(java.sql.Date.valueOf("2000-05-29"));
		pr.setDATE_OF_JOIN(java.sql.Date.valueOf("2021-07-27"));
		pr.setDEPT_ID(500);
		pr.setDESIGNATION("Tester");
		pr.setMANAGER_ID(501);
		pr.setMOBILE_NO(996677001);
		pr.setOFFICIAL_MAILID("suresh@gmail.com");
		pr.setSALARY(25000);

		EntityManager manager = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pr");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(pr);
			System.out.println("Record saved");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

	}
}
