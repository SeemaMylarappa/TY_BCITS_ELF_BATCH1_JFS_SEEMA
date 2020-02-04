<%@page import="com.bcits.usecase.beans.ConsumerMaster"%>
<%@page import="com.bcits.usecase.beans.CurrentBill"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
	<% ConsumerMaster master = (ConsumerMaster) session.getAttribute("LoggedIn");
	CurrentBill currentBill = (CurrentBill) request.getAttribute("currentbill"); %>
	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
    <spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>consumerBill</title>
<link rel="stylesheet" href="${css}/consumerBill.css">
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
								<a href="./logout">LogOut &nbsp;&nbsp;&nbsp;</a>
							</h3></th>
					</tr>
				</thead>
				</table>

<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">RR Number&nbsp;&nbsp;&nbsp;</th>
      <th scope="col">Initial Reading&nbsp;&nbsp;&nbsp;</th>
      <th scope="col">Final Reading&nbsp;&nbsp;&nbsp;</th>
      <th scope="col">Units consumed&nbsp;&nbsp;&nbsp;</th>
       <th scope="col">No of days&nbsp;&nbsp;&nbsp;</th>
        <th scope="col">Amount&nbsp;&nbsp;&nbsp;</th>
    </tr>
  </thead>
  <tbody>
    <tr>
    
      <td><%= currentBill.getRrNumber() %>&nbsp;&nbsp;&nbsp;</td>
      <td><%= currentBill.getInitialReading() %>&nbsp;&nbsp;&nbsp;</td>
      <td><%= currentBill.getFinalReading() %>&nbsp;&nbsp;&nbsp;</td>
      <td><%= currentBill.getUnitsConsumed() %>&nbsp;&nbsp;&nbsp;</td>
      <td><%= currentBill.getNoOfDays() %>&nbsp;&nbsp;&nbsp;</td>
      <td><%= currentBill.getAmount() %>&nbsp;&nbsp;&nbsp;</td>
     
    </tr>
 
  </tbody>
</table>



</fieldset>


<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>