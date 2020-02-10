<%@page import="com.bcits.usecase.beans.EmployeeMaster"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bcits.usecase.beans.MonthlyConsumption"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%  String msg=(String)request.getAttribute("msg");
    String errMsg=(String)request.getAttribute("errMsg");
    EmployeeMaster master = (EmployeeMaster) session.getAttribute("empLoggedIn");
    List<MonthlyConsumption> monthlyConsumption = (List<MonthlyConsumption>) request.getAttribute("billList");%>
<!DOCTYPE html>
<html>
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
  
  <table class="table table-hover">
			<thead>
				<tr>
					
					<th scope="col">Date &nbsp;&nbsp;&nbsp;</th>
					<th scope="col">Units Consumed&nbsp;&nbsp;&nbsp;</th>
					<th scope="col">Amount&nbsp;&nbsp;&nbsp;</th>
					<th scope="col">Previous Reading&nbsp;&nbsp;&nbsp;</th>
					<th scope="col">Current Reading&nbsp;&nbsp;&nbsp;</th>
					<th scope="col">Region&nbsp;&nbsp;&nbsp;</th>
					
				</tr>
			</thead>
			<tbody>
				
    <% for(MonthlyConsumption list : monthlyConsumption) {  %>
		<% SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy"); %>	
		<tr>		
        <td><%= format.format(list.getMonthlyConsumptionprikey().getDate())%>&nbsp;&nbsp;&nbsp;</td>
         <td><%=list.getUnitsConsumed()%>&nbsp;&nbsp;&nbsp;</td>
           <td><%=list.getAmount()%>&nbsp;&nbsp;&nbsp;</td>
           <td><%=list.getPreviousReading()%>&nbsp;&nbsp;&nbsp;</td>
           <td><%=list.getCurrentReading()%>&nbsp;&nbsp;&nbsp;</td>
           <td><%=list.getRegion()%>&nbsp;&nbsp;&nbsp;</td>
           </tr>
           <% } %>
				
   </tbody>
		</table>
  <br><br>
</body>
</html>