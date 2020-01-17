package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet{
	
	 public DateServlet() {
		System.out.println("it is instantion phase!!!");
	}
	 
	 @Override
	public void init() throws ServletException {
		System.out.println("It is initialization phase!!!");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	//java code to generate current system date and time(dynamic)
		Date date=new Date();
		
		//Getting Config Parameter
		ServletConfig config=getServletConfig();
		String myConfigParamVal=config.getInitParameter("servletName");
		
		//Getting Context Parameter
		ServletContext context=getServletContext();
		String myContextParamVal=context.getInitParameter("appName");
		
		
	//code to generate dynamic response	
		resp.setContentType("text/html");
		resp.setHeader("refresh", "1");
		
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Current System Date and Time is:- " +date+"</h1>");
		out.println("<h2>Servlet Name =" + myConfigParamVal + "</h2>");
		out.println("<h2>Servlet Name =" + myContextParamVal + "</h2>");
		out.println("</body>");
		out.println("</html>");
		
	}//end of doGet()
	
	@Override
	public void destroy() {
		System.out.println("It is destroy phase!!");
	}

}//end of class
