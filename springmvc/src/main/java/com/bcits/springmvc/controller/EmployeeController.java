package com.bcits.springmvc.controller;

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
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bcits.springmvc.DAO.EmployeeDAO;
import com.bcits.springmvc.bean.EmployeeInfoBean;
import com.bcits.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}

	@Autowired
	private EmployeeService service;

	@GetMapping("/login")
	public String displayLoginForm() {

		System.out.println("Inside the get mapping");

		return "empLoginForm";

	}// end of displayLoginForm()

	@PostMapping("/login")
	public String authenticate(int empId, String password, HttpServletRequest req, ModelMap modelMap) {

		EmployeeInfoBean employeeInfoBean = service.authenticate(empId, password);

		System.out.println("Inside the post mapping");

		if (employeeInfoBean != null) {
			// valid credentials
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedInEmpInfo", employeeInfoBean);
			return "employeeHome";
		} else {
			// Invalid credentials
			modelMap.addAttribute("errMsg", "Invalid Credentials!!");
			return "empLoginForm";
		}
	}// end of authenticate()

	@GetMapping("/searchEmp")
	public String displaySearchEmployeeForm(HttpSession session, ModelMap modelMap) {

		if (session.isNew()) {
			// user not logged in
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First!");
			return "empLoginForm";
		} else {
			// user not logged in
			return "searchEmp";
		}
	}

	@GetMapping("/search")
	public String searchEmployee(int empId, HttpSession session, ModelMap modelMap) {

		if (session.getAttribute("loggedInEmpInfo") != null) {
			// valid session

			EmployeeInfoBean employeeInfoBean = service.getEmployee(empId);

			if (employeeInfoBean != null) {
				modelMap.addAttribute("employeeInfoBean", employeeInfoBean);
			} else {
				modelMap.addAttribute("errMsg", "Employee ID Bot Found");
			}
			return "searchEmp";
		} else {
			// Invalid credentials
			modelMap.addAttribute("errMsg", "Please Login First!");
			return "empLoginForm";
		}
	}// end of searchEmployee()

	@GetMapping("/deleteEmpForm")
	public String displayDeleteEmployeeForm(
			@SessionAttribute(name = "loggedInEmpInfo", required = false) EmployeeInfoBean employeeInfoBean,
			ModelMap modelMap) {
		if (employeeInfoBean != null) {
			// Valid session
			return "deleteEmpForm";
		} else {
			// invalid session
			modelMap.addAttribute("errMsg", "Please Login First!");
			return "empLoginForm";
		}
	}// end of displayDeleteEmployeeForm()

	@GetMapping("/delete")
	public String deleteEmployee(int empId,
			@SessionAttribute(name = "loggedInEmpInfo", required = false) EmployeeInfoBean employeeInfoBean,
			ModelMap modelMap) {

		if (employeeInfoBean != null) {
			// valid session
			if (service.deleteEmployee(empId)) {
				modelMap.addAttribute("msg", "Employee Record deleted Successfully...");
			} else {
				modelMap.addAttribute("errMsg", "Employee Record Not Found...");
			}
			return "deleteEmpForm";

		} else {
			// invalid session
			modelMap.addAttribute("errMsg", "Please Login First!");
			return "empLoginForm";
		}
	}// end of deleteEmployee()

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap modelMap) {

		session.invalidate();
		modelMap.addAttribute("errMsg", "You Are Successfully logged Out");

		return "empLoginForm";

	}// end of logout()

	@GetMapping("/getAllEmployee")
	public String displaygetEmployee(
			@SessionAttribute(name = "loggedInEmpInfo", required = false) EmployeeInfoBean employeeInfoBean,
			ModelMap modelMap) {

		if (employeeInfoBean != null) {
			List<EmployeeInfoBean> list = service.getAllEmployees();
			modelMap.addAttribute("empDetails", list);
			return "getEmployee";
		} else {
			// invalid session
			modelMap.addAttribute("errMsg", "Please Login First!");
			return "empLoginForm";

		}

	}// end of displaygetEmployee()

	@GetMapping("/updateEmployee")
	public String displayUpdateEmployee(
			@SessionAttribute(name = "loggedInEmpInfo", required = false) EmployeeInfoBean employeeInfoBean,
			ModelMap modelMap) {
		if (employeeInfoBean != null) {
			// Valid session
			return "updateEmployee";
		} else {
			// invalid session
			modelMap.addAttribute("errMsg", "Please Login First!");
			return "empLoginForm";
		}
	}// end of updateEmployeeForm()

	@PostMapping("/update")
	  public String updateEmployee( EmployeeInfoBean empBean,
	@SessionAttribute(name = "loggedInEmpInfo", required = false) EmployeeInfoBean employeeInfoBean,ModelMap modelMap) {
		  if (employeeInfoBean != null) {
				// valid session
				if (service.updateEmployee(empBean)) {
					modelMap.addAttribute("msg", "Employee Record updated Successfully...");
				} else {
					modelMap.addAttribute("errMsg", "Employee Record Not Found...");
				}
				return "updateEmployee";

			} else {
				// invalid session
				modelMap.addAttribute("errMsg", "Please Login First!");
				return "empLoginForm";  
	  }
	  }//end of updateEmployee()
	@GetMapping("/addEmployee")
	public String displayAddEmployee(
			@SessionAttribute(name = "loggedInEmpInfo", required = false) EmployeeInfoBean employeeInfoBean,
			ModelMap modelMap) {
		if (employeeInfoBean != null) {
			// Valid session
			return "addEmployee";
		} else {
			// invalid session
			modelMap.addAttribute("errMsg", "Please Login First!");
			return "empLoginForm";
		}
	}// end of updateEmployeeForm()

	@PostMapping("/add")
	  public String addEmployee( EmployeeInfoBean empBean,
	@SessionAttribute(name = "loggedInEmpInfo", required = false) EmployeeInfoBean employeeInfoBean,ModelMap modelMap) {
		  if (employeeInfoBean != null) {
				// valid session
				if (service.updateEmployee(empBean)) {
					modelMap.addAttribute("msg", "Employee Record added Successfully...");
				} else {
					modelMap.addAttribute("errMsg", "Employee Record Not Found...");
				}
				return "addEmployee";

			} else {
				// invalid session
				modelMap.addAttribute("errMsg", "Please Login First!");
				return "empLoginForm";  
	  }
	  }//end of updateEmployee()
	 

}
