<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<style type="text/css">
body{
background-color:silver;
}
header nav{
text-align: center;
background-color: teal;
padding-top:2px;
font-family: sans-serif;
font-size: large;
}
div{
display: inline-block;
text-align: center;
background-color: white;
padding: 20px;
margin-top:30px;
margin-left: 39.5%;
border: 1px solid black;
}
a {
text-decoration: none;
padding: 2px;
margin:1px;
border: 1px solid black;
}

p{
text-align: center;
font-weight: bold;
}
</style>
</head>
<body>
<header>
<nav>
<h2>Admin Login</h2>
</nav>
</header>
<div>
	<form action="${pageContext.request.contextPath}/adminauthenticate" method="post">
	<table>
	<tr><td>User Name</td><td><input type="text" name="firstname"></td></tr>
	<tr><td>Password</td><td><input type="password" name="password"></td></tr>
	</table>
	<button type="submit">Login</button><br>
	</form>
	</div>
	<a href="./">Back to Home page</a>
	<p>${message}</p>
</body>
</html>