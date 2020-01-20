<%@page import="java.util.List"%>
<%@page import="com.bcits.empwebapp.bean.EmployeePrimaryInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% List<EmployeePrimaryInfo> employeesList= (List<EmployeePrimaryInfo>) request.getAttribute("seeAll"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if(employeesList != null) { %>
  <table border="1" style="width: 80%;">
  <thead style="background: navy; color: white;">
  <tr style="height: 35px">
  <th>Employee ID</th>
  <th>Name</th>
  <th>Salary</th>
  <th>Department ID</th>
  <th>DOJ</th>
  <th>Mobile No</th>
  <th>DOB</th>
  <th>Mail ID</th>
  <th>Designation</th>
  <th>Manager ID</th>
  <th>Password</th>
  </tr>
  </thead>
  <tbody>
  <% for(EmployeePrimaryInfo empInfo : employeesList) { %>
  <tr style="height: 25px">
  <td><%= empInfo.getEmp_id() %></td>
  <td><%= empInfo.getE_name() %></td>
  <td><%= empInfo.getSalary() %></td>
  <td><%= empInfo.getdepartment_id() %></td>
  <td><%= empInfo.getDate_of_birth() %></td>
  <td><%= empInfo.getDate_of_join() %></td>
  <td><%= empInfo.getOfficial_mailid()  %></td>
  <td><%= empInfo.getDesignation() %></td>
  <td><%= empInfo.getManager_id() %></td>
  <td><%= empInfo.getPassword() %></td>
 
  </tr>
  <% } %>
   </tbody>
  </table>
  <% } else { %>
   <h2>No Records!!!</h2>
  <% } %>







</body>
</html>