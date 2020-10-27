<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Status Update</title>
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
<h2>Status</h2>
</nav>
<div>
<p>${message}</p>
<a href="${pageContext.request.contextPath}/managerhome">Back to Manager Home</a>
</div>
</header>
</body>
</html>