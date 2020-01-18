<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>updating a user</title>
</head>
<body>
	<div align="center">
		<form:form action="updateUser" method="post" 
			modelAttribute="editeduser">
			<table>
					<form:hidden path="id" />
				
				<tr>
					<td>Email</td>
					<td><form:input path="email" /></td>
				</tr>

				<tr>
					<td>Password</td>
					<td><form:input path="password" /></td>
				</tr>

				<tr>
					<td colspan="3"><input type="submit" value="update user information"></td>
				</tr>
			</table>

		</form:form>
	</div>
</body>
</html>