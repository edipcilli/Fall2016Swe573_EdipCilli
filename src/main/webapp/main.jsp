<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="UTF-8">
<title>Health Tracker Main Page</title>
</head>
<body>

	<h2>Welcome ${user.userName}</h2>

	<table>
		<tr>
			<td><form:form action="gotoMainPage" modelAttribute="user">
					<input type="submit" value="Home" />
				</form:form></td>

			<td><form:form action="gotoHistoryPage" modelAttribute="user">
					<input type="submit" value="History" />
				</form:form></td>

			<td><form:form action="gotoProgressPage" modelAttribute="user">
					<input type="submit" value="Progress" />
				</form:form></td>

			<td><form:form action="gotoProfilePage" modelAttribute="user">
					<input type="submit" value="Profile" />
				</form:form></td>

			<td><form:form action="logout" modelAttribute="user">
					<input type="submit" value="Logout" />
				</form:form></td>
		</tr>
	</table>

	<div style="align: center">

		<h3>TODAY</h3>
		<hr />
		<table>
			<tr>
				<td>${user.goalcl}</td>
				<td>-</td>
				<td>${user.foodcl}</td>
				<td>+</td>
				<td>${user.exercisecl}</td>
				<td>=</td>
				<td>${remaining}</td>
			</tr>
			<tr>
				<td>Goal</td>
				<td></td>
				<td>Food</td>
				<td></td>
				<td>Exercise</td>
				<td></td>
				<td>Remaining</td>
			</tr>
		</table>
		<hr />
	</div>


</body>
</html>