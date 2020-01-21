package com.bcits.usecase.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="employee_master")
public class EmployeeMaster implements Serializable{
	@Id
	@Column(name="emp_id")
	private int empId;
	@Column(name="name")
	private String name;
	@Column(name="password")
	private String password;
	@Column(name="region")
	private String region;
	
	
	

}
