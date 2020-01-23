package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Bean;

import com.bcits.springcoreannotations.bean.DepartmentBean;

public class DepartmentConfig {
	
	@Bean(name="dev")
	public DepartmentBean getDepartmentDev() {

		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDeptId(103);
		departmentBean.setDeptName("Dev");

		return departmentBean;

	}// end of DepartmentDev()

	@Bean(name="hr")
	/* @Primary */
	public DepartmentBean getDepartmentHr() {

		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDeptId(104);
		departmentBean.setDeptName("HR");

		return departmentBean;

	}// end of DepartmentHr()

	@Bean(name="acc")
	public DepartmentBean getDepartmentAccount() {

		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDeptId(105);
		departmentBean.setDeptName("Account");

		return departmentBean;

	}// end of DepartmentAccount()


}
