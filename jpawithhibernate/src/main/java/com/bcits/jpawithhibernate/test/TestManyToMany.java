package com.bcits.jpawithhibernate.test;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernate.manytomany.ProjectInfo;
import com.bcits.jpawithhibernate.onetoone.EmployeeSecondaryInfo;
import com.bcits.jpawithhibernateapp.bean.EmployeePrimaryInfo;

public class TestManyToMany {

	public static void main(String[] args) {

		EntityTransaction transaction = null;

		EmployeePrimaryInfo pr = new EmployeePrimaryInfo();
		pr.setEmp_id(142);
		pr.setDate_of_birth(java.sql.Date.valueOf("1990-02-06"));
		pr.setE_name("Suma");
		pr.setDept_id(20);
		pr.setDesignation("Developer");
		pr.setMobile_no(9966201347L);
		pr.setOfficialmail_id("suma@gamil.com");
		pr.setSalary(52000);
		pr.setDate_of_join(java.sql.Date.valueOf("2015-04-09"));
		pr.setManager_id(140);
		

		EmployeePrimaryInfo pr1 = new EmployeePrimaryInfo();
		pr1.setEmp_id(143);
		pr1.setDate_of_birth(java.sql.Date.valueOf("1997-08-06"));
		pr1.setE_name("Suman");
		pr1.setDept_id(10);
		pr1.setDesignation("Tester");
		pr1.setMobile_no(9976201347L);
		pr1.setOfficialmail_id("suman@gamil.com");
		pr1.setSalary(32000);
		pr1.setDate_of_join(java.sql.Date.valueOf("2019-09-09"));
		pr1.setManager_id(140);
		
		 ArrayList<EmployeePrimaryInfo> alEmployeeprimaryinfo=new ArrayList<EmployeePrimaryInfo>();
		 alEmployeeprimaryinfo.add(pr);
		 alEmployeeprimaryinfo.add(pr1);
		
		ProjectInfo pinfo=new ProjectInfo();
		pinfo.setP_id(11);
		pinfo.setProject_name("e-commerce");
		pinfo.setStart_date(java.sql.Date.valueOf("2019-01-01"));
		pinfo.setEnd_date(java.sql.Date.valueOf("2019-12-12"));
		pinfo.setLocation("Mumbai");
		pinfo.setTechnology("java");
		pinfo.setPrimaryInfo(alEmployeeprimaryinfo);
		
		ProjectInfo pinfo1=new ProjectInfo();
		pinfo1.setP_id(12);
		pinfo1.setProject_name("HM");
		pinfo1.setStart_date(java.sql.Date.valueOf("2019-01-01"));
		pinfo1.setEnd_date(java.sql.Date.valueOf("2019-12-12"));
		pinfo1.setLocation("Chennai");
		pinfo1.setTechnology("sql");
		pinfo1.setPrimaryInfo(alEmployeeprimaryinfo);
		
		 ArrayList<ProjectInfo> alprojectinfo=new ArrayList<ProjectInfo>();
		 alprojectinfo.add(pinfo);
		 alprojectinfo.add(pinfo1);
		

		EntityManager manager = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pass");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
		    manager.persist(pinfo);

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
