<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <title>sign up</title>
    <link rel="stylesheet" href="${css}/consumersignin.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
</head>

<body>
    <form action="./signUPage" method="post" class="container">
        <div id="design"  class="col-10 col-sm-10 col-md-10 col-lg-10 col-xl-10 mt-5 mx-auto d-block bg-img">
           
            <br>


            <div class="form-group">
                <h4>Personal Details</h4><br>
                <label for="exampleFormControlInput1">&nbsp;&nbsp;First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName"
                    placeholder="Enter your First Name" required>
            </div>

            <div class="form-group">
                <label  for="exampleFormControlInput1">&nbsp;&nbsp;Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName"
                    placeholder="Enter your Last Name" required>
            </div>

            <div class="form-group">
                <label for="exampleFormControlInput1">&nbsp;&nbsp;Email address</label>
                <input type="email" class="form-control" id="emailId" name="emailId" placeholder="name@example.com" required>
            </div>

            <div class="form-group">
                <label for="exampleFormControlInput1">&nbsp;&nbsp;Mobile Number</label>
                <input type="tel" class="form-control" id="mobileNo" name="mobileNo"
                    placeholder="Enter 10 digit Number" required>
            </div>
            
             <div class="form-group">
                <label for="exampleFormControlInput1">&nbsp;&nbsp;Password</label>
                <input type="password" class="form-control" id="password" name="password"
                pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required> 
            </div>
            
             <div class="form-group">
                <label for="exampleFormControlInput1">&nbsp;&nbsp;Confirm password</label>
                <input type="password" class="form-control" id="confirmpassword" name="confirmpassword"
                 pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>  
            </div>

            <div>
                <br>
                <h4>Address Details</h4><br>
                <label for="exampleFormControlInput1">&nbsp;&nbsp;Address Line1</label>
                <input type="tel" class="form-control" id="addressLine1" name="addressLine1" required>

            </div>

            <div>
                <br>
                <label for="exampleFormControlInput1">&nbsp;&nbsp;Address Line2</label>
                <input type="tel" class="form-control" id="addressLine2" name="addressLine2" required>
                <br>
            </div>

           

            <div class="form-group col-md-4">
                <label for="inputState">Region</label>
                <select id="inputState" class="form-control" name="region" required>
                  <option selected disabled >Choose...</option>
                  <option>Bangalore North</option>
                  <option>Bangalore South</option>
                </select>
              </div>
              
              <div class="form-group col-md-4">
                <label for="inputState">Type of Consumers</label>
                <select id="inputState" class="form-control" name="typeOfConsumer" required>
                  <option selected disabled >Choose...</option>
                  <option>Residential Consumer</option>
                  <option>Commercial Consumer</option>
                  <option>Industrial Consumer</option>
                </select>
              </div>

            <!-- <div>
                <br>
                <label for="exampleFormControlInput1" style="color: white;">&nbsp;&nbsp;Pincode</label>
                <input type="number" class="form-control" id="rrNumber" name="rrNumber">
            </div> -->



            <div>
                <br>
                <h4>Account Details</h4><br>
                <label for="exampleFormControlInput1">&nbsp;&nbsp;Revenue Register Number/RR Number</label>
                <input type="tel" class="form-control" id="rrNumber" name="rrNumber"
                    placeholder="Enter Alpha Numeric Number" required><br>

            </div>
           
            <div>
                <br>
            <label for="exampleFormControlInput1">&nbsp;&nbsp;Account ID</label>
            <input type="tel" class="form-control" id="accountId" name="accountId" placeholder="Enter 10 Numbers" required>

            </div>
             <br>
            <button type="submit" class="btn btn-primary mb-2">Submit</button>

        </div>


    </form>

     <script src="${js}/jquery-3.4.1.js"></script>
  <script src="${js}/bootstrap.min.js"></script>
</body>

</html>