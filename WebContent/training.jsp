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
				<li role="presentation" class="active"><a
					href="TrainingServlet?action=insert">Dodaj</a></li>
				<li role="presentation"><a
					href="TrainingServlet?action=listTrainings">Wyświetl</a></li>
			</ul>
			</nav>
			<h3 class="text-muted">Rejestrator treningów biegowych</h3>
		</div>
		<form action="TrainingServlet" method="post" id="
		training-form">
			<div class="form-group">
				<label for="date">Dzień treningu (yyyy-mm-dd)</label> <input
					type="text" class="form-control" name="date"
					value='<c:out value="${training.date }"></c:out>'
					placeholder="Data" required
					pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])"
					title="Data musi być podana w formacie YYYY-MM-DD" />
			</div>
			<div class="form-group">
				<label for="distance">Przebyty dystans (km)</label> <input
					type="number" step="0.01" class="form-control" name="distance"
					value='<c:out value="${training.distance }"></c:out>'
					placeholder="dystans" required />
			</div>
			<div class="form-group">

				<label for="time">Czas treningu (hh:mm:ss)</label> <input
					type="text" class="form-control" name="time"
					value='<c:out value="${training.time }"></c:out>'
					placeholder="czas" required
					pattern="(0[0-9]|1[0-9]|2[0-3])(:[0-5][0-9]){2}"
					title="Czas musi być podany w formacie HH:MM:SS" />
			</div>
			<div class="form-group">
				<label for="burnCalories">spalone kalorie (kCal)</label> <input
					type="number" class="form-control" name="burnCalories"
					value='<c:out value="${training.burnCalories }"></c:out>'
					placeholder="kalorie" required />
			</div>
			<div class="form-group">
				<label for="comment">Uwagi</label>
				<%-- <input type="text"  class="form-control" name="comment"
					value='<c:out value="${training.comments }"></c:out>'
					placeholder="uwagi" required /> --%>
				<textarea class="form-control" rows="3" name="comment"
					value='<c:out value="${training.comments }"></c:out>'
					placeholder="uwagi" required>${training.comments}</textarea>
			</div>
			<input type="hidden" name="trainingId"
				value="<c:out value="${training.trainingId}" />" />
			<button type="submit" class="btn btn-default">Zapisz</button>
		</form>
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
