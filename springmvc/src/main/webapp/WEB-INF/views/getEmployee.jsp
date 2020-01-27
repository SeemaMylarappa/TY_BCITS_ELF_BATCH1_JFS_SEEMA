<%@page import="java.util.List"%>
<%@page import="com.bcits.springmvc.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <% List<EmployeeInfoBean> employeesList= (List<EmployeeInfoBean>) request.getAttribute("empDetails"); %>
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
  <% for(EmployeeInfoBean empInfo : employeesList) { %>
  <tr style="height: 25px">
  <td><%= empInfo.getEmpId() %></td>
  <td><%= empInfo.getEName() %></td>
  <td><%= empInfo.getSalary() %></td>
  <td><%= empInfo.getDepartmentId() %></td>
  <td><%= empInfo.getDateOfBirth() %></td>
  <td><%= empInfo.getDateOfJoin() %></td>
  <td><%= empInfo.getOfficialMailid()  %></td>
  <td><%= empInfo.getDesignation() %></td>
  <td><%= empInfo.getManagerId() %></td>
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