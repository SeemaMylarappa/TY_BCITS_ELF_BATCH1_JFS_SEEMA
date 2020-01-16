package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchEmployeeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws 
	ServletException, IOException {
	String empIdVal=req.getParameter("empId");
	
	
	//Getting Config Parameter
			ServletConfig config=getServletConfig();
			String myConfigParamVal=config.getInitParameter("servletName");
			
			//Getting Context Parameter
			ServletContext context=getServletContext();
			String myContextParamVal=context.getInitParameter("appName");
			
	
	
	resp.setContentType("text/html"); 
		
	PrintWriter out=resp.getWriter();
	out.print("<html>");
	out.print("<body>");
	out.print("<h1>Emp ID= "+empIdVal+ "</h1>");
	out.print("Emp Name=Seema <br>");
	out.print("Emp age=22 <br>");
	out.print("Emp salary=45000 <br>");
	out.print("Emp designation=Developer <br>");
	out.println("<h2>Servlet Name =" + myConfigParamVal + "</h2>");
	out.println("<h2>Servlet Name =" + myContextParamVal + "</h2>");
	out.print("</body>");
	out.print("</html>");
		
		
	}//end of doGet()                                                  
	

}//end of class
