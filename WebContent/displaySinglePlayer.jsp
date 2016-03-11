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
<title>Player Display</title>
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
 <div class="container"  class ="center-align">
<c:choose >
		<c:when test="${! empty player}">
        <div class="col s12 m6" class ="center-align">
          <div class="card" >
            <div class="card-content black-text">
              <span class="card-title">Edit Player</span>
				<div class="row">
               <ul class ="center-align">
						<li>Full Name: ${player.fullName}</li>
						<li>Position: ${player.position}</li>
						<li>Number: ${player.number}</li>
						<li>Height: ${player.height}</li>
						<li>Weight: ${player.weight}</li>
						<li>Date of Birth: ${player.dateOfBirth}</li>
						<li>Age: ${player.age}</li>
						<li>From/Origin: ${player.from}</li>
					</ul>
            </div>
            <div class="card-action">
             	<form action="manipulate.do" method="GET" class ="center-align">
				  <button class="btn waves-effect waves-light #d32f2f red darken-2" type="submit" name="submit" value="Edit:${player.fullName}">
    				<i class="material-icons left">input</i>Edit
  				 </button>
 				 <button class="btn waves-effect waves-light #d32f2f red darken-2" type="submit" name="submit" value="Delete:${player.fullName}">
				    <i class="material-icons right">not_interested</i>Delete
  				</button>
				</form>
            </div>
          </div>
        </div>
      </div>
     
			
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