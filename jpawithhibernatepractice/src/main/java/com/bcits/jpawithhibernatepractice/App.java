package com.bcits.jpawithhibernatepractice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateprac.bean.Practice;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Practice pr=new Practice();
       pr.setEMP_ID(200);
       pr.setE_NAME("Sneha");
       pr.setDATE_OF_BIRTH(java.sql.Date.valueOf("2000-01-23"));
       pr.setDATE_OF_JOIN(java.sql.Date.valueOf("2020-05-24"));
       pr.setDEPT_ID(200);
       pr.setDESIGNATION("Developer");
       pr.setMANAGER_ID(201);
       pr.setMOBILE_NO(996633001);
       pr.setOFFICIAL_MAILID("sneha@gmail.com");
       pr.setSALARY(45000);
       
       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pr");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(pr);
		System.out.println("Record saved");
		transaction.commit();
		manager.close();
       
    }
}
