package com.bcits.usecase.table;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.usecase.bean.ConsumerMaster;

public class InsertConsumerData {
	
	public static void main(String[] args) {
		
		EntityTransaction transaction = null;
		
		ConsumerMaster data=new ConsumerMaster();
		data.setFirstName("Seema");
		data.setLastName("M");
		data.setMobileNo(9611997099L);
		data.setEmailId("seemamdvg@gmail.com");
		data.setRegion("Bangalore North");
		data.setAddressLine1("820/9b Samruddi");
		data.setAddressLine2("Jayanagar C Block");
		data.setRrNumber("N1AEH2553");
		data.setAccountId(1100157649);

		

		EntityManager manager = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projectpersistence");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(data);
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
