package com.bcits.usecase.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="bill_history")
public class BillHistoryBean implements Serializable{
	
	@EmbeddedId
	private BillHistoryPK billhistorypk;
	@Column
	private double amount;
	@Column
	private String status;

}
