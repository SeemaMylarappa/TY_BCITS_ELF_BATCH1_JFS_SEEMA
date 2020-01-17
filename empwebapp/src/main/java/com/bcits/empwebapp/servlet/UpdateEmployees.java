package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.empwebapp.bean.EmployeePrimaryInfo;

@WebServlet("/updateEmployee")
public class UpdateEmployees extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String empIdVal = req.getParameter("empId");
		String empNameVal=req.getParameter("ename");
		int empId = Integer.parseInt(empIdVal);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emsPersistenceUnit");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		EmployeePrimaryInfo employeePrimaryInfo=manager.find(EmployeePrimaryInfo.class,empId);
		boolean isAdded=false;
		resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		try {
			transaction.begin();
			employeePrimaryInfo.setE_name(empNameVal);
			transaction.commit();
			isAdded=true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		out.println("<html>");
		out.println("<body>");
		if (isAdded) {
			out.println("<h1 style='color:green'>Employee ID " + empId +" updated -</h1>");	
		}else {
			out.println("<h1 style='color:green'>Employee ID " + empId +" Not Updated -</h1>");
		}
		out.println("</html>");
		out.println("</body>");
		
		manager.close();
		entityManagerFactory.close();
		
	}
}
