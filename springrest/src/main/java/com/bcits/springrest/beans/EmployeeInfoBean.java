package com.bcits.springrest.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
/*@XmlRootElement(name="employee-info")
@XmlAccessorType(XmlAccessType.FIELD)*/
@JsonRootName("employeeInfo")
@JsonPropertyOrder({"employeeID","eName"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@Table
public class EmployeeInfoBean {
	
	@Id
	@Column
	@JsonProperty("employeeID")
	/* @XmlElement(name="emp-id") */
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
