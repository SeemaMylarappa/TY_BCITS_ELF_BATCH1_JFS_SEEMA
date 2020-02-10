
<%@page import="com.bcits.usecase.beans.ConsumerMaster"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<% ConsumerMaster consumerMaster =(ConsumerMaster)session.getAttribute("LoggedIn"); %>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>consumerdetails</title>
<link rel="stylesheet" href="${css}/consumerDetails.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">

</head>

<body>
	<fieldset>
		
			<table>
				<thead>
					<tr>
						<th><h3>
								<a href="./loginPage"> Account Details &nbsp;&nbsp;&nbsp; </a>
							</h3></th>
						<th><h3>
								<a href="./currentBill">Current Bill &nbsp;&nbsp;&nbsp;</a>
							</h3></th>
						<th><h3>
								<a href="./monthlyConsumption"> Monthly Consumption &nbsp;&nbsp;&nbsp;</a>
							</h3></th>
						<th><h3>
								<a href="./billHistoryPage">Bill History &nbsp;&nbsp;&nbsp;</a>
							</h3></th>
						<th><h3>
								<a href="./paymentPage"> Pay Online &nbsp;&nbsp;&nbsp;</a>
							</h3></th>
							<th><h3>
								<a href="./queryDetails">Add Query &nbsp;&nbsp;&nbsp;</a>
							</h3></th>
							<th><h3>
								<a href="./logout">LogOut &nbsp;&nbsp;&nbsp;</a>
							</h3></th>
							
					</tr>
				</thead>
				</table>
		
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
    <tr>
     
      <td><%= consumerMaster.getFirstName() + " " + consumerMaster.getLastName() %></td>
      <td><%= consumerMaster.getEmailId() %></td>
      <td><%= consumerMaster.getMobileNo() %></td>
      <td><%= consumerMaster.getRegion() %></td>
      <td><%= consumerMaster.getTypeOfConsumer() %></td>
      <td><%= consumerMaster.getRrNumber() %></td>
      <td><%= consumerMaster.getAccountId() %></td>
     
    </tr>
  </tbody>
  <% } %>	
</table>
		
	
	</fieldset>
	<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>

</body>
</html>