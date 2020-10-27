<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hangers List</title>
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
	margin-left: 40%;
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
			<h2>List of Hangers</h2>
		</nav>
	</header>
<div>
	<p>List of Hangers</p>
	<table border="1">
	<tr><td>Name</td><td>Hanger Type</td><td>Hanger Status</td><td>Update</td>
	<c:forEach var="hanger" items="${hangers}">
	<tr><td>${hanger.hangerName}</td><td>${hanger.hangerType}</td><td>${hanger.status}</td>
	<td><a href="${pageContext.request.contextPath}/hanger_update/${hanger.hangerId}">Update</a></td></tr>
	</c:forEach>
	</table>
</div>
<a href="./adminhome">Back to Admin home page</a>
</body>
</html>