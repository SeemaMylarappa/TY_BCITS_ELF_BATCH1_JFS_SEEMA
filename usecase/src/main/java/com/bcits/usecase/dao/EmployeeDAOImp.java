package com.bcits.usecase.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bcits.usecase.beans.ConsumerMaster;
import com.bcits.usecase.beans.CurrentBill;
import com.bcits.usecase.beans.EmployeeMaster;
import com.bcits.usecase.beans.MonthlyConsumption;
import com.bcits.usecase.beans.MonthlyConsumptionPK;
import com.bcits.usecase.beans.QueryInfoBean;
import com.bcits.usecase.beans.QueryInfoPK;

@Repository
public class EmployeeDAOImp implements EmployeeDAO{
	
	@PersistenceUnit
	EntityManagerFactory factoryBean;
	
	@Autowired
	BillCalculation calculation;
	
	


	@Override
	public EmployeeMaster employeeLogin(int empId, String password) {
		EntityManager manager=factoryBean.createEntityManager();
		String jpql=" from EmployeeMaster where empId= :empId ";
		Query query = manager.createQuery(jpql);
		query.setParameter("empId", empId);
		EmployeeMaster employeeMaster=(EmployeeMaster) query.getSingleResult();
		if (employeeMaster != null && employeeMaster.getPassword().equals(password)) {
			return employeeMaster;	
		}
		manager.close();
		return null;
	}


	@Override
	public List<ConsumerMaster> consumerDetailsPage(String region) {
		 System.out.println(region);
			EntityManager manager=factoryBean.createEntityManager();
		String jpql	=" from ConsumerMaster where region = :region ";
			 Query query=manager.createQuery(jpql);
			query.setParameter("region", region);
		List<ConsumerMaster> consumerMaster=(List<ConsumerMaster>)query.getResultList();
		System.out.println(consumerMaster);
			if (consumerMaster != null) {
				return consumerMaster;	
			}
			manager.close();
			return null;
	}


	@Override
	public boolean currentBillGeneration(CurrentBill currentBill,String region) {
		
		double units = currentBill.getFinalReading()-currentBill.getInitialReading();
		
		EntityManager manager = factoryBean.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		
		MonthlyConsumption monthlyConsumption = new MonthlyConsumption();
		MonthlyConsumptionPK monthlyConsumptionPK = new MonthlyConsumptionPK();
		
		CurrentBill curbill = manager.find(CurrentBill.class, currentBill.getRrNumber());
		double amount = calculation.billCalculation(units, currentBill.getTypeOfConsumer());		
		try {
			transaction.begin();
			if(curbill != null) {
				manager.remove(curbill);
			}
			
			monthlyConsumptionPK.setDate(new Date());
			monthlyConsumptionPK.setRrNumber(currentBill.getRrNumber());
			monthlyConsumption.setMonthlyConsumptionprikey(monthlyConsumptionPK);
			monthlyConsumption.setRegion(region);
			monthlyConsumption.setAmount(amount);
			monthlyConsumption.setStatus("Not paid");
			monthlyConsumption.setPreviousReading(currentBill.getInitialReading());
			monthlyConsumption.setCurrentReading(currentBill.getFinalReading());
			monthlyConsumption.setUnitsConsumed(units);
			
			currentBill.setAmount(amount);
			currentBill.setUnitsConsumed(units);
			
			manager.persist(monthlyConsumption);
			manager.persist(currentBill);
			
			transaction.commit();
			return true;
	}catch(Exception e) {
		e.printStackTrace();
	}
   return false;
}


	@Override
	public boolean queryResponse(String rrNumber, String response, Date date) {
		
     EntityManager manager = factoryBean.createEntityManager();
     EntityTransaction transaction = manager.getTransaction();
     try {
    	transaction.begin();
    	String jpql = " from QueryInfoBean where queryinfo.rrNumber=:rrNum and queryinfo.date=:date";
        Query query = manager.createQuery(jpql);
        query.setParameter("rrNum", rrNumber);
        query.setParameter("date", date);
        QueryInfoBean queryInfoBean = (QueryInfoBean) query.getSingleResult();
        queryInfoBean.setResponse(response);
        transaction.commit();
        return true;
     }catch (Exception e) {
		e.printStackTrace();
		return false;
	}
     
	}


	@Override
	public List<QueryInfoBean> queryList(String region) {
		EntityManager manager=factoryBean.createEntityManager();
		String jpql	=" from QueryInfoBean where region = :region ";
			 Query query=manager.createQuery(jpql);
			query.setParameter("region", region);
		List<QueryInfoBean> queryInfoBeans=(List<QueryInfoBean>)query.getResultList();
		
			if (queryInfoBeans != null && !queryInfoBeans.isEmpty()) {
				return queryInfoBeans;	
			}
			manager.close();
			return null;
	}



	
}
