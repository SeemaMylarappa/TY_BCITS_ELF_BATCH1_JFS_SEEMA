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
import com.bcits.usecase.beans.CurrentBill;
import com.bcits.usecase.beans.EmployeeMaster;
import com.bcits.usecase.beans.MonthlyConsumption;
import com.bcits.usecase.beans.QueryInfoBean;
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

	}//end of  displayEmployeeLoginPage()

	@GetMapping("/employeePage")
	public String displayEmployeePage() {

		return "employeePage";
	}//end of displayEmployeePage()

	@GetMapping("/emplogout")
	public String displaylogout() {

		return "employeeLoginPage";
	}//end of displaylogout()
	

	@GetMapping("/generateBillPage")
	public String displaygenerateBillPage(HttpSession session, ModelMap modelMap) {
		EmployeeMaster master = (EmployeeMaster) session.getAttribute("empLoggedIn");
		if (master != null) {
			session.setAttribute("empLoggedIn", master);
			return "generateBillPage";

		} else {
			modelMap.addAttribute("errmsg", "Invalid Credentials");
			return "employeeLoginPage";
		}
	}//end of displaygenerateBillPage()

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
	}// end of consumerList()

	@PostMapping("/generateBill")
	public String genarateBill(HttpSession session, ModelMap map,CurrentBill currentBill) {
		
		EmployeeMaster master = (EmployeeMaster) session.getAttribute("empLoggedIn");
		service.currentBillGeneration(currentBill,master.getRegion());
       if(currentBill != null) {
    	   map.addAttribute("msg", "Bill Generated");
    	   return "generateBillPage";
       }else {
       map.addAttribute("errmsg", "Bill Not Generated");
       
		return "employeeLoginPage";
       }
	}//end of  genarateBill()

	@GetMapping("/seeGeneratedBills")
	public String displayGeneratedBills(HttpSession session,ModelMap modelMap) {
		
		EmployeeMaster master = (EmployeeMaster) session.getAttribute("empLoggedIn");
		if (master != null) {
			List<MonthlyConsumption> monthlyConsumptions = customerService.getGeneratedBills(master.getRegion());
			if(!monthlyConsumptions.isEmpty()) {
			modelMap.addAttribute("billList",monthlyConsumptions);
			}else {
				modelMap.addAttribute("errmsg", "Bill Not Generated");
			}
			return "generatedBills";
		}
		modelMap.addAttribute("errMsg", "Please Login first");
		return "employeeLoginPage";
		
	}//end of displayGeneratedBills()
	
@GetMapping("/seeQuery")
public String displayQuery(ModelMap modelMap,HttpSession session) {
	EmployeeMaster master = (EmployeeMaster) session.getAttribute("empLoggedIn");
	if (master != null) {
		List<QueryInfoBean> querylist = service.queryList(master.getRegion());
		if(querylist != null && !querylist.isEmpty()) {
			modelMap.addAttribute("query", querylist);
			
		}else {
			modelMap.addAttribute("errMsg", "No queries");
		}
		return "consumerQueries";
	}else {
		modelMap.addAttribute("errMsg", "Invalid Credentials");
		return "employeeLoginPage";
	}
}//end of displayQuery()

@PostMapping("/getResponse")
public String response(HttpSession session,ModelMap modelMap,String rrNumber,String response,Date date) {
	EmployeeMaster master = (EmployeeMaster) session.getAttribute("empLoggedIn");
	if (master != null) {
		List<QueryInfoBean> querylist = service.queryList(master.getRegion());
		modelMap.addAttribute("query", querylist);
		
			if(service.queryResponse(rrNumber, response, date)) {
				modelMap.addAttribute("msg", "Query Sent");
			}
			return "consumerQueries";
		}else {
			modelMap.addAttribute("errMsg", "Invalid Credentials");
			return "employeeLoginPage";
		}
}




}//end of class
