<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bcits.usecase.beans.BillHistoryBean"%>
<%@page import="java.util.List"%>
<%@page import="com.bcits.usecase.beans.ConsumerMaster"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
	<% ConsumerMaster master = (ConsumerMaster) session.getAttribute("LoggedIn");
	List<BillHistoryBean> billHistoryBeans = (List<BillHistoryBean>) request.getAttribute("billhistory"); %>
	
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
<link rel="stylesheet" href="${css}/consumerHistory.css">
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

<table class="table table-hover";>
  <thead>
    <tr>
    <th scope="col">PaymentDate&nbsp;&nbsp;&nbsp;</th>
      <th scope="col">Amount&nbsp;&nbsp;&nbsp;</th>
      <th scope="col">Status&nbsp;&nbsp;&nbsp;</th>
      
    </tr>
  </thead>
  <tbody>
      <% for(BillHistoryBean list : billHistoryBeans) {  %>
    <tr>

		<% SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); %>			
        <td><%= formatter.format(list.getBillhistorypk().getPaymentdate()) %>&nbsp;&nbsp;&nbsp;</td>
         <td><%=list.getAmount()%>&nbsp;&nbsp;&nbsp;</td>
           <td><%=list.getStatus()%>&nbsp;&nbsp;&nbsp;</td>
         
    </tr>
     <% } %>
 
  </tbody>
</table>



</fieldset>


<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>