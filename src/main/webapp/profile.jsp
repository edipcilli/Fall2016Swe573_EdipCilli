<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="UTF-8">
<title>Profile</title>
</head>
<body>
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

	<h2>Profile</h2>

</body>
</html>