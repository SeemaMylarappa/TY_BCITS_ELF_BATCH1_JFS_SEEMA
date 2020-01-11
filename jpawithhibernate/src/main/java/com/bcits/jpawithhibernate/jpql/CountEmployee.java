package com.bcits.jpawithhibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CountEmployee {
	
	public static void main(String[] args) {
		
		EntityTransaction transaction = null;
		EntityManager manager = null;
	
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("pr");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String jpql = " select count(*) from EmployeePrimaryInfo ";
			Query query = manager.createQuery(jpql);

			query.getSingleResult();
			
			System.out.println(query.getSingleResult());
			
	}

}
