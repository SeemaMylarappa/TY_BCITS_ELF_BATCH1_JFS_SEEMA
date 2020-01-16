package com.bcits.empwebapp.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_primary_info")
public class EmployeePrimaryInfo implements Serializable {
	@Id
	@Column
	private int emp_id;
	@Column
	private String e_name;
	@Column
	private double salary;
	@Column
	private int department_id;
	@Column
	private Date date_of_join;
	@Column
	private long mobile_no;
	@Column
	private String official_mailid;
	@Column
	private String designation;
	@Column
	private Date date_of_birth;
	@Column
	private int manager_id;
	@Column
	private String password;

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getdepartment_id() {
		return department_id;
	}

	public void setdepartment_id(int dept_id) {
		this.department_id = dept_id;
	}

	public Date getDate_of_join() {
		return date_of_join;
	}

	public void setDate_of_join(Date date_of_join) {
		this.date_of_join = date_of_join;
	}

	public long getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getOfficial_mailid() {
		return official_mailid;
	}

	public void setOfficial_mailid(String official_mailid) {
		this.official_mailid = official_mailid;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
