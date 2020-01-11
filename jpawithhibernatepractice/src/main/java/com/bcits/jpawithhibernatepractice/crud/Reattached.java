package com.bcits.jpawithhibernatepractice.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateprac.bean.EmployeePrimaryInfo;

public class Reattached {
	
	public static void main(String[] args) {
		
		EntityManager manager=null;
		EntityTransaction transaction=null;
		
		try {
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("pr");
			manager = factory.createEntityManager();
			 transaction=manager.getTransaction();
			transaction.begin();

			EmployeePrimaryInfo emp=manager.find(EmployeePrimaryInfo.class,100);
			System.out.println(manager.contains(emp));
			manager.detach(emp);
			System.out.println(manager.contains(emp));
			EmployeePrimaryInfo reattached=manager.merge(emp);
			emp.setDEPT_ID(350);
			System.out.println("executed");
			
			
			
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			transaction.rollback();
		}finally {
			manager.close();
		}
		
		
		
	}

}
