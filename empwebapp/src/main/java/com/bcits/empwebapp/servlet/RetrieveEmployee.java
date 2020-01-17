package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/retrieveEmployee")
public class RetrieveEmployee extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPersistenceUnit");
		EntityManager manager = factory.createEntityManager();
		
		String jpql = "from EmployeePrimaryInfo";

		Query query = manager.createQuery(jpql);
		List<EmployeePrimaryInfo> list = query.getResultList();
		PrintWriter out=resp.getWriter();

		for (EmployeePrimaryInfo employeePrimaryInfo : list) {

			out.println("employee_Id=" + employeePrimaryInfo.getEmp_id());
			out.println("employee_Name=" + employeePrimaryInfo.getE_name());
			out.println("employee_MobileNo=" + employeePrimaryInfo.getMobile_no());
			out.println("official_mailid = " + employeePrimaryInfo.getOfficial_mailid());
			out.println("date of birth =  " + employeePrimaryInfo.getDate_of_birth());
			out.println("date of joing = " + employeePrimaryInfo.getDate_of_join());
			out.println("designation =" + employeePrimaryInfo.getDesignation());
			out.println("Password=" + employeePrimaryInfo.getPassword());
			out.println("salary= " + employeePrimaryInfo.getSalary());
			out.println("dept_id=" + employeePrimaryInfo.getdepartment_id());
			out.println("manger_id=" + employeePrimaryInfo.getManager_id());
			out.println("=================================================");
		}

		manager.close();

	
	}

}
