package com.bcits.springsecuritymvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bcits.springsecuritymvc.beans.EmpInfoBean;
import com.bcits.springsecuritymvc.service.EmpService;

@Controller
public class EmpSecurityController {
	
	@Autowired
	private EmpService service;
	
	
	@GetMapping("/index")
	public String getIndexPage() {
		
		return "index";
	}
	@GetMapping("/register")
	public String getRegisterForm() {
		
		return "register";
	}
	
	@PostMapping("/register")
	public String register(EmpInfoBean empInfoBean,ModelMap modelMap) {
		
		boolean isRegistered = service.register(empInfoBean);
		if (isRegistered) {
			modelMap.addAttribute("msg", "Registered Successfully...");
		} else {
			modelMap.addAttribute("errMsg", "Registeration Failed!!!");
		}
		
		return "register";
		
	}//end of register()
	
	@GetMapping("/adminSecureHome")
	public String getAdminHomePage() {
		
		return "adminHomePage";
	}
	@GetMapping("/userSecureHome")
	public String getUserHomePage() {
		
		return "userHomePage";
	}
	
	@GetMapping("/getEmployeeForm")
	public String getEmployeeForm() {
		
		return "searchEmp";
	}
	
	@GetMapping("/getEmployee")
	public String getEmployee(int empId,ModelMap modelMap) {
		
	EmpInfoBean empInfoBean = service.getEmployee(empId);
	modelMap.addAttribute("empInfo", empInfoBean);
	 return "searchEmp";
	}//end of getEmployee()
	
	@GetMapping("/getAllEmployee")
	public String getAllEmployee(ModelMap modelMap) {
		
		modelMap.addAttribute("employeesList", service.getAllEMployees());
		 return "getAllEmployees";
		}//end of getAllEmployee()

}//end of controller
