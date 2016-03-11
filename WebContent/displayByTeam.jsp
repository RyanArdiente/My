<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<link type="text/css" rel="stylesheet" href="css/displayByTeam.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Team Display</title>
</head>
	<c:choose >
		<c:when test="${! empty team}">
<body id="body" background="${team.logoLocation}">
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
 <div class="container">
			<div class="left-align">
				
					<%-- <div><img id="teampic" src="${currentTeam.logoLocation}"/></div> --%> 
					<div class="playerDisplay">Team Name: ${team.teamName} </div>
					<div class="playerDisplay">Coach: ${team.coach} </div>
					<div class="playerDisplay">Division: ${team.division} </div>
					
				
			</div>
			<c:forEach var="player" items="${team.roster}">
				<div class="left-align">
					
					<ul>
											
						<li><a href="playerView.do?name=${player.fullName}">${player.fullName}</a></li>
						
						<li class="playerDisplay">Position: ${player.position}</li>
						<li class="playerDisplay">Number: ${player.number}</li>
					</ul>
				</div>

			</c:forEach>
		</c:when>
		<c:otherwise>
			<p>No player found</p>
		</c:otherwise>
	</c:choose>
</div>
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="js/materialize.js"></script>
<script src="js/init.js"></script>
</body>
</html>