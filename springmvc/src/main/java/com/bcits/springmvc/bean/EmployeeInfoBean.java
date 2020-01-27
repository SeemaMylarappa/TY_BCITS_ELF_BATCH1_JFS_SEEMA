package com.bcits.springmvc.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Entity
@Table
public class EmployeeInfoBean implements Serializable{
	
	@Id
	@Column
	private Integer empId;
	@Column
	private String eName;
	@Column
	private Double salary;
	@Column
	private Integer departmentId;
	@Column
	private Date dateOfJoin;
	@Column
	private Long mobile;
	@Column
	private String officialMailid;
	@Column
	private String designation;
	@Column
	private Date dateOfBirth;
	@Column
	private Integer managerId;
	@Column
	private String password;

	

}
