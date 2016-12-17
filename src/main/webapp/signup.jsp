<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html lang="en">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
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
				<td><form:input id="currentweight" path="currentweight" /></td>
				<td>KG</td>
				
			</tr>
			<tr>
		        <td>Goal Weight:</td>
				<td><form:input path="goalweight" /></td>
				<td>KG</td>
			</tr>
			<tr>
				<td>Height:</td>
				<td><form:input id="height" path="height" /></td>
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
				<td>Gender:</td>
				<td><form:select type="select" path="gender">
					<form:option value="male" label="male"/>
					<form:option value="female" label="female"/>
			</form:select>
				</td>
			</tr>


		    <tr>
				<td>Notes:</td>
				<td><form:input path="notes" /></td>

			</tr>
		</table>

	    <table>
			<tr>
				<td>Current BMI:</td>
				<td><form:input id="currentBMI" path="currentBMI" readonly="true"/></td>
			</tr>
			<tr>
				<td>goal BMI:</td>
				<td><form:input id="goalBMI" path="goalBMI" readonly="true"/></td>
			</tr>
		</table>


		<input type="submit" value="Save" />
	</form:form>

<script type="text/javascript">

function calculateCurrentBMI(){
	var currentWeight = $("#currentweight").val();
	var height = $("#height").val();
	
	$("#currentBMI").val(currentWeight/(height*height)*10000);
}

function calculateGoalBMI(){
	var goalweight = $("#goalweight").val();
	var height = $("#height").val();
	
	$("#goalBMI").val(goalweight/(height*height)*10000);
}



$(document).ready(function(){
	$("#currentweight, #height").change(function(){
			if($("#currentweight").val() > 0 && $("#height").val() > 0){
				calculateCurrentBMI();
			}
	});
	$("#height, #goalweight").change(function(){
			if($("#goalweight").val() > 0 && $("#height").val() > 0){
				calculateGoalBMI();
			}
	});
	
});
</script>

</body>
</html>