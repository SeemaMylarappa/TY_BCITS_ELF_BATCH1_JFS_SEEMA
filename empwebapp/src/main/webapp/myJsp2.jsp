<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%! private int a=30;

    public void setA(int a){
    	this.a=a;
    }
    
    public int getA(){
    	return a;
    }
    
    public String name="Seema";
    
    public String getName(){
    	return name;
    }
    
  public String getName(String name){
	  return name;
  }
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:blue;">Welcome to JSP</h1>
  a = <%= a %><br>
  a = <%= getA() %><br>
 <% setA(100); %>
  a = <%= getA() %><br>
  Name = <%= name %><br>
  Name = <%= getName() %><br>
  Name = <%= getName("Sneha") %><br><br>
  <%  for(int i=0;i<5;i++) { %>
  <%= getName() %> <br>
  <% } %>
 
</body>
</html>

<%-- <jsp:include page="/searchEmp">
<jsp:param value="123" name="empId"/>
</jsp:include> --%>

<%@ include file="date.html" %>
<%-- <%@ include file="/currentDate" %>  --%> <!-- not allowed(dynamic resource) -->

