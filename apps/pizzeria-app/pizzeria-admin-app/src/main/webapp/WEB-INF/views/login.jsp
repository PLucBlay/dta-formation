<%@page import="java.util.List"%>
<%@page import="fr.pizzeria.model.Pizza"%>
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

<!-- My CSS -->
<link rel="stylesheet" href="<c:url value='/css/pizzeria.css'></c:url>">

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
				<a class="navbar-brand" href="pizzas/list">Pizzeria</a>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>
	<div class="container">
		<form class="form-horizontal" method="POST" action="login">
			<fieldset>
				<!-- Form Name -->
				<legend>Authentification</legend>
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="login">Login(adresse
						mail)</label>
					<div class="col-md-4">
						<input id="login" name="login" type="text" placeholder="Login"
							class="form-control input-md" required="">
					</div>
				</div>
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="pass">Password</label>
					<div class="col-md-4">
						<input id="pass" name="pass" type="password"
							placeholder="Password" class="form-control input-md">
					</div>
				</div>
				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="buttonok"></label>
					<div class="col-md-4">
						<button id="buttonok" name="buttonok" class="btn btn-success"
							type="submit">Valider</button>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>