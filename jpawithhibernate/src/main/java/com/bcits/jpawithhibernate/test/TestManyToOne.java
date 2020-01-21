package com.bcits.jpawithhibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernate.manytoone.EmployeeAddressInfo;
import com.bcits.jpawithhibernate.manytoone.EmployeeAddressPK;
import com.bcits.jpawithhibernate.onetoone.EmployeeSecondaryInfo;
import com.bcits.jpawithhibernateapp.bean.EmployeePrimaryInfo;

public class TestManyToOne {
	
	public static void main(String[] args) {
		
		EntityTransaction transaction = null;

		EmployeePrimaryInfo pr = new EmployeePrimaryInfo();
		pr.setEMP_ID(121);
		pr.setE_NAME("Parthav");
		pr.setDATE_OF_BIRTH(java.sql.Date.valueOf("1997-08-20"));
		pr.setDATE_OF_JOIN(java.sql.Date.valueOf("2019-04-23"));
		pr.setDEPT_ID(121);
		pr.setDESIGNATION("Developer");
		pr.setMANAGER_ID(131);                          																			
		pr.setMOBILE_NO(9632012011L);
		pr.setOFFICIAL_MAILID("parthav@gmail.com");
		pr.setSALARY(55000);
		
		EmployeeAddressPK addressPk=new EmployeeAddressPK();
		addressPk.setEMP_ID(121);
		addressPk.setADDRESS_TYPE("current_add");
		
		EmployeeAddressInfo address=new EmployeeAddressInfo();
		address.setAddressPK(addressPk);
		address.setADDRESS1("13th main");
		address.setHOUSE_NO(125);
		address.setADDRESS2("43rd cross");
		address.setCITY("vijayvada");
		address.setPINCODE(577992);
		address.setPrimaryinfo(pr);
		
		EntityManager manager = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test1");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(address);
			
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
