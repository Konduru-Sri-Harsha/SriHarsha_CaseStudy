<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Registration</title>
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
<h2>Manager Registration</h2>
</nav>
</header>
<div>
		<form:form action="${pageContext.request.contextPath}/managerprocess"
			method="post" modelAttribute="manager">
				<p style="color: red;">${error}</p>
			<table>
			
				<tr>
					<td>First Name/User Name</td>
					<td><form:input type="text" path="firstName"/></td>
					<td><form:errors path="firstName" cssClass="errors"></form:errors></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input type="text" path="lastName"/></td>
					<td><form:errors path="lastName" cssClass="errors"></form:errors></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><form:input type="text" path="age"/></td>
					<td><form:errors path="age" cssClass="errors"></form:errors></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><form:select path="gender">
					<option value="Male">Male<option>
					<option value="Female">Female<option>
					</form:select></td>
					<td><form:errors path="gender" cssClass="errors"></form:errors></td>
				</tr>
				<tr>
					<td>Contact Number</td>
					<td><form:input type="text" path="contactNumber"/></td>
					<td><form:errors path="contactNumber" cssClass="errors"></form:errors></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:input type="text" path="password"/></td>
					<td><form:errors path="password" cssClass="errors"></form:errors></td>
				</tr>
			</table>
			<button type="submit">Submit</button>
		</form:form>
	</div>
	<a href="./">Back to Home page</a>
	<p>${message}</p>
</body>
</html>