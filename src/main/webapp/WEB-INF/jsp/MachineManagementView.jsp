<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Machine Management</title>
</head>
<body>
<h1>Machine Management</h1>
<h3><a href="newMachine.html">Add New Machine</a></h3>

<c:if test="${!empty machines}">
	<table align="center" border="1">
		<tr>
			<th>Machine Code</th>
			<th>Description</th>
			<th>Hourly Rent</th>
			<th>Max Hours Per Day</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<c:forEach items="${machines}" var="machine">
			<tr>
				<td><c:out value="${machine.code}"/></td>
				<td><c:out value="${machine.description}"/></td>
				<td><c:out value="${machine.hourly_rent}"/></td>
				<td><c:out value="${machine.max_hours_per_day}"/></td>
				<td align="center"><a href="edit.html?id=${machine.id}">Edit</a> </td>
				<td align="center"><a href="delete.html?id=${machine.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>