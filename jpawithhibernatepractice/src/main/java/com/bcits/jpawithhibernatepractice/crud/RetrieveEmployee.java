package com.bcits.jpawithhibernatepractice.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateprac.bean.EmployeePrimaryInfo;

public class RetrieveEmployee {
	
	public static void main(String[] args) {
		
		
		
			EntityManagerFactory entitymanagerfactor=Persistence.createEntityManagerFactory("pr");
			EntityManager manager = entitymanagerfactor.createEntityManager();
//		InsertEmployee emp=manager.find(InsertEmployee.class, 900);
			
			EmployeePrimaryInfo emp=manager.getReference(EmployeePrimaryInfo.class, 900);
			
			System.out.println(emp.getE_NAME());
			
			System.out.println(emp.getClass());
			
//			System.out.println("Employee DOB:"+emp.getDATE_OF_BIRTH());
//			System.out.println("Employee ID:"+emp.getEMP_ID());
//			System.out.println("Employee name:"+emp.getE_NAME());
//			System.out.println("Employee emailid:"+emp.getOFFICIAL_MAILID());
//			System.out.println("Employee manager id"+emp.getMANAGER_ID());
//			System.out.println("Employee designation:"+emp.getDESIGNATION());
//			System.out.println("employee department id:"+emp.getDEPT_ID());
//			System.out.println("Employee salary:"+emp.getSALARY());
			
		manager.close();
		
		
	}//end of main

}//end of class
