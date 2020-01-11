package com.bcits.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp.bean.EmployeePrimaryInfo;

public class InsertEmployee {
	public static void main(String[] args) {
		EntityTransaction transaction = null;

		EmployeePrimaryInfo pr = new EmployeePrimaryInfo();
		pr.setEMP_ID(180);
		pr.setE_NAME("Suhana");
		pr.setDATE_OF_BIRTH(java.sql.Date.valueOf("1999-03-19"));
		pr.setDATE_OF_JOIN(java.sql.Date.valueOf("2022-04-20"));
		pr.setDEPT_ID(180);
		pr.setDESIGNATION("HR");
		pr.setMANAGER_ID(120);                          																			
		pr.setMOBILE_NO(9632014021L);
		pr.setOFFICIAL_MAILID("suhana@gmail.com");
		pr.setSALARY(45000);

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
