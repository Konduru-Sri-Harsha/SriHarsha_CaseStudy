<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Pilot</title>
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

#pilot {
	display: inline-block;
	text-align: center;
	background-color: white;
	padding: 20px;
	margin-top: 30px;
	margin-left: 10%;
	border: 1px solid black;
}
#plane {
	display: inline-block;
	text-align: center;
	background-color: white;
	padding: 20px;
	margin-top: 30px;
	margin-left: 20%;
	border: 1px solid black;
}
#assign {
	display: inline-block;
	text-align: center;
	background-color: white;
	padding: 20px;
	margin-top: 30px;
	margin-left: 38%;
	border: 1px solid black;
}

a {
	text-align:center;
	text-decoration: none;
	padding: 2px;
	margin: 1px;
	border: 1px solid black;
}

p {
	text-align: center;
	font-weight: bold;
}
</style>
</head>
<body>
<header>
		<nav>
			<h2>Assign Pilot</h2>
		</nav>
	</header>
	<div id="plane">
	<p>List of Planes Not assinged</p>
	<table border="1">
	<tr><td>Plane ID</td><td>Name</td><td>From</td><td>To</td>
	<c:forEach var="plane" items="${planes}">
	<tr><td>${plane.planeId}</td><td>${plane.planeName}</td><td>${plane.from}</td><td>${plane.to}</td></tr>
	</c:forEach>
	</table>
	</div>
	<div id="pilot">
	<p>List of Pilots not assigned</p>
	<table border="1">
	<tr><td>Pilot ID</td><td>Name</td><td>Gender</td><td>Status</td>
	<c:forEach var="pilot" items="${pilots}">
	<tr><td>${pilot.pilotId}</td><td>${pilot.pilotName}</td><td>${pilot.gender}</td><td>${pilot.status}</td></tr>
	</c:forEach>
	</table>
	</div>
	<div id="assign">
	<p>Enter PlaneId and HangerId which are to be alloted</p>
<form action="${pageContext.request.contextPath}/assign_pilotprocess">
<table>
<tr><td>PlaneID</td>
<td><input type="number" name="planeId"></td></tr>
<tr><td>PilotID</td>
<td><input type="number" name="pilotId"></td></tr>
</table>
<button type="submit">Assign</button><br>
</form>
</div>
<a href="./managerhome">Back to Manager home page</a>
	
	

</body>
</html>