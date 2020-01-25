package com.bcits.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bcits.springmvc.DAO.EmployeeDAO;
import com.bcits.springmvc.bean.EmployeeInfoBean;
import com.bcits.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/login")
	public String displayLoginForm() {
		
		return "empLoginForm";
		
	}//end of displayLoginForm()
	
	@PostMapping("/login")
	public String authenticate(int empId,String password,HttpServletRequest req,ModelMap modelMap) {
		
		EmployeeInfoBean employeeInfoBean=service.authenticate(empId, password);
		
		if (employeeInfoBean != null) {
			//valid credentials
			HttpSession session=req.getSession(true);
			session.setAttribute("loggedInEmpInfo", employeeInfoBean);
			return "employeeHome";
		}else {
			//Invalid credentials
			modelMap.addAttribute("errMsg", "Invalid Credentials!!");
			return "empLoginForm";
		}
	}//end of authenticate()
	
	@GetMapping("/searchEmp")
	public String displaySearchEmployeeForm(HttpSession session,ModelMap modelMap) {
		
		if(session.isNew()) {
			//user not logged in
           session.invalidate();
           modelMap.addAttribute("errMsg", "Please Login First!");
           return "empLoginForm";
		}else {
			//user not logged in
			return "searchEmp";
		}
	}
	
	@GetMapping("/search")
	public String searchEmployee(int empId,HttpSession session,ModelMap modelMap) {
		
		if(session.getAttribute("loggedInEmpInfo") != null) {
			//valid session
			
			EmployeeInfoBean employeeInfoBean=service.getEmployee(empId);
			
			if(employeeInfoBean != null) {
				modelMap.addAttribute("employeeInfoBean",employeeInfoBean);
			}else {
				modelMap.addAttribute("errMsg", "Employee ID Bot Found");
			}
			return "searchEmp";
		}else {
			//Invalid credentials
			modelMap.addAttribute("errMsg", "Please Login First!");
			return "empLoginForm";
		}
	}//end of searchEmployee()
	
	@GetMapping("/deleteEmpForm")
	public String displayDeleteEmployeeForm(
	@SessionAttribute(name="loggedInEmpInfo",required = false)EmployeeInfoBean employeeInfoBean,ModelMap modelMap) {
		 if(employeeInfoBean != null) {
			 //Valid session
			 return "deleteEmpForm";
		 }else {
			 //invalid session
			 modelMap.addAttribute("errMsg", "Please Login First!");
				return "empLoginForm";
		 }
	}//end of displayDeleteEmployeeForm()
    
	@GetMapping("/delete")
	public String deleteEmployee(int empId,
			@SessionAttribute(name="loggedInEmpInfo",required = false)EmployeeInfoBean employeeInfoBean,ModelMap modelMap) {
		
		if (employeeInfoBean != null) {
			//valid session
			if(service.deleteEmployee(empId)) {
				modelMap.addAttribute("msg", "Employee Record deleted Successfully...");
			}else {
				modelMap.addAttribute("errMsg", "Employee Record Not Found...");
			}
			return "deleteEmpForm";
			
		}else {
			//invalid session
			modelMap.addAttribute("errMsg", "Please Login First!");
			return "empLoginForm";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session,ModelMap modelMap) {
		
		session.invalidate();
		modelMap.addAttribute("errMsg", "You Are Successfully logged Out");
		
		return "empLoginForm";
		
	}
}
