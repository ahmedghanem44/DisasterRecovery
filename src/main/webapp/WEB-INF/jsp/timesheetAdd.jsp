<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="css/index.css" rel="stylesheet">
    <script src="https://unpkg.com/react@16/umd/react.development.js" crossorigin></script>
    <script src="https://unpkg.com/react-dom@16/umd/react-dom.development.js" crossorigin></script>
	<script src="https://unpkg.com/babel-standalone@6/babel.min.js"></script>
	<script>
		var machine_options_list = ["machine1", "machine2", "machine3"];
		var labor_options_list = ["job1", "job2", "job3"];
	</script>

<title></title>
</head>
<body>


<div  id="timesheetRoot">

</div>

<script type="text/babel" src="js/Timesheet.js" crossorigin></script>
</body>
</html>