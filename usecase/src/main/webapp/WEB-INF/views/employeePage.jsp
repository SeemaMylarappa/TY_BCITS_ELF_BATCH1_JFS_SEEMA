<%@page import="com.bcits.usecase.beans.EmployeeMaster"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <% EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("empLoggedIn"); %>
    <spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>EmployeePage</title>
<link rel="stylesheet" href="${css}/consumerdetailPage.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
<style type="text/css">
</style>
</head>
<body>
<br>
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




























<%-- <div class="row">
  <div class="col-4">
    <div class="list-group" id="list-tab" role="tablist">
      <a href="./consumerlist">Consumer Details</a>
      <a href="#list-messages">Generate Bill</a>
      <a href="#list-profile" >Monthly Bill Generated</a>
      <a href="#list-settings">Monthly Bill Collected</a>
    </div>
  </div>
  <div class="col-8">
    <div class="tab-content" id="nav-tabContent">
      <div class="tab-pane fade show active" id="list-home" role="tabpanel" aria-labelledby="list-home-list">...</div>
      <div class="tab-pane fade" id="list-profile" role="tabpanel" aria-labelledby="list-profile-list">...</div>
      <div class="tab-pane fade" id="list-messages" role="tabpanel" aria-labelledby="list-messages-list">...</div>
      <div class="tab-pane fade" id="list-settings" role="tabpanel" aria-labelledby="list-settings-list">...</div>
    </div>
  </div>
</div>
<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
 --%></form>
</body>
</html>