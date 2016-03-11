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
<link href="css/index.css" type="text/css" rel="stylesheet"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Player creation</title>

</head>
<body>
	<div class="navbar-fixed">
  <nav>
    <div class="nav-wrapper">
      <a href="http://localhost:8080/MyTeamBasketballRoster/" class="brand-logo center">ARDSPN</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
			<li><a href="#">NBA View</a>
				<ul>
					<li><a href="displayAllPlayers.do">View All Players</a></li>
					<li><a href="displayAllTeamsByDivision.do">View All Teams</a></li>
				</ul>
			</li>
       <li><a href="#">Creation Center</a>
				<ul>
					<li><a href="addPlayer.do">Create New Player</a> </li>
					<li><a href="addNewTeam.do">Create New Team</a> </li>
				</ul>
			</li>
      </ul>
      </li>
    </div>
  </nav>
</div>
		<h3>Create Player</h3>
		<form:form action="addPlayer.do" modelAttribute="player">
		<div class = "contain" class="center-align">
		<table>
			<tr>
				
				<td>First Name:<form:input path="firstName" /></td>
				<td><form:errors path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name:<form:input path="lastName" /></td>
				<td><form:errors path="lastName" /></td>
			</tr>
			<tr>
				<td>Position:<form:input path="position" /></td>
				<td><form:errors path="position" /></td>
			</tr>
			<tr>
				<td>Number:<form:input path="number" /></td>
				<td><form:errors path="number" /></td>
			</tr>
			<tr>
				<td>Date Of Birth:<form:input path="dateOfBirth" /></td>
				<td><form:errors path="dateOfBirth" /></td>
			</tr>
			<tr>
				<td>Height:<form:input path="height" /></td>
				<td><form:errors path="height" /></td>
			</tr>
			<tr>
				<td>Weight:<form:input path="weight" /></td>
				<td><form:errors path="weight" /></td>
			</tr>
			<tr>
				<td>From:<form:input path="from" /></td>
				<td><form:errors path="from" /></td>
			</tr>
		</table>
	</div>
	<button class="btn waves-effect waves-light #d32f2f red darken-2" type="submit" name="submit" value="Add Player">
    <i class="material-icons right">done</i>Create Player
  </button>
		</form:form>
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="js/materialize.js"></script>
<script src="js/init.js"></script>
</body>
</html>