<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>test</title>
</head>
<body>
	<div align="center">
		<table>
			<tr>
				<th>email</th>
				<th>password</th>
			</tr>

			<c:forEach var="user" items="${userList}">
				<tr>
					<td>"${user.email}"</td>
					<td>"${user.password}"</td>
			</c:forEach>

		</table>


	</div>

</body>
</html>