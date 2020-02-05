package com.bcits.usecase.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tariff_info")
public class Tariff implements Serializable{
	
	@EmbeddedId
	private TariffPK tariffprikey;
	@Column
	private double amount;

}
