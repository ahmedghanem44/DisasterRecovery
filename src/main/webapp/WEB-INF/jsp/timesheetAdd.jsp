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
	<script type="text/javascript" src="js/tabselector.js"></script>

<title></title>
</head>
<body>

<body>
<div id="root">
	<div id="top_container">
	</div>
	<div id="bottom_container">
		<div id="tabcontainer">
			<div class="tab">
				<ul id="tabbar">
					<li>
						<button class="tablinks" onclick="openTab(event, 'Tab1')">tab1</button>
					</li>
					<li>
						<button class="tablinks" onclick="openTab(event, 'timesheet_tab')">Timesheet</button>
					</li>
				</ul>
			</div>
		</div>

		<!-- Tab content -->
		<div id="contentcontainer">
		
		
		
			<div id="Tab1" class="tabcontent">
				<div>
					<div>
						<p>Hi</p>
					</div>
				</div>
			</div>




			<div id="timesheet_tab" class="tabcontent">
				<div id="timesheetRoot"></div>
			</div>
			
			
			
		</div>
	</div>
</div>


<script type="text/babel" src="js/Timesheet.js" crossorigin></script>
</body>
</html>