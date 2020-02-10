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
import com.bcits.usecase.beans.QueryInfoBean;
import com.bcits.usecase.beans.QueryInfoPK;


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
		try {
		EntityManager manager = factoryBean.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String jpql=" from MonthlyConsumption where monthlyConsumptionprikey.rrNumber = :rrNum order by currentReading DESC";
		transaction.begin();
		Query query = manager.createQuery(jpql);
		query.setMaxResults(1);
		query.setParameter("rrNum", rrNumber);
		BillHistoryBean billHistoryBean = new BillHistoryBean();
		BillHistoryPK billHistoryPK = new BillHistoryPK();
		MonthlyConsumption monthlyConsumption = (MonthlyConsumption)query.getSingleResult();
		billHistoryBean.setAmount(amount);
		billHistoryPK.setRrNumber(rrNumber);
		billHistoryBean.setStatus("Amount Paid");
		billHistoryPK.setPaymentdate(date);
		billHistoryBean.setBillhistorypk(billHistoryPK);
		
		
			monthlyConsumption.setStatus("Paid");
			manager.persist(billHistoryBean);
			transaction.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
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
			String jpql="select currentReading from MonthlyConsumption where rrNumber=:rrnum order by previousReading DESC";
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

	@Override
	public List<MonthlyConsumption> getGeneratedBills(String region) {
		EntityManager manager = factoryBean.createEntityManager();
		String jpql=" from MonthlyConsumption where region=:reg ";
		Query query = manager.createQuery(jpql);
		query.setParameter("reg", region);
		List<MonthlyConsumption> list = query.getResultList();
		if (list != null) {
			return list;
		}
		manager.close();
		return null;
	}

	@Override
	public boolean querySupport(String msg, String rrNumber, String region) {
		    System.out.println(msg); 
			EntityManager manager = factoryBean.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			QueryInfoPK queryInfoPK = new QueryInfoPK();
			QueryInfoBean queryInfoBean = new QueryInfoBean();
			
			try {
				transaction.begin();
				queryInfoPK.setRrNumber(rrNumber);
				queryInfoBean.setRegion(region);
				queryInfoPK.setDate(new Date());
				queryInfoBean.setSupport(msg);
				queryInfoBean.setResponse("Not Sent");
				queryInfoBean.setQueryinfo(queryInfoPK);
				manager.persist(queryInfoBean);
				transaction.commit();
				return true;
			}catch (Exception e) {
				e.printStackTrace();
			}
			return false;

		}
	}

	

