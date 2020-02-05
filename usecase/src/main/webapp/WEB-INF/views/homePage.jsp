<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String msg=(String)request.getAttribute("msg");
     String errmsg=(String)request.getAttribute("errmsg");%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <spring:url var="css" value="/resources/css" />
    <spring:url var="js" value="/resources/js" />
    <spring:url var="images" value="/resources/images" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>homepage</title>
   <link rel="stylesheet" href="${css}/homepage.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
  
</head>
<body >
<% if(errmsg != null && !errmsg.isEmpty()) { %>
  
  <h5 style="color: red;font-size: 35px; font: bold;margin-right: 50px;align:center;"><%= errmsg %></h5>
  
  <% } %>
  <% if(msg != null && !msg.isEmpty()) { %>
  
  <h5 style="color: green;font-size: 35px; font: bold;margin-right: 50px;align:center;"><%=msg %></h5>
  
  <% } %>
<div class="background">
    <form action="./home" method="get">

        <div class="col-10 col-sm-10 col-md-10 col-lg-10 col-xl-10 mt-5 mx-auto d-block bg-img">
           
            <h3 style="text-align: center; font-weight: 700; font-size: 60px;color:orange">DISCOM PRIVATE LIMITED</h3>
            <div class="login">
                <button  type="button" class="btn btn-light btn-lg">
                    <i class="far fa-user"></i>
                    <a style="color: black;text-align: center;" href="./employeeLoginPage" >Employee Login</a>   
                       </button>
                    </div>
                    <div class="login1">
                        <button  type="button" class="btn btn-light btn-lg">
                            <i class="fas fa-user"></i>
                               <a style="color: black;text-align: center;" href="./consumerLoginPage">Consumer Login</a>
                               </button>
                    </div>    
        </div>

    </form>
    </div>
    <script src="${js}/jquery-3.4.1.js"></script>
  <script src="${js}/bootstrap.min.js" ></script>
</body>
</html>