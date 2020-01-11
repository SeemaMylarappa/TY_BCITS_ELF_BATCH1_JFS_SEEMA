package com.bcits.jpawithhibernateapp.bean;



import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="employee_primary_info")
public class EmployeePrimaryInfo implements Serializable{
    @Id
    @Column
	private int EMP_ID;
    @Column
	private String E_NAME;
    @Column
	private double SALARY;
    @Column
	private int DEPT_ID;
    @Column
	private Date DATE_OF_JOIN;
    @Column
	private long MOBILE_NO;
    @Column
	private String OFFICIAL_MAILID;
    @Column
	private String DESIGNATION;
    @Column
	private Date DATE_OF_BIRTH;
    @Column
	private int MANAGER_ID;
	
	public int getEMP_ID() {
		return EMP_ID;
	}
	public void setEMP_ID(int eMP_ID) {
		EMP_ID = eMP_ID;
	}
	public String getE_NAME() {
		return E_NAME;
	}
	public void setE_NAME(String e_NAME) {
		E_NAME = e_NAME;
	}
	public double getSALARY() {
		return SALARY;
	}
	public void setSALARY(double sALARY) {
		SALARY = sALARY;
	}
	public int getDEPT_ID() {
		return DEPT_ID;
	}
	public void setDEPT_ID(int dEPT_ID) {
		DEPT_ID = dEPT_ID;
	}
	public Date getDATE_OF_JOIN() {
		return DATE_OF_JOIN;
	}
	public void setDATE_OF_JOIN(Date dATE_OF_JOIN) {
		DATE_OF_JOIN = dATE_OF_JOIN;
	}
	public long getMOBILE_NO() {
		return MOBILE_NO;
	}
	public void setMOBILE_NO(long mOBILE_NO) {
		MOBILE_NO = mOBILE_NO;
	}
	public String getOFFICIAL_MAILID() {
		return OFFICIAL_MAILID;
	}
	public void setOFFICIAL_MAILID(String oFFICIAL_MAILID) {
		OFFICIAL_MAILID = oFFICIAL_MAILID;
	}
	public String getDESIGNATION() {
		return DESIGNATION;
	}
	public void setDESIGNATION(String dESIGNATION) {
		DESIGNATION = dESIGNATION;
	}
	public Date getDATE_OF_BIRTH() {
		return DATE_OF_BIRTH;
	}
	public void setDATE_OF_BIRTH(Date dATE_OF_BIRTH) {
		DATE_OF_BIRTH = dATE_OF_BIRTH;
	}
	public int getMANAGER_ID() {
		return MANAGER_ID;
	}
	public void setMANAGER_ID(int mANAGER_ID) {
		MANAGER_ID = mANAGER_ID;
	}
	
	
	
}
