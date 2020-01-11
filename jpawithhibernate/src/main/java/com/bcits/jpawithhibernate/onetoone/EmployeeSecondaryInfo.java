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
@Table(name = "employee_secondary_info")
public class EmployeeSecondaryInfo implements Serializable {
	@Id
	private int EMP_ID;
	@Column
	private String PERSONAL_MAILID;
	@Column
	private String GENDER;
	@Column
	private String GOVT_ID;
	@Column
	private int AGE;
	@Column
	private String NATIONALITY;
	@Column
	private String MARITAL_STATUS;
	@Column
	private String GUARDIAN_NAME;
	@Column
	private long GUARDIAN_CONTACT;
	@Column
	private String JOB_LOCATION;

	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EMP_ID")
	private EmployeePrimaryInfo primary;

	public EmployeePrimaryInfo getPrimary() {
		return primary;
	}

	public void setPrimary(EmployeePrimaryInfo primary) {
		this.primary = primary;
	}

	public int getEMP_ID() {
		return EMP_ID;
	}

	public void setEMP_ID(int eMP_ID) {
		EMP_ID = eMP_ID;
	}

	public String getPERSONAL_MAILID() {
		return PERSONAL_MAILID;
	}

	public void setPERSONAL_MAILID(String pERSONAL_MAILID) {
		PERSONAL_MAILID = pERSONAL_MAILID;
	}

	public String getGENDER() {
		return GENDER;
	}

	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}

	public String getGOVT_ID() {
		return GOVT_ID;
	}

	public void setGOVT_ID(String gOVT_ID) {
		GOVT_ID = gOVT_ID;
	}

	public int getAGE() {
		return AGE;
	}

	public void setAGE(int aGE) {
		AGE = aGE;
	}

	public String getNATIONALITY() {
		return NATIONALITY;
	}

	public void setNATIONALITY(String nATIONALITY) {
		NATIONALITY = nATIONALITY;
	}

	public String getMARITAL_STATUS() {
		return MARITAL_STATUS;
	}

	public void setMARITAL_STATUS(String mARITAL_STATUS) {
		MARITAL_STATUS = mARITAL_STATUS;
	}

	public String getGUARDIAN_NAME() {
		return GUARDIAN_NAME;
	}

	public void setGUARDIAN_NAME(String gUARDIAN_NAME) {
		GUARDIAN_NAME = gUARDIAN_NAME;
	}

	public long getGUARDIAN_CONTACT() {
		return GUARDIAN_CONTACT;
	}

	public void setGUARDIAN_CONTACT(long gUARDIAN_CONTACT) {
		GUARDIAN_CONTACT = gUARDIAN_CONTACT;
	}

	public String getJOB_LOCATION() {
		return JOB_LOCATION;
	}

	public void setJOB_LOCATION(String jOB_LOCATION) {
		JOB_LOCATION = jOB_LOCATION;
	}

}
