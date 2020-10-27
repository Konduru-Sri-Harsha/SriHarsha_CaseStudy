<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Airport Management Home</title>
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


</style>
</head>
<body>
<header>
<nav>
<h1>Airport Management Portal</h1>
</nav>
</header>
<div>
<h3>Admin</h3>
<a href="${pageContext.request.contextPath}/adminreg"> Admin Registration</a>
<a href="${pageContext.request.contextPath}/adminlogin">Admin login</a><br>
<h3>Manager</h3>
<a href="${pageContext.request.contextPath}/managerreg">Manager Registration</a>
<a href="${pageContext.request.contextPath}/managerlogin">Manager login</a>
</div>

</body>
</html>