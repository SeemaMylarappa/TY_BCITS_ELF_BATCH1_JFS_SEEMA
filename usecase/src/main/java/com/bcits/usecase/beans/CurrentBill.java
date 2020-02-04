package com.bcits.usecase.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="current_bill")
public class CurrentBill {
	@Id
	@Column(name = "rr_number")
	private String rrNumber;
	@Column(name="initial_reading")
	private int initialReading;
	@Column(name="final_reading")
	private int finalReading;
	@Column(name="units_consumed")
	private int unitsConsumed;
	@Column
	private double amount;
	@Column(name="no_Of_Days")
	private Date noOfDays;

}
