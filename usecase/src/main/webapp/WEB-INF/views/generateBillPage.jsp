<%@page import="com.bcits.usecase.beans.EmployeeMaster"%>
<%@page import="com.bcits.usecase.beans.MonthlyConsumption"%>
<%@page import="com.bcits.usecase.beans.ConsumerMaster"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% ConsumerMaster consumerMaster = (ConsumerMaster) request.getAttribute("consdetail");
   double previousRead = (double) request.getAttribute("previousReading");
   EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("empLoggedIn");%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-light bg-light">
  <form class="form-inline">
  <a href="./consumerlist">
  <button class="btn btn-outline-success" type="button">Consumer Details</button>
  </a>
   <a href="./generateBill">
  <button class="btn btn-outline-success" type="button">Generate Bill</button>
  </a>
   <a href="#">
  <button class="btn btn-outline-success" type="button">Monthly Bill Generated</button>
  </a>
   <a href="./consumerlist">
  <button class="btn btn-outline-success" type="button">Monthly Bill Collected</button>
  </a>
  <a href="./emplogout">
  <button class="btn btn-outline-success" type="button">LogOut</button>
  </a>  
    
  </form>
</nav>
<table class="table table-bordered">
  <thead>
    <tr>
    <th scope="col">empId</th>
      <th scope="col">RR Number</th>
      <th scope="col">Previous Reading</th>
      <th scope="col">Current Reading</th>
       <th scope="col">Type of Consumer</th>
      <th scope="col">Due Date</th>
    </tr>
  </thead>
  <tbody>
    <tr>
     <% if(consumerMaster != null) { %>
     <td><%=employeeMaster.getEmpId() %></td>
      <td><%=consumerMaster.getRrNumber() %></td>
       <td><%=previousRead %></td>
        <td><%=consumerMaster.getTypeOfConsumer() %></td>
         <td><%= %></td>
      <a href="#">
  <button class="btn btn-outline-success" type="button">Generate Bill</button>
  </a> 
    </tr>
   <% } %>
  </tbody>
</table>





</body>
</html>