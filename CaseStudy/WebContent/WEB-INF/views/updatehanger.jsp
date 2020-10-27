<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Hanger</title>
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
			<h2>Update Hanger</h2>
		</nav>
	</header>
	<div>
		<form
			action="${pageContext.request.contextPath}/updatehanger_process?id=${hanger.hangerId}"
			method="post">
			<table>
				<tr>
					<td>Hanger Name</td>
					<td><input type="text" name="hangername" value="${hanger.hangerName}" /></td>
				</tr>
				<tr>
					<td>Type</td>
					<td><select name="type">
							<option value="Private">Private</option>
							<option value="Public">Public</option>
					</select></td>
				</tr>
			</table>
			<button type="submit">Submit</button>
			<br>
		</form>
	</div>
	<a href="${pageContext.request.contextPath}/adminhome">Back to
		Admin home page</a>
	<p>${message}</p>
</body>
</html>