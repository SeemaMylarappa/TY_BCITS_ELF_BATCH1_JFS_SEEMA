<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% String errMsg= (String) request.getAttribute("errMsg");
    String msg=(String)request.getAttribute("msg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if(errMsg != null && !errMsg.isEmpty()){ %>
<h2 style="color:red;"><%=errMsg%></h2>
<% } %>
<% if(msg != null && !msg.isEmpty()){ %>
<h2 style="color:green;"><%=msg%></h2>
<% } %>

	<fieldset>
		<legend>Employee Update</legend>
		<form action="./update" method="post">
			<table>
				<tr>
					<td>Employee ID</td>
					<td>:</td>
					<td><input type="number" name="empId" required></td>

				</tr>
				<tr>
					<td>Employee Name</td>
					<td>:</td>
					<td><input type="text" name="eName" required></td>

				</tr>
				<tr>
					<td>Employee Designation</td>
					<td>:</td>
					<td><input type="text" name="designation" required></td>

				</tr>
				<tr>
					<td>Employee ManagerID</td>
					<td>:</td>
					<td><input type="number" name="managerId" required></td>

				</tr>
				<tr>
					<td>Employee DateOfJoin</td>
					<td>:</td>
					<td><input type="date" name="dateOfJoin" required></td>

				</tr>
				<tr>
					<td>Employee DepartmentID</td>
					<td>:</td>
					<td><input type="number" name="departmentId" required></td>

				</tr>
				<tr>
					<td>Employee DOB</td>
					<td>:</td>
					<td><input type="date" name="dateOfBirth" required></td>

				</tr>
				<tr>
					<td>Employee salary</td>
					<td>:</td>
					<td><input type="number" name="salary" required></td>

				</tr>
				<tr>
					<td>Employee Mobile</td>
					<td>:</td>
					<td><input type="number" name="mobile" required></td>

				</tr>
				<tr>
					<td>Employee MailID</td>
					<td>:</td>
					<td><input type="text" name="officialMailid" required></td>

				</tr>
				<tr>
					<td>Employee password</td>
					<td>:</td>
					<td><input type="password" name="password" required></td>

				</tr>
				<tr>
					<td colspan="3" align="center"><br> <input type="submit"
						value="Update"></td>

				</tr>


			</table>


		</form>

	</fieldset>
</body>
</html>