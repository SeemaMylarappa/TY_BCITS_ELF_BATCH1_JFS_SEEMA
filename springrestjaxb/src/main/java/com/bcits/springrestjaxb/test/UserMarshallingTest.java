package com.bcits.springrestjaxb.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;
import com.bcits.springrestjaxb.beans.UserAddressBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;
import com.bcits.springrestjaxb.beans.UserOtherInfoBean;

public class UserMarshallingTest {
	
	public static void main(String[] args) {
		
		UserInfoBean infoBean = new UserInfoBean();
		infoBean.setEmpId(999);
		infoBean.setEName("Pooja");
		infoBean.setDateOfBirth(new Date());
		infoBean.setDateOfJoin(new Date());
		infoBean.setDepartmentId(20);
		infoBean.setDesignation("Developer");
		infoBean.setManagerId(120);
		infoBean.setMobile(9631234567L);
		infoBean.setSalary(32000);
		infoBean.setOfficialMailid("pooja@gmail.com");
		infoBean.setPassword("qwerty");
		
		UserOtherInfoBean userOtherInfoBean = new UserOtherInfoBean();
		userOtherInfoBean.setGender("female");
		userOtherInfoBean.setAdhaarNumber(123654789L);
		
		infoBean.setUserOtherInfoBean(userOtherInfoBean);
		
		
		  UserAddressBean tempAddress = new UserAddressBean();
		  tempAddress.setHouseNum(1); tempAddress.setStreet("abc street");
		  tempAddress.setCity("BLR"); tempAddress.setAddresstype('t');
		  
		  
		  UserAddressBean permAddress = new UserAddressBean();
		  permAddress.setHouseNum(2); permAddress.setStreet("xyz street");
		  permAddress.setCity("Hyd"); permAddress.setAddresstype('p');
		  
		  List<UserAddressBean> userAddressList=new ArrayList();
		  userAddressList.add(permAddress); userAddressList.add(tempAddress);
		  
		  infoBean.setUserAdressList(userAddressList);
		 
		
		//marshalling UserInfo
		try {
			JAXBContext context=JAXBContext.newInstance(UserInfoBean.class);
			Marshaller marshaller=context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(infoBean, new File("userInfo2.xml"));
			marshaller.marshal(infoBean, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
			
		}
		
		
	}

}
