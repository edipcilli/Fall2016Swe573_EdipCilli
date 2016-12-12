<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello</title>
</head>
<body>
    
    <form:form action="loginsuccess" modelAttribute="user">
				<!-- to display error message from action method if any -->
				<form:errors />
				<br />
				<form:label path="userName">User name:</form:label>
				<form:input path="userName" />
				<br />
				<form:label path="password">Password:</form:label>
				<form:password path="password" />
				<br />
				<input type="submit" value="Login" />
	</form:form>
    
    <form:form action="gotoSignUpPage">
				<!-- to display error message from action method if any -->
				<input type="submit" value="SignUp" />
	</form:form>
    
     
</body>
</html>