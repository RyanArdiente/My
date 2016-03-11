package web;

import java.util.List;

public interface NBADAO
{
	
	public List<Player> getAllPlayers();	
	public Team getTeamByName(String name);
	public List<Team> getAllTeamList();
	public List<Team> getEasternConference();
	public List<Team> getWesternConference();
	public List<Player> getFreeAgents();
	public int checkNumberTeams();
	public int checkNumberPlayers();
	public List<String> getCustomLogoStrings();
	public void createCustomLogoList();
	public List<Team> getCustomTeams();
	public String removePlayer(String name);
	public Player getOnePlayer(String name);
}
