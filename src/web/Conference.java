package web;

import java.util.ArrayList;
import java.util.List;

public final class Conference
{
	private String name;
	private List<Team> conferenceTeams = new ArrayList<>();
	private String logoLocation;

	public Conference()
	{

	}

	public Conference(String name, String logoLocatino)
	{
		this.name = name;
		this.logoLocation = logoLocatino;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Team> getConferenceTeams()
	{
		return conferenceTeams;
	}

	public void setConferenceTeams(List<Team> conferenceTeams)
	{
		this.conferenceTeams = conferenceTeams;
	}

	public String getLogoLocation()
	{
		return logoLocation;
	}

	public void setLogoLocation(String logoLocation)
	{
		this.logoLocation = logoLocation;
	}

}
