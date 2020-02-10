<%@page import="com.bcits.usecase.beans.EmployeeMaster"%><%@page
	import="java.util.List"%>
<%@page import="com.bcits.usecase.beans.MonthlyConsumption"%>
<%@page import="com.bcits.usecase.beans.ConsumerMaster"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <% String msg=(String)request.getAttribute("msg");
     String errMsg=(String)request.getAttribute("errMsg");
 EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("empLoggedIn");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">

</head>
<body>
<% if(errMsg != null && !errMsg.isEmpty()) { %>
  
  <h5 style="color: red;font-size: 35px; font: bold;margin-right: 50px;align:center;"><%= errMsg %></h5>
  
  <% } %>
  <% if(msg != null && !msg.isEmpty()) { %>
  
  <h5 style="color: green;font-size: 35px; font: bold;margin-right: 50px;align:center;"><%=msg %></h5>
  
  <% } %>
	<br>
	<nav class="navbar navbar-light bg-light">
		<form class="form-inline">
			<a href="./consumerlist">
				<button class="btn btn-outline-success" type="button">Consumer
					Details</button></a> 
			<a href="./generateBillPage">
				<button class="btn btn-outline-success" type="button">Generate
					Bill</button></a>
					<a href="./seeGeneratedBills">
                 <button class="btn btn-outline-success" type="button">Bill Generated Details
                 </button></a>
		    <a href="./emplogout">
				<button class="btn btn-outline-success" type="button">LogOut</button>
			</a>


		</form>
	</nav>
	<form action="./generateBill" method="post">
		<div class="row">
			<div class="col">
			<label>RR Number</label>
				<input type="text" name="rrNumber" class="form-control" placeholder="RR Number">
				<br>
				<label>Previous Reading</label>
				 <input type="number" name="initialReading" class="form-control" placeholder="Initial Reading"> 
				 <br>
				 <label>Current Reading</label> 
				 <input type="number" name="finalReading" class="form-control" placeholder="Final Reading">
				<br>
				<label>Type of Consumer</label>
				<select id="inputState" class="form-control" name="typeOfConsumer" required>
                  <option selected disabled >Choose...</option>
                  <option>Residential Consumer</option>
                  <option>Commercial Consumer</option>
                  <option>Industrial Consumer</option>
                </select> 
				 <br> 
				 <label>Due Date</label>
				 <input type="date" class="form-control" name="noOfDays" placeholder="Due Date"> 
				 <br>
				<button type="submit" class="btn btn-primary">Generate</button>
				
			</div>

		</div>
	</form>

</body>
</html>