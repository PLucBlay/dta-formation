<%@page import="java.util.List"%>
<%@page import="fr.pizzeria.model.Pizza"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lister Pizzas</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- My CSS -->
<link rel="stylesheet"
	href="<c:url value='/css/pizzeria.css'></c:url>">


<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="list">Pizzeria</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<form class="navbar-form navbar-right">
					<a type=button class="btn btn-danger" href="<c:url value='/login'></c:url>?log=out">Déconnexion</a>
				</form>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>
	<div class="container">
		<h1>Nos Pizzas</h1>
		<a href="new" class="btn btn-primary">Créer une pizza</a>
		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th>Code</th>
						<th>Nom</th>
						<th>Categorie</th>
						<th>Prix</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="pizza" items="${listPizzas}">
						<tr>
							<td>${pizza.code}</td>
							<td>${pizza.nom}</td>
							<td>${pizza.categorie.friendlyName}</td>
							<td>${pizza.prix}</td>
							<td><a type="button" href="edit?code=${pizza.code}"
								class="btn btn-primary btn-xs">Editer</a> <a type="button"
								href="list?delete=${pizza.code}" class="btn btn-danger btn-xs">Supprimer</a></td>
						</tr>
					</c:forEach>
					<!--
					<%List<Pizza> pizzas = (List<Pizza>) request.getAttribute("listPizzas");%>
					<%for (Pizza piz : pizzas) {%>
					<tr>
						<td><%=piz.getCode()%></td>
						<td><%=piz.getNom()%></td>
						<td><%=piz.getCategorie()%></td>
						<td><%=piz.getPrix()%></td>
						<td><a type="button" href="edit?code=<%=piz.getCode()%>"
							class="btn btn-primary btn-xs">Editer</a> <a type="button"
							href="delete?code=<%=piz.getCode()%>"
							class="btn btn-danger btn-xs">Supprimer</a></td>
					</tr>
					<%}%>  -->
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>