package com.bcits.empwebapp.jspservlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.empwebapp.bean.EmployeePrimaryInfo;

@WebServlet("/login2")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get the form data
		int empIdVal = Integer.parseInt(req.getParameter("empId"));
		String password = req.getParameter("password");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPersistenceUnit");
		EntityManager manager = emf.createEntityManager();

		String jpql = " from EmployeePrimaryInfo where emp_id=:empId and password=:pwd ";
		Query query = manager.createQuery(jpql);
		query.setParameter("empId", empIdVal);
		query.setParameter("pwd", password);

		EmployeePrimaryInfo employeePrimaryInfo = null;
		try {

			employeePrimaryInfo = (EmployeePrimaryInfo) query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
				
				if(employeePrimaryInfo != null) {
				//Valid Credentials
					HttpSession session=req.getSession(true);
					session.setAttribute("EmployeePrimaryInfo", employeePrimaryInfo);
					
					req.getRequestDispatcher("./homePage.jsp").forward(req, resp);
					
				}else {
					//Invalid Credentials
					req.setAttribute("msg", "Invalid EmployeeID/Password! ");
					req.getRequestDispatcher("./LoginForm.jsp").forward(req, resp);
				}
	}

}
