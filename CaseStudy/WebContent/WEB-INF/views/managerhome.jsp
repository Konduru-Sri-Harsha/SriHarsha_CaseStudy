<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Home</title>
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
	margin-left: 42%;
	border: 1px solid black;
}

a {
	text-decoration: none;
	padding: 2px;
	margin: 1px;
	border: 1px solid black;
}

.logout {
	text-decoration: none;
	padding: 2px;
	margin-left: 60%;
	border: 1px solid black;
}

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
			<h2>Hello ${managerName}</h2>
			<a class="logout"
				href="${pageContext.request.contextPath}/managerlogout">Logout</a>
		</nav>
	</header>
	<div>
		<h3>Hanger Allotment</h3>
		<a href="${pageContext.request.contextPath}/allothanger">Allot
			Hanger to Plane</a>
		<h3>Pilot Assignment</h3>
		<a href="${pageContext.request.contextPath}/pilotassign">Assign
			Pilot to Plane</a>
	</div>
</body>
</html>