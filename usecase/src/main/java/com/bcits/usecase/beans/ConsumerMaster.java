package com.bcits.usecase.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "consumer_info")
public class ConsumerMaster implements Serializable{

	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "mobile_number")
	private long mobileNo;
	@Column
	private String password;
	@Column(name="confirm_password")
	private String confirmpassword;
	@Column(name = "address_line1")
	private String addressLine1;
	@Column(name = "address_line2")
	private String addressLine2;
	@Column(name = "region")
	private String region;
	@Column(name="type_of_consumer")
	private String typeOfConsumer;
	
	@Id
	@Column(name = "rr_number")
	private String rrNumber;
	@Column(name = "account_id")
	private long accountId;
	

}
