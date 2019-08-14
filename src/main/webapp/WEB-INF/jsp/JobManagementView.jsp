<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
	<div class="header">
		<h2>Disaster Recovery Application : Job Management</h2>
	</div>
	<div class="column left">
		<h3>Job Management</h3>
		<h3>Machine Management</h3>
		<h3>TimeSheet Management</h3>
	</div>
	<div class="column right">
	<h2 class="title"><u> Job Management</u> </h2>
	<c:if test="${!empty jobs}">
		<table>
			<col width="200">
			<col width="400">
			<col width="200">
			<col width="400">
			<col width="100">
			<col width="100">
			<tr class="select" height="40" >
				<th>Job Code</th>
				<th>Description</th>
				<th>Hourly Rate</th>
				<th>Max Hours Per Day</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>

			<c:forEach items="${jobs}" var="job">
				<tr height="40" bgcolor: #f1f1f1>
					<td><c:out value="${job.jobCode}" /></td>
					<td><c:out value="${job.jobDescription}" /></td>
					<td><c:out value="${job.jobHourlyRate}" /></td>
					<td><c:out value="${job.jobmaxHours}" /></td>
					<td align="center"><a href="edit.html?id=${job.jobId}">Edit</a>
					</td>
					<td align="center"><a href="delete.html?id=${job.jobId}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>
</body>
</html>