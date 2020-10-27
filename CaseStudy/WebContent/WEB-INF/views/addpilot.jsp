<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Pilot</title>
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
.errors{
color: red;
}
</style>
</head>
<body>
<header>
		<nav>
			<h2>Add Pilots</h2>
		</nav>
	</header>
<div>
<form:form action="${pageContext.request.contextPath}/pilotprocess"
		method="post" modelAttribute="pilot" >
		<p style="color: red;">${error}</p>
		<table>
			<tr>
				<td>Pilot Name</td>
				<td><form:input type="text" path="pilotName"/></td>
				<td><form:errors path="pilotName" cssClass="errors"></form:errors></td>
			</tr>
			<tr>
					<td>Gender</td>
					<td><form:select path="gender">
					<option value="Male">Male<option>
					<option value="Female">Female<option>
					</form:select></td>
					<td><form:errors path="gender" cssClass="errors"></form:errors></td>
				</tr>
			</table>
			<button type="submit">Submit</button><br>
		</form:form>
</div>
<a href="./adminhome">Back to Admin home page</a>
	<p>${message}</p>
</body>
</html>