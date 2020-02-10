

<%@page import="java.util.List"%>
<%@page import="com.bcits.usecase.beans.ConsumerMaster"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<% List<ConsumerMaster> consumerMaster = (List<ConsumerMaster>) request.getAttribute("consumer"); %>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>consumerDetails</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">

</head>

<body>
	<fieldset>	
	<br>
	<nav class="navbar navbar-light bg-light">
  <form class="form-inline">
  <a href="./consumerlist">
  <button class="btn btn-outline-success" type="button">Consumer Details</button>
  </a>
   <a href="./generateBillPage">
  <button class="btn btn-outline-success" type="button">Generate Bill</button>
  </a>
  <a href="./seeGeneratedBills">
  <button class="btn btn-outline-success" type="button">Bill Generated Details</button>
  </a>
  <a href="./emplogout">
  <button class="btn btn-outline-success" type="button">LogOut</button>
  </a>
    
    
  </form>
</nav>
	<br><br>		
<table class="table">
<% if(consumerMaster != null)  { %>		
  <thead>
    <tr>
      <th scope="col">Name</th>
     
      <th scope="col">emailId</th>
      <th scope="col">mobileNo</th>
       <th scope="col">region</th>
      <th scope="col">typeOfConsumer</th>
       <th scope="col">rrNumber</th>
        <th scope="col">Account ID</th>
    </tr>
  </thead>
  <tbody>
 
    
     <% for(ConsumerMaster list : consumerMaster) {%>
        <tr>
       <td><%= list.getFirstName() + " " + list.getLastName() %></td>
        <td><%= list.getEmailId() %></td>
        <td><%= list.getMobileNo() %></td>
        <td><%= list.getRegion() %></td>
         <td><%= list.getTypeOfConsumer() %></td>
         <td><%= list.getRrNumber() %></td>
         <td><%= list.getAccountId() %></td>
             </tr>
     <% } %>

  </tbody>
</table>
	<% } %>		
	
	</fieldset>
	<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>

</body>
</html>