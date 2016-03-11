package web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

public class Team
{
	private List<Player> roster = new ArrayList<>();
	@NotNull
	private String teamName = "My Team";
	@NotNull
	private String coach = "Mike Krzyzewski";
	private String logoLocation = "";
	@NotNull
	private String division = "Custom";
	public Team()
	{
		
	}
	public Team(String teamName)
	{
		this.teamName = teamName;
	}
	public Team(String teamName, String logoLocation)
	{
		this.teamName = teamName;
		this.logoLocation = logoLocation;
	}
	public Team(String teamName, String logoLocation, String coach, String division)
	{
		this.teamName = teamName;
		this.logoLocation = logoLocation;
		this.coach = coach;
		this.division = division;
	}
	public List<Player> getRoster()
	{
		return roster;
	}
	public void setRoster(List<Player> roster)
	{
		this.roster = roster;
	}
	public String getTeamName()
	{
		return teamName;
	}
	public void setTeamName(String teamName)
	{
		this.teamName = teamName;
	}
	public String getCoach()
	{
		return this.coach;
	}
	public void setCoach(String coach)
	{
		this.coach = coach;
	}
	public String getLogoLocation()
	{
		return logoLocation;
	}
	public void setLogoLocation(String logoLocation)
	{
		this.logoLocation = logoLocation;
	}
	public String getDivision()
	{
		return division;
	}
	public void setDivision(String division)
	{
		this.division = division;
	}
	
}
