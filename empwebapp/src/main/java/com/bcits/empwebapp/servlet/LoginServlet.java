package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.empwebapp.bean.EmployeePrimaryInfo;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

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
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		if (employeePrimaryInfo != null) {
			// Valid Credentials
			// create session
			HttpSession session = req.getSession(true);
			session.setMaxInactiveInterval(60); //time in seconds
			
			session.setAttribute("EmployeePrimaryInfo", employeePrimaryInfo);

			out.println("<h1 style='color:navy'>Welcome " + employeePrimaryInfo.getE_name() + "</h1>");

			RequestDispatcher dispatcher = req.getRequestDispatcher("./employeeLogin.html");
			dispatcher.include(req, resp);

		} else {

			out.println("<h1 style='color=red'>Invalid Credentials!!!</h1>");

			RequestDispatcher dispatcher = req.getRequestDispatcher("./loginForm.html");
			dispatcher.include(req, resp);

		}
		out.println("</html>");
		out.println("</body>");
		manager.close();
		emf.close();

	}// end of doPost()

}// end of class
