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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Player View</title>
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
 <div class="container">
<c:choose>
<c:when test="${! empty currentPlayer}">
			
			
  	<div class="card large" class=" center-align">
    <div class="card-image waves-effect waves-block waves-light">
      <img class="center-align" id="playerPicture" class="activator" src="${currentPlayer.pictureLocation}">
    </div>
    <div class="center-align" class="card-content">
      <span class="card-title activator grey-text text-darken-4">${currentPlayer.fullName}<i class="material-icons right">more_vert</i></span>
    </div>
    <div  class="card-reveal">
      <span  class="center-align" class="card-title black-text">${currentPlayer.fullName}<i class="material-icons right">close</i></span>
      	<div class="center-align">
				<p class="playertext">Age : ${currentPlayer.age}</p>
				<p class="playertext">Position : ${currentPlayer.position}</p>
				<p class="playertext">From/Origin : ${currentPlayer.from}</p>
				<p class="playertext">Number : ${currentPlayer.number}</p>
				<p class="playertext">Stats Go Here</p>
		</div>
    </div>
  </div>
			
			
</c:when>
	<c:otherwise>
			<p>No player found</p>
	</c:otherwise>
</c:choose>
</div>
	<form class="center-align" action="ChangeData.do" method="GET">
  <button class="btn waves-effect waves-light #d32f2f red darken-2" type="submit" name="submit" value="Previous">
    <i class="material-icons left">fast_rewind</i>Previous
  </button>
  <button class="btn waves-effect waves-light #d32f2f red darken-2" type="submit" name="submit" value="Next">
    <i class="material-icons right">fast_forward</i>Next
  </button>
</form>
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="js/materialize.js"></script>
<script src="js/init.js"></script>
</body>
</html>