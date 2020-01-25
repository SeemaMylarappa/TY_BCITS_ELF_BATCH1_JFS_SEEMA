package com.bcits.springmvc.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class EmployeeInfoBean implements Serializable{
	
	@Id
	@Column
	private int empId;
	@Column
	private String eName;
	@Column
	private double salary;
	@Column
	private int departmentId;
	@Column
	private Date dateOfJoin;
	@Column
	private long mobile;
	@Column
	private String officialMailid;
	@Column
	private String designation;
	@Column
	private Date dateOfBirth;
	@Column
	private int managerId;
	@Column
	private String password;

	

}
