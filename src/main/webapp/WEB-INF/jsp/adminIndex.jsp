<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/index.css" rel="stylesheet">

<script type="text/javascript" src="js/tabselector.js"></script>

<title></title>
</head>

<body bgcolor="black">
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
							<button class="tablinks centerhorizontal" onclick="openTab('jobs')">Job
								Management</button>
						</li>
						<br>
						<br>
						<br>
						<li>
							<button class="tablinks centerhorizontal" onclick="openTab('machines')">Machine
								Management</button>
						</li>
						<br>
						<br>
						<br>
						<li>
							<button class="tablinks centerhorizontal"
								onclick="openTab('timesheet_table')">Timesheet
								List</button>
						</li>
					</ul>
				</div>
			</div>

			<div id="contentcontainer">

				<div id="jobs" class="column right tabcontent">
					
					<h2 class="title">
						<u> Job Management</u>
					</h2>
					<h3 align="right">
						<a href="newjob.html">Add New Job</a>
					</h3>

					<c:if test="${!empty jobs}">
						<table>
							<col width="200">
							<col width="400">
							<col width="200">
							<col width="400">
							<col width="100">
							<col width="100">
							<tr class="select" height="40" >
							
								<th text="white">Job Code</th>
								<th>Description</th>
								<th>Hourly Rate</th>
								<th>Max Hours Per Day</th>
								<th>Edit</th>
								<th>Delete</th></div>
							</tr>

							<c:forEach items="${jobs}" var="job">
								<tr align="center" height="40" bgcolor=#f1f1f1>
									<td><c:out value="${job.jobCode}" /></td>
									<td><c:out value="${job.jobDescription}" /></td>
									<td><c:out value="${job.jobHourlyRate}" /></td>
									<td><c:out value="${job.jobmaxHours}" /></td>
									<td><a href="editjob.html?id=${job.jobId}">Edit</a></td>
									<td><a href="deletejob.html?id=${job.jobId}">Delete</a></td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
				</div>


				<div id="machines" class="column right tabcontent">

					<h2 class="title">
						<u> Machine Management</u>
					</h2>
					<h3 align="right">
						<a href="newmachine.html">Add New Machine</a>
					</h3>

					<c:if test="${!empty machines}">
						<table>
							<col width="200">
							<col width="400">
							<col width="200">
							<col width="400">
							<col width="100">
							<col width="100">
							<tr class="select" height="40">
								<th>Machine Code</th>
								<th>Description</th>
								<th>Hourly Rent</th>
								<th>Max Hours Per Day</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>
							<c:forEach items="${machines}" var="machine">
								<tr align="center" height="40" bgcolor=#f1f1f1>
									<td><c:out value="${machine.code}" /></td>
									<td><c:out value="${machine.description}" /></td>
									<td><c:out value="${machine.hourly_rent}" /></td>
									<td><c:out value="${machine.max_hours_per_day}" /></td>
									<td><a href="editmachine.html?id=${machine.id}">Edit</a></td>
									<td><a href="deletemachine.html?id=${machine.id}">Delete</a></td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
				</div>
			


				<div id="timesheet_table" class="column right tabcontent">
					<h2 class="title">
						<u> TimeSheet Management</u>
					</h2>
					
					<c:if test="${!empty timesheets}">
						<table>
							<col width="200">
							<col width="400">
							<col width="200">
							<col width="400">
							<col width="100">
							<col width="100">
							<tr class="select" height="40">
								<th>Site Code</th>
								<th>Contractor Name</th>
								<th>Total Hours</th>
								<th>Total Amount</th>
								<th>Review</th>
							</tr>

							<c:forEach items="${timesheets}" var="timesheet">
								<tr align="center" height="40" bgcolor=#f1f1f1>
									<td><c:out value="${timesheet.site_code}" /></td>
									<td><c:out value="${timesheet.contractor_name}" /></td>
									<td><c:out value="${timesheet.totalHours}" /></td>
									<td><c:out value="${timesheet.totalAmount}" /></td>
									<td align="center"><c:choose>
											<c:when test="${timesheet.isOpen == true}">
												<a href="timesheetReview/${timesheet.id}">Review</a>
											</c:when>
											<c:otherwise>Finalized</c:otherwise>
										</c:choose></td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
				</div>
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