<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
<style type="text/css">
body {
	background-color: silver;
}

header nav {
	text-align: center;
	background-color: teal;
	padding-top: 2px;
	font-family: sans-serif;
	font-size: large;
}

div {
	display: inline-block;
	text-align: center;
	background-color: white;
	padding: 20px;
	margin-top: 30px;
	margin-left: 45%;
	border: 1px solid black;
}

a {
	text-decoration: none;
	padding: 3px;
	margin: 1px;
	border: 1px solid black;
}

.logout {
	text-decoration: none;
	padding: 2px;
	margin-left: 60%;
	border: 1px solid black;
}

p {
	text-align: center;
	font-weight: bold;
}

header h2 {
	display: inline-block;
}
</style>
</head>
<body>
	<header>
		<nav>
			<h2>Hello ${adminName}</h2>
			<a class="logout"
				href="${pageContext.request.contextPath}/adminlogout">Logout</a>

		</nav>
	</header>
	<div>
		<h3>Approve Managers</h3>
		<a href="${pageContext.request.contextPath}/managerlist">ManagersList</a>
		<h3>Planes</h3>
		<a href="${pageContext.request.contextPath}/addplane">Add Plane</a> <a
			href="${pageContext.request.contextPath}/planelist">View Planes</a> <br>
		<h3>Pilots</h3>
		<a href="${pageContext.request.contextPath}/addpilot">Add Pilot</a> <a
			href="${pageContext.request.contextPath}/pilotlist">View Pilots</a><br>
		<h3>Hanagers</h3>
		<a href="${pageContext.request.contextPath}/addhanger">Add hanger</a>
		<a href="${pageContext.request.contextPath}/hangerlist">View
			hangers</a><br>

	</div>
</body>
</html>
