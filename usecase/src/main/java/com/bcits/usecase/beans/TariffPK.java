package com.bcits.usecase.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class TariffPK implements Serializable{
	
	@Column
	private String type;
	@Column
	private double range;

}
