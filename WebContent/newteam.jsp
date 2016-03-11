<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/animate.css" type="text/css" rel="stylesheet" />
<link href="css/index.css" type="text/css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Player</title>
</head>
<body>
	<div class="navbar-fixed">
		<nav>
		<div class="nav-wrapper">
			<a href="http://localhost:8080/MyTeamBasketballRoster/"
				class="brand-logo center">ARDSPN</a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li><a href="#">NBA View</a>
					<ul>
						<li><a href="displayAllPlayers.do">View All Players</a></li>
						<li><a href="displayAllTeamsByDivision.do">View All Teams</a></li>
					</ul></li>
				<li><a href="#">Creation Center</a>
					<ul>
						<li><a href="addPlayer.do">Create New Player</a></li>
						<li><a href="addNewTeam.do">Create New Team</a></li>
					</ul></li>
			</ul>
			</li>
		</div>
		</nav>
	</div>
	<div class="container" class="center-align">
	<h3>Create Player</h3>
	<form:form action="addNewTeam.do" modelAttribute="nteam">
		<table>
			<tr>
				<td>Team Name:</td>
				<td><form:input path="teamName" /></td>
				<td><form:errors path="teamName" /></td>
			</tr>
			<tr>
				<td>Division:</td>
				<td><form:input path="division" /></td>
				<td><form:errors path="division" /></td>
			</tr>
			<tr>
				<td>Coach:</td>
				<td><form:input path="coach" /></td>
				<td><form:errors path="coach" /></td>
			</tr>

		</table>

		<button class="btn waves-effect waves-light #d32f2f red darken-2" type="submit" name="submit" value="Add Team">
  		  <i class="material-icons right">done</i>Create Team
  		</button>
	</form:form>
</div>
	<script src="js/materialize.js"></script>
	<script src="js/init.js"></script>
</body>
</html>