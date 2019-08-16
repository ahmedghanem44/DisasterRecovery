<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/index.css">
<title>Login Page</title>
</head>
<body>
	<div class="header">
		<h2 align="center">Disaster Recovery Application Training Project</h2>
		
	</div>
	<div class="column left">
		<h3>Login</h3>
	</div>
	<div class="column right">
		<h2><u>Project presented by:</u></h2>
		<h3>&nbsp&nbsp&nbsp1. Daniel Beiniasz	<br><br>
			&nbsp&nbsp&nbsp2. Ahmed Ghanem	<br><br>
			&nbsp&nbsp&nbsp3. Jerry Morris</h3>
			<h4><u> The project has been created using :</u> <br><br>
				 &nbsp&nbsp&nbsp- Spring Boot / Spring MVC / JPA & Hibernate  <br>
				 &nbsp&nbsp&nbsp- JSP / CSS / JavaScript</h4>
	 </div>
	<div class="column right">
		<h1 class="title">
			<u> Admin/User Login</u><br>
		</h1>
		<br><br>
	<form action="login" method="post">
		<table style="with: 50%">

			<tr>
				<td>UserName:&nbsp&nbsp&nbsp</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td>Password:&nbsp&nbsp&nbsp</td>
				<td><input type="password" name="password" /></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="Login" />
	</form>
	</div>
</body>

<!-- <a href="jobList.html">job list</a>

<footer>Goes with java loginController</footer> -->
</html>