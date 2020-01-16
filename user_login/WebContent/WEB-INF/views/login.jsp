<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<div align="center">
		<form:form action="saveUser" method="post" modelAttribute="user">
			<table>
				<form:hidden path="id" />

				<tr>
					<td>Email: </td>
					<td><form:input path="email" /></td>
				</tr>

				<tr>
					<td>Password: </td>
					<td><form:input path="password" /></td>
				</tr>


				<tr>
					<td colspan="2"><input type="submit" value="Add user"></td>
				</tr>
			</table>

		</form:form>
	</div>
</body>
</html>