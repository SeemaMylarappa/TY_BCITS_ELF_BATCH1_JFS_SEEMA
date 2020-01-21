package com.bcits.jpawithhibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernate.onetoone.EmployeeBankInfo;
import com.bcits.jpawithhibernateapp.bean.EmployeePrimaryInfo;

public class EmployeeOneToOne {
	
	public static void main(String[] args) {
		
		EntityTransaction transaction = null;

		EmployeePrimaryInfo pr = new EmployeePrimaryInfo();
		pr.
		pr.setE_NAME("Mahesh");
		pr.setDATE_OF_BIRTH(java.sql.Date.valueOf("1998-04-10"));
		pr.setDATE_OF_JOIN(java.sql.Date.valueOf("2022-04-20"));
		pr.setDEPT_ID(180);
		pr.setDESIGNATION("HR");
		pr.setMANAGER_ID(120);                          																			
		pr.setMOBILE_NO(9632014021L);
		pr.setOFFICIAL_MAILID("suhana@gmail.com");
		pr.setSALARY(45000);
		
		EmployeeBankInfo bank=new EmployeeBankInfo();
		bank.setACCOUNT_NO(123045698712L);
		bank.setBANK_NAME("canara_bank");
		bank.setBRANCH_NAME("pb_road");
		bank.setIFSC_CODE("120f963h");
		bank.setPrimary(pr);
		
		
	  EntityManager manager = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			//manager.persist(bank);
			
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
