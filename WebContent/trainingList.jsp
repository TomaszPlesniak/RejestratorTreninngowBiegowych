<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<li role="presentation"><a href="TrainingServlet?action=home">Home</a></li>
				<li role="presentation"><a href="TrainingServlet?action=insert">Dodaj</a></li>
				<li role="presentation" class="active"><a
					href="TrainingServlet?action=listTrainings">Wyświetl</a></li>
			</ul>
			</nav>
			<h3 class="text-muted">Rejestrator treningów biegowych</h3>
		</div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Data</th>
					<th>Dystans (km)</th>
					<th>Czas</th>
					<th>kCal</th>
					<th>Uwagi</th>
					<th colspan="2">Akcja</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="training" items="${requestScope.trainings}">
					<tr>
						<td><c:out value="${training.date}" /></td>
						<td><c:out value="${training.distance}" /></td>
						<td><c:out value="${training.time}" /></td>
						<td><c:out value="${training.burnCalories}" /></td>
						<td><c:out value="${training.comments}" /></td>
						<td><a
							href="TrainingServlet?action=edit&trainingId=<c:out value="${training.trainingId }"/>"><span
								class="glyphicon glyphicon-edit" aria-hidden="true"></span> </a> <a
							href="TrainingServlet?action=delete&trainingId=<c:out value="${training.trainingId }"/>"><span
								class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
					<tr>
				</c:forEach>
			</tbody>
		</table>
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



