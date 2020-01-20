package com.bcits.empwebapp.jspservlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.empwebapp.bean.EmployeePrimaryInfo;


@WebServlet("/getEmp")
public class GetEmployeeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//get the form data
		String empIdVal=req.getParameter("empId");
		int empId=Integer.parseInt(empIdVal);
		
		//search record in DB
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("emsPersistenceUnit");
		EntityManager manager=emf.createEntityManager();
		
	EmployeePrimaryInfo employeePrimaryInfo=manager.find(EmployeePrimaryInfo.class, empId);
	
	req.setAttribute("EmployeePrimaryInfo", employeePrimaryInfo);
		
	//send data to jsp
	
	
	
	manager.close();
	emf.close();
	
	req.getRequestDispatcher("./searchEmployee.jsp").forward(req, resp);
		
	}//end of doGet()
	
	
	
	

}//end of class
