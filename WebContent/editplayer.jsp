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
<title>Edit Player</title>
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
      </li>
      </ul>
    </div>
  </nav>
</div>
	<h3>Edit Player</h3>
		<form action="editplayer.do" method="POST">
		<table>
			<tr>
				<td><input value="${player.fullName}" type="hidden" name="fullName"  value="${player.fullName}"/></td>
			</tr>
			<tr>
				<td>First Name:<input type="text" name="fName" value="${player.firstName}" ></td>
			</tr>
			<tr>
				<td>Last Name:<input type="text" name="lName" value="${player.lastName}" ></td>
			</tr>
			<tr>
				<td>Position:<input type="text" name="position" value="${player.position}" ></td>
			</tr>
			<tr>
				<td>Number:<input type="text" name="number" value="${player.number}" ></td>
			</tr>
			<tr>
				<td>Date Of Birth:<input type="text" name="DoB"value="${player.dateOfBirth}" ></td>
			</tr>
			<tr>
				<td>Height:<input type="text" name="height" value="${player.height}" ></td>
			</tr>
			<tr>
				<td>Weight:<input type="text" name="weight" value="${player.weight}"></td>
			</tr>
			<tr>
				<td>From:<input type="text" name="from" value="${player.from}"></td>
			</tr>
		</table>
			<button class="btn waves-effect waves-light #d32f2f red darken-2" type="submit" name="submit" value="Finish Editing Player">
    		<i class="material-icons right">done</i>Finish Editing Player
  			</button>
		</form>
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="js/materialize.js"></script>
<script src="js/init.js"></script>
</body>
</html>