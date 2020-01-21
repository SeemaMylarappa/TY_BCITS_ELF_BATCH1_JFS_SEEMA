package com.bcits.jpawithhibernate.manytoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.bcits.jpawithhibernateapp.bean.EmployeePrimaryInfo;

import lombok.Data;

@Data
@Entity
@Table(name="employee_address_info")
public class EmployeeAddressInfo implements Serializable {
	 @EmbeddedId
	 private EmployeeAddressPK addressPK;
	 @Column
	 private int HOUSE_NO; 
	 @Column
	 private String ADDRESS1; 
	 @Column
	private String ADDRESS2; 
	 @Column
	private String LANDMARK; 
	 @Column
	private String CITY; 
	 @Column
	private int PINCODE;  
	 
	 @MapsId("EMP_ID")
	 @ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="EMP_ID")
	 private EmployeePrimaryInfo primaryinfo;


}
