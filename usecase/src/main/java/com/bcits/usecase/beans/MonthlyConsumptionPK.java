package com.bcits.usecase.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Embeddable

public class MonthlyConsumptionPK implements Serializable{
	
	
	@Column(name = "rr_number")
	private String rrNumber;
	@Column
	private Date date;

}
