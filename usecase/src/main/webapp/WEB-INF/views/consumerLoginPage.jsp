<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <% String msg=(String)request.getAttribute("msg");
     String errMsg=(String)request.getAttribute("errMsg");%>
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
  <title>Consumer Details</title>
  <link rel="stylesheet" href="${css}/consumerpage.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">

</head>

<body>
 <% if(errMsg != null && !errMsg.isEmpty()) { %>
  
  <h5 style="color: red;font-size: 35px; font: bold;margin-right: 50px;align:center;"><%= errMsg %></h5>
  
  <% } %>
  <% if(msg != null && !msg.isEmpty()) { %>
  
  <h5 style="color: green;font-size: 35px; font: bold;margin-right: 50px;align:center;"><%=msg %></h5>
  
  <% } %>
  <form action="./loginPage" method="post" class="container">
  <img alt="" src="./lightbulb.jpg">
    <div  class="col-10 col-sm-10 col-md-10 col-lg-10 col-xl-10 mt-5 mx-auto d-block bg-img">
    
  <div class="form-group">
    <label for="exampleInputEmail1"><h3>Email address</h3></label>
    <input type="email" class="form-control" id="emailID" name="emailId" aria-describedby="emailHelp">
   
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1"><h3>Password</h3></label>
    <input type="password" class="form-control" id="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
    title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
  </div>
  <br>
  <button type="submit" class="btn btn-primary">Login</button>
  <br>
  <br>
      <span style="font-size: large;"><h5> New User?</h5> </span>
      <a style="color: cadetblue;font-size: large;font-weight: bolder;" href="./consumerSignUpPage"><h5>Register Here</h5> </a>
    <br>
      <div>
        <a class="btn btn-warning" href="./home" role="button">Home</a>
      </div>
</form>

  <script src="${js}/jquery-3.4.1.js"></script>
  <script src="${js}/bootstrap.min.js" ></script>
  <script src="${js}/consumerLogin.js" ></script>
  
 
</body>

</html>