package com.bcits.usecase.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.usecase.beans.Tariff;

@Repository
public class BillCalculation {

	@PersistenceUnit
	private EntityManagerFactory factory;

	public double billCalculation(double units, String typeOfConsumer) {
		EntityManager manager = factory.createEntityManager();
		String jpql = " from Tariff where type = : typeOfConsumer ";
		Query query = manager.createQuery(jpql);
		query.setParameter("typeOfConsumer", typeOfConsumer);
		List<Tariff> tariff = query.getResultList();

		double initialRange = tariff.get(0).getTariffprikey().getRange();
		double middleRange = tariff.get(1).getTariffprikey().getRange();
		double finalRange = tariff.get(2).getTariffprikey().getRange();

		double initialCost = tariff.get(0).getAmount();
		double middleCost = tariff.get(1).getAmount();
		double finalCost = tariff.get(2).getAmount();

		double bill = 0.0;
		if (units < initialRange) {
			bill = units * initialCost;
		} else if (units < middleRange) {
			bill = (initialRange * initialCost) + ((units - initialRange) * middleCost);
		} else if (units > finalRange) {
			bill = (initialRange * initialCost) + ((middleRange - initialRange) * middleCost)
					+ ((units - middleRange) * finalCost);
		}
		return bill;
	}

}
