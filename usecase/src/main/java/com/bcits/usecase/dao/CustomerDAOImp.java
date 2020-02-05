package com.bcits.usecase.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.usecase.beans.BillHistoryBean;
import com.bcits.usecase.beans.BillHistoryPK;
import com.bcits.usecase.beans.ConsumerMaster;
import com.bcits.usecase.beans.CurrentBill;
import com.bcits.usecase.beans.MonthlyConsumption;


@Repository
public class CustomerDAOImp implements CustomerDAO{
	
	@PersistenceUnit
	EntityManagerFactory factoryBean;

	@Override
	public boolean consumerSignUp(ConsumerMaster consumer, String password) {
		EntityManager manager=factoryBean.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(consumer);
			transaction.commit();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			manager.close();
		}
		return false;
	}

	@Override
	public ConsumerMaster consumerLogin(String emailId, String password) {
		EntityManager manager=factoryBean.createEntityManager();
		Query query = manager.createQuery(" from ConsumerMaster where emailId= :email  ");
		query.setParameter("email", emailId);
		ConsumerMaster consumerMaster=(ConsumerMaster) query.getSingleResult();
		if (consumerMaster != null && consumerMaster.getPassword().equals(password)) {
			return consumerMaster;	
		}
		manager.close();
		return null;
	}

	
	@Override
	public CurrentBill getCurrentBill(String rrNumber) {
		EntityManager manager=factoryBean.createEntityManager();
		CurrentBill bill = manager.find(CurrentBill.class, rrNumber);
		System.out.println(bill);
		if(bill != null) {
		return bill ;
	}

	return null;
	}

	@Override
	public List<MonthlyConsumption> getMonthlyConsumption(String rrNumber) {
		EntityManager manager=factoryBean.createEntityManager();
		Query query = manager.createQuery(" from MonthlyConsumption where rr_Number = :rrNumber");
		query.setParameter("rrNumber",rrNumber);
		List<MonthlyConsumption> monthlyConsumption = query.getResultList();
		if (monthlyConsumption != null) {
			return monthlyConsumption;
		}
		manager.close();
		return null;
		
		
	}

	@Override
	public List<BillHistoryBean> getBillHistory(String rrNumber) {
		EntityManager manager=factoryBean.createEntityManager();
		Query query = manager.createQuery(" from BillHistoryBean where rr_Number = :rrNum");
		query.setParameter("rrNum",rrNumber);
		List<BillHistoryBean> billHistoryBean = query.getResultList();
		if (billHistoryBean != null) {
			return billHistoryBean;
		}
		manager.close();
		return null;
	}

	@Override
	public boolean payment(String rrNumber, Date date, int amount) {
		
		EntityManager manager = factoryBean.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		BillHistoryBean billHistoryBean = new BillHistoryBean();
		BillHistoryPK billHistoryPK = new BillHistoryPK();
		billHistoryBean.setAmount(amount);
		billHistoryPK.setRrNumber(rrNumber);
		billHistoryBean.setStatus("Amount Paid");
		billHistoryPK.setPaymentdate(date);
		billHistoryBean.setBillhistorypk(billHistoryPK);
		if (billHistoryPK != null) {
			transaction.begin();
			manager.persist(billHistoryBean);
			transaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public ConsumerMaster getRRNumber(String rrNumber) {
		EntityManager manager=factoryBean.createEntityManager();
		ConsumerMaster master=manager.find(ConsumerMaster.class, rrNumber);
		if (master != null) {
			return master;
		}
		return null;
	}

	@Override
	public double previousReading(String rrNumber) {
		EntityManager manager= factoryBean.createEntityManager();
		double previousReading;
		try {
			String jpql="select currentReading from MonthlyConsumption where rrNumber=:rrnum order by currentReading DESC";
			Query query = manager.createQuery(jpql);
			query.setMaxResults(1);
			query.setParameter("rrnum", rrNumber);
			previousReading=(double) query.getSingleResult();
			}catch (Exception e) {
				return 0;
			}
		if(previousReading != 0) {
			return previousReading;
		}
		return 0;
	}

	
}
