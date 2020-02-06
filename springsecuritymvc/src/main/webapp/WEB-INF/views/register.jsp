<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<% String msg = (String) request.getAttribute("msg");
	String errMsg = (String) request.getAttribute("errMsg");%>
	<jsp:include page="index.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Security-Register</title>
</head>
<body>
<div align="center">
<% if(errMsg != null && !errMsg.isEmpty()){ %>
<h2 style="color:red;"><%=errMsg%></h2>
<% } %>
<% if(msg != null && !msg.isEmpty()){ %>
<h2 style="color:green;"><%=msg%></h2>
<% } %>
</div>
	<fieldset>
		<legend>Register</legend>
		<form action="./register" method="post">
			<table>
				<tr>
					<td>Employee ID</td>
					<td>:</td>
					<td><input type="number" name="empId" required="required"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password" required="required"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td>:</td>
					<td><input type="text" name="name" required="required"></td>
				</tr>
				<tr>
					<td>Role</td>
					<td>:</td>
					<td><input type="radio" name="role" value="ROLE_USER">User</td>
				</tr>
				<tr>
					<td></td>
					<td>:</td>
					<td><input type="radio" name="role" value="ROLE_ADMIN">Admin</td>
				</tr>
				<tr>
				<td colspan="3" align="center"><input type="submit" value="Register"></td>
				</tr>
			</table>
		</form>

	</fieldset>
</body>
</html>