<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">

<body>
	<div>
		<a href="addstudent">Add a new user</a>
	</div>

	<div align="center">
		User List
		<table border="1">
			<tr>
				<th>email</th>
				<th>password</th>
			</tr>

			<c:forEach var="user" items="${userList}">
				<tr>
					<td><c:out value="${user.email}"></c:out></td>
					<td><c:out value="${user.password}"></c:out></td>
					<td><a href="edituser?userId=${user.id}">update
							me!</a></td>
					<td><a href="deleteuser?userId=${user.id}">delete
							me</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>