package com.bcits.springrestjaxb.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;

public class UserUnmarshallingTest {
	
	public static void main(String[] args) {
		
	try {
			JAXBContext context=JAXBContext.newInstance(UserInfoBean.class);
			Unmarshaller unmarshaller=context.createUnmarshaller();
			UserInfoBean userInfoBean=(UserInfoBean) unmarshaller.unmarshal(new File("userInfo.xml"));
			
			System.out.println("Emp ID = " + userInfoBean.getEmpId());
			System.out.println("Emp Name = " + userInfoBean.getEName());
			System.out.println("Emp gender = " + userInfoBean.getUserOtherInfoBean().getGender());
			System.out.println("Emp aadhar = " + userInfoBean.getUserOtherInfoBean().getAdhaarNumber());
			System.out.println("DOB = " +userInfoBean.getDateOfBirth());
		} catch (JAXBException e) {
			e.printStackTrace();
			
		}
		
	}

}
