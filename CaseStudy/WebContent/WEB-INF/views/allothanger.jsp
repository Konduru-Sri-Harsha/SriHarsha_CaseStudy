<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Allot Hangers</title>
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

#hangers {
	display: inline-block;
	text-align: center;
	background-color: white;
	padding: 20px;
	margin-top: 30px;
	margin-left: 10%;
	border: 1px solid black;
}
#planes {
	display: inline-block;
	text-align: center;
	background-color: white;
	padding: 20px;
	margin-top: 30px;
	margin-left: 20%;
	border: 1px solid black;
}
#allot {
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
			<h2>Allot Hanger</h2>
		</nav>
	</header>
<div id="hangers">
<p>List of Hangers available</p>
	<table border="1">
	<tr><td>Hanger ID</td><td>Name</td><td>Hanger Type</td><td>Hanger Status</td>
	<c:forEach var="hanger" items="${hangers}">
	<tr><td>${hanger.hangerId}</td><td>${hanger.hangerName}</td><td>${hanger.hangerType}</td><td>${hanger.status}</td></tr>
	</c:forEach>
	</table>
</div>
<div id="planes">
<p>List of Planes waiting</p>
	<table border="1">
	<tr><td>Plane ID</td><td>Name</td><td>From</td><td>To</td><td>Hanger Status</td>
	<c:forEach var="plane" items="${planes}">
	<tr><td>${plane.planeId}</td><td>${plane.planeName}</td><td>${plane.from}</td><td>${plane.to}</td><td>${plane.status}</td></tr>
	</c:forEach>
	</table>
</div>
<div id="allot">
<p>Enter PlaneId and HangerId which are to be alloted</p>
<form action="${pageContext.request.contextPath}/allot_hangerprocess">
<table>
<tr><td>HangerID</td>
<td><input type="number" name="hangerId"></td></tr>
<tr><td>PlaneID</td>
<td><input type="number" name="planeId"></td></tr>
</table>
<button type="submit">Allot</button><br>
</form>
</div>
<a href="./managerhome">Back to Manager home page</a>

</body>
</html>