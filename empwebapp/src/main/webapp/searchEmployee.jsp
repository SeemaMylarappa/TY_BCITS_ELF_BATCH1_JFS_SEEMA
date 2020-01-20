<%@page import="com.bcits.empwebapp.bean.EmployeePrimaryInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <% EmployeePrimaryInfo employeePrimaryInfo 
   = (EmployeePrimaryInfo) request.getAttribute("EmployeePrimaryInfo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <fieldset>
     <legend>Search Employee</legend>
     <!-- <form action="./findEmployee">- -->
        <form action="./getEmp">
     <label>Employee ID: </label>
      <input type="text" name="empId" required>
      &nbsp; &nbsp; &nbsp; &nbsp;
     <input type="submit" value="Search">
    </form>
     </fieldset>
     
     <% if(employeePrimaryInfo != null) { %>
     Name = <%= employeePrimaryInfo.getE_name() %><br>
     Salary = <%= employeePrimaryInfo.getSalary() %><br>
     Designation = <%= employeePrimaryInfo.getDesignation() %><br>
     <% } else { %>
     <h2 style="color:red">Employee ID Not Found!!</h2>
     
     
     <% } %>
     
     

</body>
</html>