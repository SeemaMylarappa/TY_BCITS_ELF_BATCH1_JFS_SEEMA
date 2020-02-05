package com.bcits.usecase.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.bcits.usecase.service.CustomerService;
import com.bcits.usecase.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@Autowired
	private CustomerService customerService;

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
	
	@GetMapping("/emplogout")
	public String displaylogout() {
		
		return "employeeLoginPage";
	}

	@PostMapping("/empPage")
	public String employeeLogin(int empId, String password, HttpServletRequest request, ModelMap map) {
		EmployeeMaster employeeMaster = service.employeeLogin(empId, password);
		if (employeeMaster != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("empLoggedIn", employeeMaster);
			return "employeePage";
		} else {
			map.addAttribute("errmsg", "Invalid Credentials");
			return "employeeLoginPage";
		}
	}// end of consumerLogin()

	@GetMapping("/consumerlist")
	public String consumerList(HttpSession session, ModelMap modelMap) {

		EmployeeMaster master = (EmployeeMaster) session.getAttribute("empLoggedIn");
		if (master != null) {
			System.out.println(master);
			String region = master.getRegion();
			List<ConsumerMaster> consumermaster = service.consumerDetailsPage(region);
			System.out.println(consumermaster);
			if (!consumermaster.isEmpty()) {
				modelMap.addAttribute("consumer", consumermaster);
			} else {
				modelMap.addAttribute("errmsg", "Records not found");
			}
			return "empConsumerlist";
		} else {
			modelMap.addAttribute("errMsg", "Please Login first");
			return "employeeLoginPage";
		}
	}//end of consumerList()
	
	@GetMapping("/generateBill")
	  public String displayGenarateBillPage(HttpSession session,ModelMap map,String rrNumber) {
		  System.out.println(rrNumber);
		  EmployeeMaster employeemaster = (EmployeeMaster) session.getAttribute("empLoggedIn");
		  System.out.println(employeemaster);
		  if (employeemaster != null) {
			  customerService.getMonthlyConsumption(rrNumber);
			ConsumerMaster consumerMaster = customerService.getRRNumber(rrNumber);
			double previousReading = customerService.previousReading(rrNumber);
			System.out.println(previousReading);
			if (consumerMaster != null) {
				map.addAttribute("consdetail", consumerMaster);
				map.addAttribute("previousReading", previousReading);
				System.out.println(previousReading);
			}
				
			}else {
				map.addAttribute("errmsg", "Invalid Credentials");
				return "employeeLoginPage";
		}
		  
		  return "generateBillPage";
	  
	  }
	 //end of displayGenarateBillPage()
}
