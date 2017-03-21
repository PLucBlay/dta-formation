<%@page import="java.util.List"%>
<%@page import="fr.pizzeria.model.Pizza"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lister Pizzas</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Lister Pizzas</h1>
		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th>Code</th>
						<th>Nom</th>
						<th>Categorie</th>
						<th>Prix</th>
					</tr>
				</thead>
				<tbody>
					<%
						List<Pizza> pizzas = (List<Pizza>) request.getAttribute("listPizzas");
					%>
					<%
						for (Pizza piz : pizzas) {
					%>
					<tr>
						<td><%=piz.getCode()%></td>
						<td><%=piz.getNom()%></td>
						<td><%=piz.getCategorie()%></td>
						<td><%=piz.getPrix()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>