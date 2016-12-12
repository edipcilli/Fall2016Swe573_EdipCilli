<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="UTF-8">
<title>Health Tracker Sign Up Page</title>
</head>
<body>

	<h2>Health Tracker Sign Up Page</h2>
	<form:form action="SignUpSuccess" modelAttribute="user">
		<form:errors />

		<table>
			<tr>
				<td>User name:</td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password" /></td>
			</tr>
		</table>


		<input type="submit" value="Save" />
	</form:form>


</body>
</html>