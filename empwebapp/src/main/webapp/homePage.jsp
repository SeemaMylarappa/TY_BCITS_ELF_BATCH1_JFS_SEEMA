<%@page import="com.bcits.empwebapp.bean.EmployeePrimaryInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% EmployeePrimaryInfo empInfo = (EmployeePrimaryInfo) session.getAttribute("EmployeePrimaryInfo"); %>
    
    <jsp:include page="header.jsp" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <h1>Welcome <%= empInfo.getE_name() %>...</h1>
</body>
</html>