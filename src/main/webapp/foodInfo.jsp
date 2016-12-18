<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<% String ndbno = request.getParameter("ndbno"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>Health Tracker Add Food Page</title>
</head>
<body>

	<h1 id="foodInfo"></h1>
	<h2>Nutritions</h2>
	<table style="border:1px solid black">
		<thead>
			<tr>
				<th>Name</th>
				<th>Group</th>
				<th>Unit</th>
				<th>Value</th>
			</tr>
		<thead>	
		<tbody id="nutrientsInfo" >

	
		</tbody>
	</table>
	
	<a id="addFoodLink" style="font-size:1.2em; font-weight:bold;" href="addFoodToDB?ndbno=<%=ndbno%>">Add Food</a>
	

	<script type="text/javascript">
		$(document).ready(function() {
			var ndbno = <%= ndbno %>
			$("#foodInfo").html(" ");
			$.ajax({
				type : "GET",
				dataType : "json",
				url : "getFoodNutritions",
				data : {
					data : ndbno,
				},
				success : function(output) {
					$("#foodInfo").append(output.report.food.name);
					for(var i=0; i < output.report.food.nutrients.length; i++){
						$("#nutrientsInfo").append("<tr>");
						$("#nutrientsInfo").append("<td>" + output.report.food.nutrients[i].name + "</td>" );
						$("#nutrientsInfo").append("<td>" + output.report.food.nutrients[i].group + "</td>" );
						$("#nutrientsInfo").append("<td>" + output.report.food.nutrients[i].unit + "</td>" );
						$("#nutrientsInfo").append("<td>" + output.report.food.nutrients[i].value + "</td>" );
						$("#nutrientsInfo").append("</tr>");
						if(i == 0){
							$("#addFoodLink").attr("href", "addFoodToDB?ndbno=<%=ndbno%>&energy="+ output.report.food.nutrients[0].value);
						}
					}
				}
			});
			var addable = <%= request.getParameter("edit") %>
			if(addable==="false"){
				$("#addFoodLink").hide();
			}
		});
	</script>
</body>
</html>