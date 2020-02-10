<%@page import="com.bcits.usecase.beans.ConsumerMaster"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% ConsumerMaster consumerMaster = (ConsumerMaster)session.getAttribute("LoggedIn");
    String msg=(String)request.getAttribute("msg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>consumerBill</title>
<link rel="stylesheet" href="${css}/consumerHistory.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">

</head>
<body>
  <% if(msg != null && !msg.isEmpty()) { %>
  
  <h5 style="color: green;font-size: 35px; font: bold;margin-right: 50px;align:center;"><%=msg %></h5>
  
  <% } %>

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
							<a href="./monthlyConsumption"> Monthly Consumption
								&nbsp;&nbsp;&nbsp;</a>
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

 <br>
  <br>
<form action="./getResponse" class="container">
 <br>
<div class="form-group">
    <label for="exampleFormControlTextarea1"><h3>Add Query</h3></label>
    <textarea class="form-control" id="support" name="support" rows="3"></textarea>
    <br>
    <button type="submit" class="btn btn-outline-dark">Send</button>
  </div>

</form>
</body>
</html>