<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/index.css" rel="stylesheet">

<script type="text/javascript" src="js/tabselector.js"></script>

<title></title>
</head>

<body>
	<div class="header">
		<h1 align="center">Disaster Recovery Application</h1>
		<p align="right">Hello "${uname}" <br><a href="logout.html">Logout</a></p>
	</div>
	<div id="root">
		<div id="top_container"></div>
		<div id="bottom_container">

			<div id="tabcontainer">
				<div class="tab">
					<ul id="tabbar">
						<li>
							<a href="admin"><button class="tablinks centerhorizontal" onclick="openTab('jobs')">Job
								Management</button></a>
						</li>
						<br>
						<br>
						<br>
						<li>
							<a href="admin"><button class="tablinks centerhorizontal" onclick="openTab('machines')">Machine
								Management</button></a>
						</li>
						<br>
						<br>
						<br>
						<li>
							<a href="admin"><button class="tablinks centerhorizontal"
								onclick="openTab('timesheet_table')">Timesheet
								List</button></a>
						</li>
					</ul>
				</div>
			</div>

			<div class="column right">
		<h2 class="title">
			<u> Add New Machine</u>
		</h2>
		<br> <br>
		<form:form method="POST" action="saveMachine">
			<table>
				<col width="200">
				<col width="400">
				
				<tr height="40">
					<td class="select"><form:label path="id">Machine id:</form:label></td>
					<td><form:input path="id" height="40"
							value="${machine.id}" readonly="true"/></td>
				</tr>

				<tr height="40">
					<td class="select"><form:label path="code">Machine Code:</form:label></td>
					<td><form:input path="code" height="40"
							value="${machine.code}" placeholder="Enter Machine Code"
							required="required" /></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr height="40">
					<td class="select"><form:label path="description">Description:</form:label></td>
					<td><form:input path="description" height="40"
							value="${machine.description}" placeholder="Enter Description"
							required="required" /></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr height="40">
					<td class="select"><form:label path="hourly_rent">Hourly Rent:</form:label></td>
					<td><form:input path="hourly_rent" height="40"
							value="${machine.hourly_rent}" placeholder="Enter Hourly Rent"
							required="required" /></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr height="40">
					<td class="select"><form:label path="max_hours_per_day">Max Hours Per Day:</form:label></td>
					<td><form:input path="max_hours_per_day" height="40"
							value="${machine.max_hours_per_day}"
							placeholder="Enter Max Hours per Day" required="required" /></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr height="40">
					<td colspan="2"><input type="submit" value="Save" height="40" /></td>
				</tr>
			</table>
		</form:form>

	</div>
				</div>

			</div>
		</div>
	
	
<script> 
	if("${tab}")
		openTab("${tab}");
</script>	
</body>
</html>