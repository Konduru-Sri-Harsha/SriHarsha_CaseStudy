<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Plane</title>
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
p {
	text-align: center;
	font-weight: bold;
}
</style>
</head>
<body>
<header>
		<nav>
			<h2>Update Planes</h2>
		</nav>
	</header>
<div>
	<form action="${pageContext.request.contextPath}/updateplane_process?id=${plane.planeId}"
		method="post">
		<table>
		
			<tr>
				<td>Plane Name</td>
				<td><input type="text" name="planename" value="${plane.planeName}"></td>
			</tr>
			<tr>
				<td>From</td>
				<td><select name="from">
			<option value="Chennai">Chennai</option>
			<option value="Hyderabad">Hyderabad</option>
			<option value="Mumbai">Mumbai</option>
			<option value="Banglore">Banglore</option>
			<option value="Tirupathi">Tirupathi</option>
				</select></td></tr>
			<tr>
				<td>To</td>
				<td><select name="to">
			<option value="Chennai">Chennai</option>
			<option value="Hyderabad">Hyderabad</option>
			<option value="Mumbai">Mumbai</option>
			<option value="Banglore">Banglore</option>
			<option value="Tirupathi">Tirupathi</option>
				</select></td></tr>
		</table>
		<button type="submit">Submit</button><br>
	</form>
	</div>
	<a href="${pageContext.request.contextPath}/adminhome">Back to Admin home page</a>
	<p>${message}</p>
</body>
</html>