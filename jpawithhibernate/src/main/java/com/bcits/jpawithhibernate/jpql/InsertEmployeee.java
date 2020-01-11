package com.bcits.jpawithhibernate.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bcits.jpawithhibernateapp.bean.EmployeePrimaryInfo;

public class InsertEmployeee {

	public static void main(String[] args) {		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pr");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery(" from EmployeePrimaryInfo ");
		List<EmployeePrimaryInfo> list = query.getResultList();
		
		
		for (EmployeePrimaryInfo info : list) {
			System.out.println("EmployeeId:"+info.getEMP_ID());
			System.out.println("EmployeeName:"+info.getE_NAME());
			System.out.println("Employee phone number"+info.getMOBILE_NO());
			System.out.println("Employee mail id:"+info.getOFFICIAL_MAILID());
			System.out.println("salary:"+info.getSALARY());
			System.out.println("dept id:"+info.getDEPT_ID());
			System.out.println("designation:"+info.getDESIGNATION());
			System.out.println("manager id:"+info.getMANAGER_ID());
		}
		manager.close();
		
	}//end of main

}
