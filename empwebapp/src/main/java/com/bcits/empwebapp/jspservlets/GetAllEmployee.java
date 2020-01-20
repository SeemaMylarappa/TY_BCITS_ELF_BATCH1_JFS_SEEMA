package com.bcits.empwebapp.jspservlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.empwebapp.bean.EmployeePrimaryInfo;

@WebServlet("/seeAllEmployees")
public class GetAllEmployee extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("emsPersistenceUnit");
	EntityManager manager=emf.createEntityManager(); 
	
	String jpql=" from EmployeePrimaryInfo  ";
	Query query=manager.createQuery(jpql);
	
	List<EmployeePrimaryInfo> list= query.getResultList();
	req.setAttribute("seeAll", list );
	
	req.getRequestDispatcher("/seeAllEmployees").forward(req, resp);
		
		
	}//End of doGet()

}//end of class
