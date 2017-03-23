<%@page import="fr.pizzeria.model.CategoriePizza"%>
<%@page import="java.util.List"%>
<%@page import="fr.pizzeria.model.Pizza"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Créer Pizza</title>
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
		<form class="form-horizontal" method="POST" action="new">
			<fieldset>
				<!-- Form Name -->
				<legend>Création de pizza</legend>
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="code">Code</label>
					<div class="col-md-4">
						<input id="code" name="code" type="text"
							placeholder="Code de la pizza" class="form-control input-md" required="">
					</div>
				</div>
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="nom">Nom</label>
					<div class="col-md-4">
						<input id="nom" name="nom" type="text"
							placeholder="Nom de la pizza" class="form-control input-md" required="">
					</div>
				</div>
				<!-- Multiple Radios -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="categorie">Categorie</label>
					<div class="col-md-4">
						<div class="radio">
							<label for="categorie-0"> <input type="radio"
								name="categorie" id="categorie-0" value="VIANDE"
								checked="checked" > Viande
							</label>
						</div>
						<div class="radio">
							<label for="categorie-1"> <input type="radio"
								name="categorie" id="categorie-1" value="POISSON"> Poisson
							</label>
						</div>
						<div class="radio">
							<label for="categorie-2"> <input type="radio"
								name="categorie" id="categorie-2" value="SANS_VIANDE"> Sans Viande
							</label>
						</div>
					</div>
				</div>
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="prix">Prix</label>
					<div class="col-md-4">
						<input id="prix" name="prix" type="text"
							placeholder="Prix de la pizza" class="form-control input-md" required="">
					</div>
				</div>
				<!-- Button -->
				<div class="form-group">
					<div class="col-md-4 control-label">
						<button type="submit" id="buttonok" name="buttonOK"
							class="btn btn-success">Envoyer</button>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>