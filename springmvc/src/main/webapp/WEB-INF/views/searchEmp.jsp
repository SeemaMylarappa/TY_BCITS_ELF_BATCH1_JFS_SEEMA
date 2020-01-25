<%@page import="com.bcits.springmvc.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% EmployeeInfoBean employeeInfoBean=(EmployeeInfoBean) request.getAttribute("employeeInfoBean");
    String errMsg=(String) request.getAttribute("errMsg");%>
    <jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <fieldset>
     <legend>Search Employee</legend>
     <!-- <form action="./findEmployee">- -->
        <form action="./search">
     <label>Employee ID: </label>
      <input type="text" name="empId" required>
      &nbsp; &nbsp; &nbsp; &nbsp;
     <input type="submit" value="Search">
    </form>
     </fieldset>
</body>
</html>
<% if(errMsg != null && !errMsg.isEmpty()) { %>
 <h3 style="color:red;"></h3>
 <% } %>
 <% if(employeeInfoBean != null){ %>
 <div align="center">
 <table border="1" style="width: 70%">
 <tr style="background: navy; color: white;">
 <th>Employee ID</th>
 <th>Name</th>
 <th>Designation</th>
 <th>DOB</th>
 <th>DOJ</th>
 <th>Mobile</th>
 <th>DeptID</th>
 
 </tr>
 <tr>
 <td><%= employeeInfoBean.getEmpId() %></td>
 <td><%= employeeInfoBean.getEName() %></td>
 <td><%= employeeInfoBean.getDesignation() %></td>
 <td><%= employeeInfoBean.getDateOfJoin() %></td>
 <td><%= employeeInfoBean.getDateOfBirth() %></td>
 <td><%= employeeInfoBean.getMobile() %></td>
 <td><%= employeeInfoBean.getDepartmentId() %></td>
 </tr>
 </table>
 </div>
 <% } %>
<jsp:include page="footer.jsp" />