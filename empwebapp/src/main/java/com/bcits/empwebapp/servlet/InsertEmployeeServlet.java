package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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


@WebServlet("/insertEmployee")
public class InsertEmployeeServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//Get the form data
		String empIdVal=req.getParameter("empId");
		String nameval=req.getParameter("e_name");
		String designationVal=req.getParameter("designation");
		String salaryVal=req.getParameter("salary");
		String mobileVal=req.getParameter("mobile_no");
		String passwordVal=req.getParameter("password");
		String joiningdateVal=req.getParameter("date_of_join");
		String dateofbirthVal=req.getParameter("date_of_birth");
		String manageridVAl=req.getParameter("manager_id");
		String departmentidVal=req.getParameter("department_id");
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date joiningDate=null;
		Date dateofbirth=null;
		try {
		 joiningDate= dateFormat.parse(joiningdateVal);
		 dateofbirth=dateFormat.parse(dateofbirthVal);
		}catch(ParseException e1) {
			e1.printStackTrace();
		}
		
		EmployeePrimaryInfo emp=new EmployeePrimaryInfo();
		emp.setEmp_id(Integer.parseInt(empIdVal));
		emp.setE_name(nameval);
		emp.setDesignation(designationVal);
		emp.setSalary(Double.parseDouble(salaryVal));
		emp.setMobile_no(Long.parseLong(mobileVal));
		emp.setPassword(passwordVal);
		emp.setDate_of_join(joiningDate);
		emp.setDate_of_birth(dateofbirth);
		emp.setdepartment_id(Integer.parseInt(departmentidVal));
		emp.setManager_id(Integer.parseInt(manageridVAl));
		
		
		//Store data into DB
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("emsPersistenceUnit");
		EntityManager manager=emf.createEntityManager();
		EntityTransaction tx=manager.getTransaction();
		boolean isAdded=false;
		try {
		tx.begin();
		manager.persist(emp);
		tx.commit();
		isAdded=true;
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		manager.close();
		emf.close();
		
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		if (isAdded) {
			//Employee added successfully
			out.println("<h1 style:'color:green'>Employee record for ID " + empIdVal + " Inserted ");
		}else {
			//Not added
			out.println("<h1 style='color:red'> Unable to add employee record!! </h1>");
		}
		out.println("</html>");
		out.println("</body>");
	}//end of doPost
	
}
