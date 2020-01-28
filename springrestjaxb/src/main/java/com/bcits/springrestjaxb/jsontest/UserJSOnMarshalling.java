package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.UserAddressBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;
import com.bcits.springrestjaxb.beans.UserOtherInfoBean;

public class UserJSOnMarshalling {
	
	public static void main(String[] args) {
		
		UserInfoBean infoBean = new UserInfoBean();
		infoBean.setEmpId(1000);
		infoBean.setEName("venkatesh");
		infoBean.setDateOfBirth(new Date());
		infoBean.setDateOfJoin(new Date());
		infoBean.setDepartmentId(30);
		infoBean.setDesignation("Dev");
		infoBean.setManagerId(130);
		infoBean.setMobile(9631234567L);
		infoBean.setSalary(45000);
		infoBean.setOfficialMailid("venky@gmail.com");
		infoBean.setPassword("root");
		

		UserOtherInfoBean userOtherInfoBean = new UserOtherInfoBean();
		userOtherInfoBean.setGender("male");
		userOtherInfoBean.setAdhaarNumber(1236958789L);
		
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
		
		
		try {
			ObjectMapper mapper=new ObjectMapper();
			mapper.writerWithDefaultPrettyPrinter();
			mapper.writeValue(new File("empJSON6.json"), infoBean);
			mapper.writeValue(System.out, infoBean);
		}
			 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}//end of main()

}//end of class
