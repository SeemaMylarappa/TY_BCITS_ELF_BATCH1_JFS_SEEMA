package com.bcits.jpawithhibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateRecord {
	
	public static void main(String[] args) {
		EntityTransaction transaction=null;
		EntityManager manager=null;
		 try {
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("pr");
			 manager=factory.createEntityManager();
			  transaction=manager.getTransaction();
			 transaction.begin();
			 String jpql="update EmployeePrimaryInfo set E_NAME='gagan' where EMP_ID=10";
			 Query query=manager.createQuery(jpql);
			 int count=query.executeUpdate();
			 System.out.println("No of rows affected===="+count);
			 transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			transaction.rollback();
		}finally {
			manager.close();
		}
	}//end of main

}//end of class
