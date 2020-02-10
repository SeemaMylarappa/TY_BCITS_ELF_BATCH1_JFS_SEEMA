<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
     <%   String errMsg=(String)request.getAttribute("errMsg"); %>
    <spring:url var="css" value="/resources/css" />
    <spring:url var="js" value="/resources/js" />
    <spring:url var="images" value="/resources/images" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>employee login</title>
    <link rel="stylesheet" href="${css}/employeelogin.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
    
</head>
<body>
<% if(errMsg != null && !errMsg.isEmpty()) { %>
  
  <h5 style="color: red;font-size: 35px; font: bold;margin-right: 50px;align:center;"><%= errMsg %></h5>
  
  <% } %>
    
     <form action="./empPage" method="post" class="container">
   <div class="col-10 col-sm-10 col-md-10 col-lg-10 col-xl-10 mt-5 mx-auto d-block bg-img">
   
   
   <div class="form-group">
    <label for="exampleInputEmail1"><h3>Employee ID</h3></label>
    <input type="tel" class="form-control" id="empId" name="empId" aria-describedby="emailHelp">
   
   
  <!--  <div>
        <br>
        <h3>Employee ID</h3>
        <pre></pre>
        <input type="tel" id="empId" name="empId" placeholder="Enter your ID Number" >

      </div> -->
       <!-- <div>
           <br>
           <h3>Employee ID</h3>
           <pre></pre>
           <input type="tel" name="empId" id="empId" placeholder="Enter your ID Number" >

       </div> -->
      

       <div class="form-group">
    <label for="exampleInputPassword1"><h3>Password</h3></label>
    <input type="password" class="form-control" id="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
    title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
  </div>
       
         <div class="form-group col-md-4">
         <br>
              <h3>Region</h3>
                <select id="inputState" class="form-control" name="region" required>
                  <option selected disabled >Choose...</option>
                  <option>Bangalore North</option>
                  <option>Bangalore South</option>
                </select>
              </div>
       
       <div>
           <br>
           <a href="./employeePage"><button type="submit" class="btn btn-primary">Login</button></a>
           


       </div>
       <br>
       
       <br>
       <div>
        <a class="btn btn-warning" href="./home" role="button">Home</a>
      </div>
   </div>
  </div>
</form>
<script src="${js}/jquery-3.4.1.js"></script>
  <script src="${js}/bootstrap.min.js" ></script>
</body>
</html>