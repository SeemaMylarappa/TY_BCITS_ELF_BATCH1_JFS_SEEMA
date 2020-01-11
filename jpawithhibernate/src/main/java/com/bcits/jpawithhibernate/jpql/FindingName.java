package com.bcits.jpawithhibernate.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bcits.jpawithhibernateapp.bean.EmployeePrimaryInfo;

public class FindingName {

	public static void main(String[] args) {
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("pr");
		EntityManager manager=factory.createEntityManager();
		String jpql=" select E_NAME from EmployeePrimaryInfo ";
		Query query=manager.createQuery(jpql);
		
		List<String> list=query.getResultList();
		
		
		for (String info : list) {
			
			System.out.println(info);
}
		manager.close();
		
	}
}
