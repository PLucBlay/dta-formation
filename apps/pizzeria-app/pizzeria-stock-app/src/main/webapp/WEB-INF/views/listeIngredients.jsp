<%@page import="java.util.List"%>
<%@page import="fr.pizzeria.entity.Ingredient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authentification</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
		<h1>Nos Ingredients</h1>
		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th>nom</th>
						<th>prix</th>
						<th>qte</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="ingredient" items="${listIngredients}">
						<tr>
							<td>${ingredient.nom}</td>
							<td>${ingredient.prix}</td>
							<td>${ingredient.quantite}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>