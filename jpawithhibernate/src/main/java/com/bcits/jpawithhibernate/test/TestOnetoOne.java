package com.bcits.jpawithhibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernate.onetoone.EmployeeSecondaryInfo;
import com.bcits.jpawithhibernateapp.bean.EmployeePrimaryInfo;

public class TestOnetoOne {
	
	public static void main(String[] args) {
		
		EntityTransaction transaction = null;

		EmployeePrimaryInfo pr = new EmployeePrimaryInfo();
		pr.setEMP_ID(510);
		pr.setE_NAME("Umesh");
		pr.setDATE_OF_BIRTH(java.sql.Date.valueOf("1998-04-10"));
		pr.setDATE_OF_JOIN(java.sql.Date.valueOf("2022-04-20"));
		pr.setDEPT_ID(180);
		pr.setDESIGNATION("HR");
		pr.setMANAGER_ID(120);                          																			
		pr.setMOBILE_NO(9632014021L);
		pr.setOFFICIAL_MAILID("suhana@gmail.com");
		pr.setSALARY(45000);
		
		EmployeeSecondaryInfo info=new EmployeeSecondaryInfo();
		
		info.setGOVT_ID("adhaar");
		info.setGUARDIAN_CONTACT(963254178);
		info.setMARITAL_STATUS("single");
		info.setGUARDIAN_NAME("manoj");
		info.setJOB_LOCATION("chennai");
		info.setNATIONALITY("indian");
		info.setPERSONAL_MAILID("uma@gmail.com");
		info.setAGE(23);
        info.setGENDER("male");	
        info.setPrimary(pr);
		

		EntityManager manager = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(info);
			System.out.println("Record saved");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}
	}//end of main

}//end of class
