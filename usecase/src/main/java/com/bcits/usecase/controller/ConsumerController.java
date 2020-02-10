package com.bcits.usecase.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.bcits.usecase.beans.BillHistoryBean;
import com.bcits.usecase.beans.ConsumerMaster;
import com.bcits.usecase.beans.CurrentBill;
import com.bcits.usecase.beans.MonthlyConsumption;
import com.bcits.usecase.service.CustomerService;

@Controller
public class ConsumerController {

	@Autowired
	private CustomerService service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);

	}// end of initBinder()

	@GetMapping("/home")
	public String displayHomePage() {

		return "homePage";
	}// end of displayHomePage()
	
	

	@GetMapping("/consumerLoginPage")
	public String displayConsumerPage() {

		return "consumerLoginPage";
	}// end of displayConsumerPage()
	
	

	@GetMapping("/consumerSignUpPage")
	public String displaySignUp() {

		return "consumerSignUpPage";
	}// end of displaySignUp()
	
	

	@GetMapping("/paymentPage")
	public String displaypaymentPage() {

		return "paymentPage";
	}// end of displaypaymentPage()
	
	

	@GetMapping("/logout")
	public String logOutPage( HttpSession session) {
		session.invalidate();
		return "consumerLoginPage";
	}//end of logout()
	

	@PostMapping("/signUPage")
	public String addConsumer(ConsumerMaster consumerMaster, String conPwd, ModelMap map) {
		if (service.consumerSignUp(consumerMaster, conPwd)) {

			map.addAttribute("msg", "SignUp Successfull");
			return "consumerLoginPage";
		} else {
			map.addAttribute("errMsg", "Already user Exists");
		}
		return "consumerLoginPage";
	}// end of addConsumer()
	
	

	@PostMapping("/loginPage")
	public String consumerLogin(String emailId, String password, HttpServletRequest request, ModelMap map) {

		ConsumerMaster consumerMaster = service.consumerLogin(emailId, password);
		if (consumerMaster != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("LoggedIn", consumerMaster);
			return "consumerDetails";
		} else {
			map.addAttribute("errmsg", "Invalid Credentials");
			return "consumerLoginPage";
		}
	}// end of consumerLogin()
	
	

	@GetMapping("/currentBill")
	public String displayCurrentBill(HttpSession session, ModelMap modelMap) {
		ConsumerMaster consumerMaster = (ConsumerMaster) session.getAttribute("LoggedIn");
		if (consumerMaster != null) {
			System.out.println(consumerMaster.getRrNumber());
			CurrentBill bill = service.getCurrentBill(consumerMaster.getRrNumber());
			System.out.println(bill);
			if (bill != null) {
				modelMap.addAttribute("currentbill", bill);
				return "currentbill";
			} else {
				modelMap.addAttribute("errMsg", "Bill is not Generated");
				return "consumerLoginPage";
			}
		} else {
			modelMap.addAttribute("errMsg", "Please Login First");
			return "consumerDetails";
		}
	}// end of displayCurrentBill()
	
	

	@GetMapping("/monthlyConsumption")
	public String displayMonthlyConsumption(HttpSession session, ModelMap modelMap) {
		ConsumerMaster consumerMaster = (ConsumerMaster) session.getAttribute("LoggedIn");
		if (consumerMaster != null) {
			System.out.println(consumerMaster.getRrNumber());
			List<MonthlyConsumption> monthlyConsumptions = service.getMonthlyConsumption(consumerMaster.getRrNumber());
			System.out.println(monthlyConsumptions);
			if (monthlyConsumptions != null) {
				modelMap.addAttribute("monthlyconsumption", monthlyConsumptions);
				return "monthlyConsumption";
			} else {
				modelMap.addAttribute("errMsg", "MonthlyConsumption is not generated");
				return "consumerLoginPage";
			}
		} else {
			modelMap.addAttribute("errMsg", "Please Login First");
			return "consumerLoginPage";
		}
	}// end of displayMonthlyConsumption()
	
	
	
	@GetMapping(name="/billHistoryPage")
	public String displayBillHistory(HttpSession session,ModelMap modelMap) {
		
		ConsumerMaster consumerMaster = (ConsumerMaster) session.getAttribute("LoggedIn");
		if (consumerMaster != null) {
			System.out.println(consumerMaster.getRrNumber());
			List<BillHistoryBean> billHistoryBeans= service.getBillHistory(consumerMaster.getRrNumber());
		
			System.out.println(billHistoryBeans);
			if (billHistoryBeans != null) {
				modelMap.addAttribute("billhistory", billHistoryBeans);
				return "billHistory";
			}else {
				modelMap.addAttribute("errMsg", "MonthlyConsumption is not generated");
				return "consumerDetails";
			}
		} else {
			modelMap.addAttribute("errMsg", "Please Login First");
			return "consumerLoginPage";
		}
		
		
	}//end of displayBillHistory()
	
	@GetMapping("/paymentSucccessPage")
	public String paymentPage(HttpSession session,ModelMap modelMap,int amount) {
		
		ConsumerMaster consumerMaster = (ConsumerMaster) session.getAttribute("LoggedIn");
		Date date=new Date();
		if (consumerMaster != null) {
			System.out.println(date);
			System.out.println(consumerMaster.getRrNumber());
			System.out.println(amount);
			boolean payment=service.payment(consumerMaster.getRrNumber(), date, amount);
			if (payment == true) {
				modelMap.addAttribute("msg", "Payment Successfully Done");
				return "paymentPage";
			}else {
				modelMap.addAttribute("errMsg", "Payment is not done");
				return "paymentPage";
			}
		} else {
			
			return "consumerDetails";
		}
		
	}//end of paymentPage()
	
	@GetMapping("/queryDetails")
	public String queryPage(HttpSession session,ModelMap modelMap,String support) {
		
		ConsumerMaster consumerMaster = (ConsumerMaster) session.getAttribute("LoggedIn");
		if (consumerMaster != null) {
			System.out.println(support);
			if(service.querySupport(support,consumerMaster.getRrNumber(),consumerMaster.getRegion())) {
			modelMap.addAttribute("msg", "Query Sent");
			
		}
		
		return "queryPage";
	} else {
		modelMap.addAttribute("errMsg", "Please Login First");
		return "consumerLoginPage";
	}
}

}//end of class
