<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	 <% String msg=(String)request.getAttribute("msg");
     String errMsg=(String)request.getAttribute("errMsg");%>
    <spring:url var="css" value="/resources/css" />
    <spring:url var="js" value="/resources/js" />
    <spring:url var="images" value="/resources/images" />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>payment</title>
<link rel="stylesheet" href="${css}/paymentpage.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">

</head>

<body>
 <% if(errMsg != null && !errMsg.isEmpty()) { %>
  
  <h5 style="color: red;font-size: 35px; font: bold;margin-right: 50px;align:center;"><%= errMsg %></h5>
  
  <% } %>
  <% if(msg != null && !msg.isEmpty()) { %>
  
  <h5 style="color: green;font-size: 35px; font: bold;margin-right: 50px;align:center;"><%=msg %></h5>
  
  <% } %>
<form action="./paymentSucccessPage" >
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
	<form action="./paymentSucccessPage" >
		<div
			class="col-10 col-sm-10 col-md-10 col-lg-10 col-xl-10 mt-5 mx-auto d-block bg-img">
			<div class="container">
				<div class="row">
					<aside class="col-sm-6">
						<article class="card">
							<div class="card-body p-5">
								<h3 style="text-align: center;">PAYMENT DETAILS</h3>
								<form role="form">
									<div class="form-group">
										<label for="username">Full name (on the card)</label>
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text"><i class="fa fa-user"></i></span>
											</div>
											<input type="text" class="form-control" name="username"
												placeholder="" required="">
										</div>
									</div>
									

									<div class="form-group">
										<label for="cardNumber">Card number</label>
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text"><i
													class="fa fa-credit-card"></i></span>
											</div>
											<input type="number" class="form-control" name="cardNumber"
												placeholder="">
										</div>
									</div>
									
									<div class="form-group">
										<label for="cardNumber">Amount</label>
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text"><i
													class="fa fa-credit-card"></i></span>
											</div>
											<input type="number" class="form-control" name="amount"
												placeholder="">
										</div>
									</div>
									
									
									
									
									
									
									
									

									<div class="row">
										<div class="col-sm-8">
											<div class="form-group">
												<label><span class="hidden-xs">Expiration</span> </label>
												<div class="form-inline">
													<select class="form-control" style="width: 45%">
														<option>MM</option>
														<option>01 - January</option>
														<option>02 - February</option>
														<option>03 - March</option>
														<option>04 - April</option>
														<option>05 - May</option>
														<option>06 - June</option>
														<option>07 - July</option>
														<option>08 - August</option>
														<option>09 - September</option>
														<option>10 - October</option>
														<option>11 - November</option>
														<option>12 - December</option>
													</select> <span style="width: 10%; text-align: center"> / </span> <select
														class="form-control" style="width: 45%">
														<option>YY</option>
														<option>2018</option>
														<option>2019</option>
														<option>2020</option>
														<option>2021</option>
														<option>2022</option>
														<option>2023</option>
														<option>2024</option>
														<option>2025</option>
														<option>2026</option>
														<option>2027</option>
														<option>2028</option>
														<option>2029</option>
														<option>2030</option>
													</select>
												</div>
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group">
												<label data-toggle="tooltip" title=""
													data-original-title="3 digits code on back side of the card">CVV
													<i class="fa fa-question-circle"></i>
												</label> <input class="form-control" required="" type="text">
											</div>
										</div>
									</div>
									<button class="subscribe btn btn-primary btn-block"
										type="submit">PAY</button>
								</form>
							</div>
						</article>
				</div>
	</form>
	</form>
	<script src="${js}/jquery-3.4.1.js"></script>
  <script src="${js}/bootstrap.min.js" ></script>
</body>

</html>