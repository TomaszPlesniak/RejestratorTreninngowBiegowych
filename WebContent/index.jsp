<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="style.css" rel="stylesheet">
<title>Rejestrator treningów biegowych</title>
</head>
<body>
	<div class="container">
		<div class="header clearfix">
			<nav>
			<ul class="nav nav-pills pull-right">
				<li role="presentation" class="active"><a
					href="TrainingServlet?action=home">Home</a></li>
				<li role="presentation"><a href="TrainingServlet?action=insert">Dodaj</a></li>
				<li role="presentation"><a
					href="TrainingServlet?action=listTrainings">Wyświetl</a></li>
			</ul>
			</nav>
			<h3 class="text-muted">Rejestrator treningów biegowych</h3>
		</div>

		<div class="jumbotron">
			<h1>Bądź aktywny z nami!</h1>
			<p class="lead">Nasza aplikacja sprawi, że łatwiej będzie Ci
				dokumentować Twoją pasję, jaką jest bieganie. Monitoruj Swoje
				postępy, bądź wytrwały i każdego dnia staraj się dokonywać więcej.
				Powodzenia w treningu!</p>
			<p>
				<a class="btn btn-lg btn-success"
					href="TrainingServlet?action=insert" role="button">Dodaj
					trening</a>
			</p>
		</div>
		<footer class="footer">
		<p>&copy; 2016 Tomasz Plesniak</p>
		</footer>

	</div>
	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>