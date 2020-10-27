<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Managers List</title>
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

p {
	text-align: center;
	font-weight: bold;
}
</style>
</head>
<body>
	<header>
		<nav>
			<h2>List of Managers</h2>
		</nav>
	</header>
	<div>
	<h4>List of managers</h4>
		<table border="1">
			<tr>
				<td>Name</td>
				<td>Status</td>
				<td>Action</td>
			</tr>
			<c:forEach var="manager" items="${list}">

				<tr>
					<td>${manager.firstName}</td>
					<td>${manager.status}</td>
					<td><a
						href="${pageContext.request.contextPath}/approve/${manager.managerId}">Approve</a><br>
					<br> <a
						href="${pageContext.request.contextPath}/delete/${manager.managerId}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<a href="./adminhome">Back to Admin home page</a>
</body>
</html>