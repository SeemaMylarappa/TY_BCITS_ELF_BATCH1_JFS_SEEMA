package com.bcits.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp.bean.EmployeePrimaryInfo;

public class FindEmployee {
	public static void main(String[] args) {

		EntityManagerFactory entitymanagerFactory = Persistence.createEntityManagerFactory("pr");
		EntityManager manager = entitymanagerFactory.createEntityManager();
		EmployeePrimaryInfo info = manager.find(EmployeePrimaryInfo.class, 10);

		System.out.println("Employee id=" + info.getE_NAME());
		System.out.println("Employee_name=" + info.getE_NAME());

		manager.close();

	}// end of main
}// end of class
