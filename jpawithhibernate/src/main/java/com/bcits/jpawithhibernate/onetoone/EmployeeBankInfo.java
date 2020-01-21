package com.bcits.jpawithhibernate.onetoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bcits.jpawithhibernateapp.bean.EmployeePrimaryInfo;

@Entity
@Table(name="employee_bank_info")
public class EmployeeBankInfo implements Serializable{
	@Id
	@Column
	private int emp_id; 
	@Column
	 private long account_no;
	@Column
	 private String bank_name;
	@Column
	 private String branch_name;
	@Column
	 private String ifsc_code; 
	
	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EMP_ID")
	private EmployeePrimaryInfo primary;

	
	
	 
		
		          

	            
		          
		
	}


