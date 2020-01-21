package com.bcits.jpawithhibernate.manytoone;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;


import lombok.Data;
@Data

@Embeddable
public class EmployeeAddressPK implements Serializable {
	
	private int EMP_ID;             
	private String ADDRESS_TYPE;

}
