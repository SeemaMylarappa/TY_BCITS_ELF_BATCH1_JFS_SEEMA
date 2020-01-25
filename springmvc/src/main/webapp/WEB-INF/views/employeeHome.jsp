<%@page import="com.bcits.springmvc.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% EmployeeInfoBean employeeInfoBean=(EmployeeInfoBean) session.getAttribute("loggedInEmpInfo"); %>
    <jsp:include page="header.jsp" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management Portal</title>
</head>
<body>
  <h1 style="color: purple;">Welcome <%=employeeInfoBean.getEName() %></h1>
</body>
</html>

<jsp:include page="footer.jsp" />