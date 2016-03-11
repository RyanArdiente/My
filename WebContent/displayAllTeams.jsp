<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <link rel="stylesheet" href="css/index.css" type="text/css"/> -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
    rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet"
    media="screen,projection" />
<link href="css/style.css" type="text/css" rel="stylesheet"
    media="screen,projection" />
<link href="css/animate.css" type="text/css" rel="stylesheet" />
<link href="css/index.css" type="text/css" rel="stylesheet"/>
<link rel="stylesheet" href="css/teamdisplay.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display All Teams</title>
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
 
    </div>
  </nav>
</div>
<div><h1 id="allTeams">All Teams</h1>
</div>
	<c:choose>
	<c:when test="${! empty nba}">
	 <div class="container">
		<div class="row">
		<c:forEach var="team" items="${nba}">
    	  	<div class="col s3">
					<div><img class="teampicture" src="${team.logoLocation}"/></div>
    	  			<div><a id="teamNameSize" href="displayAll.do?name=${team.teamName}">${team.teamName}</a></div>
			</div>
		</c:forEach>
      	</div>
      </div>
		</c:when>
	</c:choose>
	
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="js/materialize.js"></script>
<script src="js/init.js"></script>
</body>
</html>