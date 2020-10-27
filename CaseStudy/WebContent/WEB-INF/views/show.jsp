<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Info Page</title>
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
	margin-left: 43%;
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
<p>${message}</p>
<a href="${pageContext.request.contextPath}/managerlist">Show List</a>
</div>
</body>
</html>