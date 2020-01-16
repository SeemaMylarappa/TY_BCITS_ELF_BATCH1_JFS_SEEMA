package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createCookie")
public class createCookieServlet extends HttpServlet{
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie myCookie=new Cookie("eName", "Prashul");
		myCookie.setMaxAge(7*24*60*60);
		resp.addCookie(myCookie);
		
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1 style='color: green'>Cookie Created successfully!");
		out.println("</html>");
		out.println("</body>");
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("./cokkiePage.html");
		dispatcher.include(req, resp);
		
		
	}//end of doGet()
}//end of class
