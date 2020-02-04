package com.bcits.usecase.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.bcits.usecase.beans.ConsumerMaster;
import com.bcits.usecase.beans.EmployeeMaster;
import com.bcits.usecase.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}

	  @GetMapping("/employeeLoginPage")
	  public String displayEmployeeLoginPage() {
	  
	  return "employeeLoginPage";
	  
	  }
	  
		@GetMapping("/employeePage")
		public String displayEmployeePage() {
			
			return "employeePage";
		}
		
		@PostMapping("/empPage")
		public String employeeLogin(String empId, String password, HttpServletRequest request, ModelMap map) {

			EmployeeMaster employeeMaster = service.employeeLogin(empId, password);
			if (employeeMaster != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("LoggedIn", employeeMaster);
				return "employeePage";
			} else {
				map.addAttribute("errmsg", "Invalid Credentials");
				return "homePage";
			}
		}// end of consumerLogin()

}
