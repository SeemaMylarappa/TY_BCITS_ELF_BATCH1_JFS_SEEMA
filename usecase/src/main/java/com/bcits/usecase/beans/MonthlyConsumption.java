package com.bcits.usecase.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="monthly_consumption")
public class MonthlyConsumption implements Serializable{
	
	@EmbeddedId
	private MonthlyConsumptionPK monthlyConsumptionprikey;

	@Column(name="units_consumed")
	private double unitsConsumed;
	@Column
	private double amount;
	@Column(name="previous_reading")
	private double previousReading;
	@Column(name="current_reading")
	private double currentReading;
	

}
