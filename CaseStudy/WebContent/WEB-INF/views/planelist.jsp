<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Plane List</title>
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
	margin-left: 37%;
	border: 1px solid black;
}

a {
	text-decoration: none;
	padding: 2px;
	margin: 1px;
	border: 1px solid black;
}

#update{
text-decoration: none;
	padding: 2px;
	margin: 1px;
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
			<h2>List of Planes</h2>
		</nav>
	</header>
	<div>
	<p>List of Planes</p>
	<table border="1">
	<tr><td>Name</td><td>From</td><td>To</td><td>Hangar Status</td><td>Update</td>
	<c:forEach var="plane" items="${planes}">
	<tr><td>${plane.planeName}</td><td>${plane.from}</td><td>${plane.to}</td><td>${plane.status}</td>
	<td><a href="${pageContext.request.contextPath}/plane_update/${plane.planeId}">Update</a></td>
	</tr>	
	</c:forEach>
	</table>
</div>
<a href="./adminhome">Back to Admin home page</a>
</body>
</html>