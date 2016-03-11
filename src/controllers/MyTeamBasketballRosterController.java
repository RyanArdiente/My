package controllers;

import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import web.NBADAO;
import web.Player;
import web.Team;

@Controller
@SessionAttributes({ "numb", "indexOfTeam"})
public class MyTeamBasketballRosterController
{
	@Autowired
	private NBADAO nbaDao;

	@ModelAttribute("numb")
	public int initStart()
	{
		return 0;
	}
	
	@ModelAttribute("indexOfTeam")
	public int initIndex()
	{
		return 0;
	}
	
	@RequestMapping("displayAllPlayers.do")
	
	public ModelAndView initDisplay()
	{
		ModelAndView mv = new ModelAndView("displayByPlayers.jsp");
		
		mv.addObject("currentPlayer", nbaDao.getAllPlayers().get(0));
		// mv.addObject("hello", "hello");
		return mv;
	}

	@RequestMapping("displayAllTeams.do")
	public ModelAndView initDisplayByTeam()
	{
		ModelAndView mv = new ModelAndView("displayByTeam.jsp");
		mv.addObject("team", nbaDao.getAllTeamList().get(0));
		// mv.addObject("hello", "hello");
		return mv;
	}

	@RequestMapping(path = "displayAll.do", name = "name")
	public ModelAndView initDisplayByTeam(@RequestParam("name") String teamname,
			@ModelAttribute("indexOfTeam") int index)
	{
		ModelAndView mv = new ModelAndView("displayByTeam.jsp");
		index = nbaDao.checkNumberTeams();
		
		if(nbaDao.getAllTeamList().indexOf((nbaDao.getTeamByName(teamname))) == nbaDao.checkNumberTeams())
		{
			mv.addObject("team",nbaDao.getAllTeamList().get(nbaDao.getAllTeamList().indexOf(nbaDao.getTeamByName(teamname))));
		}
		else{
			
			mv.addObject("team",nbaDao.getAllTeamList().get(nbaDao.getAllTeamList().indexOf((nbaDao.getTeamByName(teamname)))));
		}
		mv.addObject("indexOfTeam", index);
		return mv;
	}
	
	@RequestMapping(path = "ChangeData.do", params = "submit")
	public ModelAndView viewAllPlayers(@RequestParam("submit") String p, @ModelAttribute("numb") int numb)
	{
		int totalplayerindex = nbaDao.checkNumberPlayers()-1;
		ModelAndView mv = new ModelAndView("displayByPlayers.jsp");
		if (p.equals("Previous"))
		{
			if (numb == 0)
			{
				numb = totalplayerindex;
			}
			mv.addObject("numb", --numb);
		} else if (p.equals("Next"))
		{
			if (numb == totalplayerindex -1)
			{
				numb = -1;
			}

			mv.addObject("numb", ++numb);
		}
		mv.addObject("currentPlayer", nbaDao.getAllPlayers().get(numb));
		return mv;
	}

	@RequestMapping(path = "manipulate.do", params = "submit")
	public ModelAndView editPlayer(@RequestParam("submit") String p,
			@ModelAttribute("indexOfTeam") int indexOfTeam)
	{
		System.out.println(p.split(":")[1]);
		if(p.split(":")[0].equalsIgnoreCase("Edit"))
		{
			return new ModelAndView("editplayer.jsp","player", nbaDao.getOnePlayer(p.split(":")[1]));
		}
		else
		{
			System.out.println(nbaDao.checkNumberPlayers());

			nbaDao.removePlayer(p.split(":")[1]);
			System.out.println(nbaDao.checkNumberPlayers());
		}
		
		return new ModelAndView("index.html");
	}
	@RequestMapping(path = "editplayer.do", method=RequestMethod.POST)
	public String playerEdit(@RequestParam("fullName") String fullName,@RequestParam("fName") String firstName,@RequestParam("lName") String lastName, @RequestParam("position") String position, @RequestParam("number") String number, @RequestParam("DoB") String dateOfBirth, @RequestParam("height") String height, @RequestParam("weight") String weight,@RequestParam("from") String from)
	{
		Player temp = nbaDao.getOnePlayer(fullName);
		temp.setFirstName(firstName);
		temp.setLastName(lastName);
		temp.setFullName(firstName + " " + lastName);
		temp.setNumber(Integer.parseInt(number));
		temp.setFrom(from);
		temp.setHeight(height);
		temp.setWeight(weight);
		temp.setDateOfBirth(dateOfBirth);
		
		return "";
	}
	
	@RequestMapping(path = "playerView.do", params = "name")
	public ModelAndView viewSinglePlayer(@RequestParam("name") String playerFullName)
	{
		System.out.println("Inside single player method");
		ModelAndView mv = new ModelAndView();
		for (Player player : nbaDao.getAllPlayers())
		{
			if (player.getFullName().equals(playerFullName))
			{
				mv.setViewName("displaySinglePlayer.jsp");
				mv.addObject("player", player);

			}
		}

		return mv;
	}

	@RequestMapping(path = "displayAllTeamsByDivision.do")
	public ModelAndView viewConferencePage()
	{
		System.out.println(nbaDao.checkNumberPlayers());
		ModelAndView mv = new ModelAndView("displayAllTeams.jsp");
		mv.addObject("nba", nbaDao.getAllTeamList());
		System.out.println(nbaDao.checkNumberPlayers());
		return mv;
	}
	@RequestMapping(path="addPlayer.do", method=RequestMethod.GET)
	public ModelAndView addPlayer()
	{
		Player p = new Player();
		return new ModelAndView("newplayer.jsp", "player", p);
	}
	@RequestMapping(path = "addPlayer.do", method=RequestMethod.POST)
	public String addPlayer(@Valid Player player, Errors errors)
	{
		if (errors.getErrorCount() != 0)
		{
			return "newplayer.jsp";
		}
		nbaDao.getFreeAgents().add(player);
		return "displaySinglePlayer.jsp";
	}
	@RequestMapping(path = "addNewTeam.do", method=RequestMethod.GET)
	public ModelAndView addTeam()
	{
		Team t = new Team();
		ModelAndView mv = new ModelAndView("newteam.jsp","nteam", t);
		return mv;
	}
	@RequestMapping(path = "addNewTeam.do", method=RequestMethod.POST)
	public String addTeam(@Valid Team team, Errors errors)
	{
		if(errors.getErrorCount() != 0)
		{
			return "newteam.jsp";
		}

		team.setLogoLocation((nbaDao.getCustomLogoStrings()).get(((int)(Math.random()*19))+0));
		nbaDao.getCustomTeams().add(team);
		
	
		return "displayByTeam.jsp";
	}

	
}
