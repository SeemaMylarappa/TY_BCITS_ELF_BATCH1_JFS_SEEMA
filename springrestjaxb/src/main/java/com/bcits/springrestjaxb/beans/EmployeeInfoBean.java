package com.bcits.springrestjaxb.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonRootName;

import lombok.Data;

@Data
@JsonPropertyOrder({"employeeId","mobile"})
@XmlRootElement(name="Employee-info")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("employeeInfo")
public class EmployeeInfoBean {
    
	@JsonProperty("employeeId")
	@XmlElement(name="employee-id")
	//@XmlAttribute====to make this data member as attribute
	private int empId;
	@XmlElement
	private String eName;
	@XmlElement
	private double salary;
	@XmlElement(name="department-id")
	private int departmentId;
	@XmlElement
	private Date dateOfJoin;
	@XmlElement
	private long mobile;
	@XmlElement
	private String officialMailid;
	@XmlElement
	private String designation;
	@XmlElement
	//@XmlTransient===if this data memeber is not required
	private Date dateOfBirth;
	@XmlElement                
	private int managerId;
	@XmlElement
	@JsonIgnore
	private String password;

}
