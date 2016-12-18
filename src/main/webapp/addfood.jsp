<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>Health Tracker Add Food Page</title>
</head>
<body>
<h1>	<h2>Welcome ${user.userName}</h2></h1>
             	<form id="foodForm" action="#">
					<input id="foodToSearch" type="text" path="foodSearch" />
					<input type="submit" value="Search" />
				</form>
	<table>
		<thead>
		<tr>
			<th> Food Name </th>
			<th> Group </th>
			</tr>
		<thead>
		<tbody id="food">
			
	</table>

	
	<script type="text/javascript" >
		$(document).ready(function(){
			$("#foodForm").submit(function(e){
				e.preventDefault();
				$("#food").html(" ");
				var food = $("#foodToSearch").val();
				console.log(food);
				$.ajax({
			        type: "GET",
			        dataType: "json",
			        url: "getFoodList",
			        data: {
			          data : food,
			        },
			        success: function (output) {
			        	for (var i = 0; i < output.list.item.length; i++){
			        		$("#food").append(" <tr><td> <a href=\"foodInfo?ndbno="+output.list.item[i].ndbno+"\"> " + output.list.item[i].name + "</a></td>" + "<td> " + output.list.item[i].group + "</td> </tr>");
			        	}

			        }
			    });
			});
		});
	</script>


</body>
</html>