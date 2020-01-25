<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<% String errMsg= (String) request.getAttribute("errMsg"); %>
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

	<fieldset>
		<legend>Employee Login</legend>
		<form action="./login" method="post">
			<table>
				<tr>
					<td>Employee ID</td>
					<td>:</td>
					<td><input type="number" name="empId" required></td>

				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password" required></td>

				</tr>
				<tr>
					<td colspan="3" align="center"><br> <input type="submit"
						value="Login"></td>

				</tr>


			</table>


		</form>

	</fieldset>
</body>
</html>
<br><br>
<jsp:include page="footer.jsp" />