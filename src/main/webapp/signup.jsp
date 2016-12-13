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

		<table>
			<tr>
				<td>Weight:</td>
				<td><form:input path="currentweight" /></td>
				<td>KG</td>
				
			</tr>
			<tr>
		        <td>Goal Weight:</td>
				<td><form:input path="goalweight" /></td>
				<td>KG</td>
			</tr>
			<tr>
				<td>Height:</td>
				<td><form:input path="height" /></td>
				<td>CM</td>
			</tr>
		    <tr>
				<td>Date of birth:</td>
				<td><form:input type="date" path="dateofbirth" /></td>
			</tr>
            <tr>
				<td>Goal date:</td>
				<td><form:input type="date" path="goaldate" /></td>
			</tr>

		    <tr>
				<td>Notes:</td>
				<td><form:input path="notes" /></td>

			</tr>
		</table>

	    <table>
			<tr>
				<td>Current BMI:</td>
				<td><form:label path="currentBMI" /></td>
			</tr>
			<tr>
				<td>goal BMI:</td>
				<td><form:label path="goalBMI" /></td>
			</tr>
		</table>


		<input type="submit" value="Save" />
	</form:form>


</body>
</html>