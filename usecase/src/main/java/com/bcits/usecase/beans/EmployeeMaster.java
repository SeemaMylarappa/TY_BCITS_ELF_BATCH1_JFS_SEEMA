package com.bcits.usecase.beans;

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
	@Column(name="password")
	private String password;
	

}
