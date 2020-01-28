package com.bcits.springrestjaxb.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

import lombok.Data;

@Data
@JsonRootName("user-info-bean")
@XmlRootElement(name="Employee-info")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserInfoBean {
    
	@JsonProperty
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
	private String password;

	@JsonProperty
	@XmlElement(name="user-other-info")
	private UserOtherInfoBean userOtherInfoBean;
	
	@XmlElementWrapper(name="user-address-list")
	private List<UserAddressBean> userAdressList;
	
}
