<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.HashMap"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="UTF-8">
<title>Health Tracker History</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>

	<h2>History</h2>

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
		<hr />
		<table>
			<tr>
				<td id="dailycalory">${user.dailycalory}</td>
				<td>-</td>
				<td id="foodcl">${userinfo.foodcl}</td>
				<td>+</td>
				<td id="exercisecl">${userinfo.exercisecl}</td>
				<td>=</td>
				<td id="remaining">${userinfo.remainingcl}</td>
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

	<div style="align: center">

		<h3>FOODS</h3>
		<hr />
		<table>
			<thead>
				<th>Name</th>
				<th>Cal</th>
			</thead>
			<tbody id="historyFood">





			</tbody>
		</table>
		<hr />
	</div>

	<div style="align: center">

		<h3>EXERCISES</h3>
		<hr />

		<hr />
	</div>

	<div id="foodHistInfo" style="display: none;">
		${userinfHist.ndbno}</div>

</body>

<script type="text/javascript">

function fillFoodHistory(ndbno){
	$.ajax({
				type : "GET",
				dataType : "json",
				url : "getFoodNutritions",
				data : {
					data : ndbno,
				},
				success : function(output) {
						$("#historyFood").append("<tr>");
						$("#historyFood").append("<td> <a href=\"foodInfo?ndbno="+ndbno+"&edit=false\">" + output.report.food.name + "</a></td>");
						for(var i = 0; i < output.report.food.nutrients.length; i++){
							if(output.report.food.nutrients[i].name = "Energy"){
								$("#historyFood").append("<td><tr><td> " + output.report.food.nutrients[i].value + "</a></td>" );
								$("#historyFood").append("</tr>");
								break;
							}
						}
						
					
				}
			});
}
function addFoodHistory(){
	var foodHist = $("#foodHistInfo").html();
	var arr = new Array();
	if(foodHist.indexOf(",") != -1 && foodHist.length === 8)
	{
		arr.push(foodHist);
	}
	else if(foodHist.indexOf(",") != -1){
		var indexOfComma;
		var subString;
		while(foodHist.length != 0){
			indexOfComma = foodHist.indexOf(",");
			subString = foodHist.substring(0,indexOfComma);
			subString = subString.replace(",","");
			arr.push(subString);
			foodHist = foodHist.substring(indexOfComma+1, foodHist.length);
			if(foodHist.length != 0 && foodHist.indexOf(",") == -1){
				foodHist = foodHist.replace(",","");
				subString = subString.replace(" ","");
				arr.push(foodHist);
				break;
			}
		}
	}
	for(var i = 0; i < arr.length; i++){
		arr[i] = arr[i].replace(/\s/g, '');
		fillFoodHistory(arr[i]);
	}

}

$(document).ready(function(){

	addFoodHistory();
		var dailycalory = Number($("#dailycalory").html());
		var foodcl = Number($("#foodcl").html());
		var exercisecl = Number($("#exercisecl").html());
		var remaining = Number($("#remaining").html(dailycalory - foodcl + exercisecl));
	
});



</script>
</html>