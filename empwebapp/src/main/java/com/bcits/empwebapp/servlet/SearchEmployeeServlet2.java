package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.empwebapp.bean.EmployeePrimaryInfo;

@WebServlet("/findEmployee")
public class SearchEmployeeServlet2 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	//Get the form data
		String empIdVal=req.getParameter("empId");
		int empId=Integer.parseInt(empIdVal);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("emsPersistenceUnit");
		EntityManager manager=emf.createEntityManager();
		
		EmployeePrimaryInfo employeePrimaryInfo=manager.find(EmployeePrimaryInfo.class, empId);
		
		//Generate Dynamic Response
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		if (employeePrimaryInfo != null) {
		//display employee record
			out.println("<html>");
			out.println("<body>");
			out.println("<h1 style='color:green'>Employee ID " + empId +" Found -</h1>");
			out.println("Name=" + employeePrimaryInfo.getE_name());
			out.println("<br>Designation="+ employeePrimaryInfo.getDesignation());
			out.println("<br>Salary="+ employeePrimaryInfo.getSalary());
			out.println("<br>mobile="+ employeePrimaryInfo.getMobile_no());
			out.println("</html>");
			out.println("</body>");
		}else {
			//display empId not found
			out.println("<html>");
			out.println("<body>");
			out.println("<h1 style='color:red'>Employee ID "+ empId + " Not Found!!!</h1>");
			out.println("</html>");
			out.println("</body>");
		}
		manager.close();
		emf.close();
		
		
	}//end of doGet()

}//end of class
