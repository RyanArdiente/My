package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class NBAFileDAO implements NBADAO
{
	private static final String FILE_NAME = "WEB-INF/player.csv";
	private static final String LOGO_NAME = "WEB-INF/NBALogoLocations.csv";
	private static final String PLAYER_PIC_NAME = "WEB-INF/playerphotos.txt";
	public static Integer menuListNumber = 0;
	private List<String> customLogoList = new ArrayList<>();
	private List<Team> easternConference = new ArrayList<>();
	private List<Team> westernConference = new ArrayList<>();
	private List<Team> customTeams = new ArrayList<>();
	private List<Player> freeAgents = new ArrayList<>();
	private Team freeAgentsTeam = new Team("Free Agents", "NbaLogos/2971.gif", "N/A", "Free Agents");
	@Autowired
	private ApplicationContext ac;
	@Autowired
	private ApplicationContext ac2;
	@Autowired
	private ApplicationContext ac3;

	private List<String> logoLocation = new ArrayList<>();
	private List<Player> playerList = new ArrayList<>();
	private int currentIndexeast = -1;
	private int currentIndexwest = -1;
	private int currentIndexlogo = 0;

	@PostConstruct
	public void createNBA()
	{
		try (InputStream is = ac.getResource(LOGO_NAME).getInputStream();
				BufferedReader bufIn = new BufferedReader(new InputStreamReader(is)))
		{
			String line;
			while ((line = bufIn.readLine()) != null)
			{
				logoLocation.add(line);
			}
		} catch (IOException e)
		{
			System.out.println("Im not the problem");
		}
		runTeams();

	}

	public void runTeams()
	{
		try (InputStream is2 = ac2.getResource(FILE_NAME).getInputStream();
				BufferedReader bufIn2 = new BufferedReader(new InputStreamReader(is2)))
		{
			String line2 = "";
			while ((line2 = bufIn2.readLine()) != null)
			{

				String[] teamLine = line2.split("\\+");

				int playersCount = teamLine.length;
				// Create the Team
				initCreateTeam(teamLine[0].split(",")[0].trim(), teamLine[0].split(",")[1].trim(),
						Integer.parseInt(teamLine[0].split(",")[2].trim()), teamLine[0].split(",")[3].trim());
				for (int i = 1; i < playersCount; i++)
				{
					String[] currentTeamCreationLine = teamLine[i].split(",");
					if (Integer.parseInt(teamLine[0].split(",")[2].trim()) == 1)
					{

						// (String position, int number, String firstName,
						// String lastName, String height, String weight,String
						// dateOfBirth, String from)
						easternConference.get(currentIndexeast).getRoster()
								.add(new Player(currentTeamCreationLine[0].trim(),
										Integer.parseInt(currentTeamCreationLine[1].trim()),
										currentTeamCreationLine[3].trim(), currentTeamCreationLine[2].trim(),
										currentTeamCreationLine[4].trim(), currentTeamCreationLine[5].trim(),
										currentTeamCreationLine[6].trim(), currentTeamCreationLine[7].trim()));
					} else if (Integer.parseInt(teamLine[0].split(",")[2].trim()) == 2)
					{
						westernConference.get(currentIndexwest).getRoster()
								.add(new Player(currentTeamCreationLine[0].trim(),
										Integer.parseInt(currentTeamCreationLine[1].trim()),
										currentTeamCreationLine[3].trim(), currentTeamCreationLine[2].trim(),
										currentTeamCreationLine[4].trim(), currentTeamCreationLine[5].trim(),
										currentTeamCreationLine[6].trim(), currentTeamCreationLine[7].trim()));
					} 

				}

			}
			createFreeAgents();
			createCustomLogoList();
			customTeams.add(freeAgentsTeam);
			//was not tested
			//setAllPlayerPictures();
		} catch (Exception e)
		{
			System.out.println(e);
		}

	}

	private void initCreateTeam(String teamName, String coach, int conferenceNumb, String division)
	{
		if (conferenceNumb == 1)
		{
			currentIndexeast++;
			easternConference
					.add(new Team(teamName.trim(), logoLocation.get(currentIndexlogo), coach.trim(), division.trim()));
		} else
		{
			currentIndexwest++;
			westernConference
					.add(new Team(teamName.trim(), logoLocation.get(currentIndexlogo), coach.trim(), division.trim()));
		}
		currentIndexlogo++;
	}

	public List<Team> getEasternConference()
	{
		return easternConference;
	}

	public void setEasternConference(List<Team> easternConference)
	{
		this.easternConference = easternConference;
	}

	public List<Team> getWesternConference()
	{
		return westernConference;
	}

	public void setWesternConference(List<Team> westernConference)
	{
		this.westernConference = westernConference;
	}

	public Player getOnePlayer(String name)
	{
		for (int i = 0; i < easternConference.size(); i++)
		{
			for (Player player : easternConference.get(i).getRoster())
			{
				if (player.getFullName().trim().equalsIgnoreCase(name.trim()))
				{
					return player;
				}
			}
		}
		for (int i = 0; i < westernConference.size(); i++)
		{
			for (Player player : westernConference.get(i).getRoster())
			{
				if (player.getFullName().trim().equalsIgnoreCase(name.trim()))
				{
					return player;
				}
			}
		}
		for (int i = 0; i < customTeams.size(); i++)
		{
			for (Player player : customTeams.get(i).getRoster())
			{
				if (player.getFullName().trim().equalsIgnoreCase(name.trim()))
				{
					return player;
				}
			}
		}
		return null;
	}

	public void setAllPlayerPictures()
	{
		List<Player> allplayers = getAllPlayers();
		try (InputStream is3 = ac3.getResource(PLAYER_PIC_NAME).getInputStream();
				BufferedReader bufIn3 = new BufferedReader(new InputStreamReader(is3)))
		{

			String line3;
			while ((line3 = bufIn3.readLine()) != null)
			{

				String[] teamLine = line3.split("/");
				String playersName = teamLine[9].split(".")[0].split("_")[1] + " "
						+ teamLine[9].split(".")[0].split("_")[0];
				for (Player player : allplayers)
				{
					if (player.getFullName().equalsIgnoreCase(playersName))
					{
						player.setPictureLocation(teamLine[8]+"/"+teamLine[9]);
					}
				}
			}
		} catch (Exception e)
		{

		}

	}

	@Override
	public List<Player> getAllPlayers()
	{
		List<Player> temp = new ArrayList<>();
		for (Team team : easternConference)
		{
			temp.addAll(team.getRoster());
		}
		for (Team team : westernConference)
		{
			temp.addAll(team.getRoster());
		}
		temp.addAll(freeAgentsTeam.getRoster());
		return temp;
	}

	public void createFreeAgents()
	{
		// public Player(String position, int number, String firstName, String
		// lastName, String height, String weight,String dateOfBirth, String
		// from)
		freeAgents.add(
				new Player("C", 34, "Sim", "Bhullar", "7 ft 5 in", "355 lb", "1992-12–02", "Toronto - Ontario-Canada"));
		freeAgentsTeam.setRoster(freeAgents);
	}

	@Override
	public Team getTeamByName(String name)
	{
		Team newList = null;
		for (Team team : easternConference)
		{
			if (team.getTeamName().equals(name))
			{
				newList = team;
				return newList;
			}
		}
		for (Team team : westernConference)
		{
			if (team.getTeamName().equals(name))
			{
				newList = team;
				return newList;
			}
		}
		for (Team team : customTeams)
		{
			if (team.getTeamName().equals(name))
			{
				newList = team;
				return newList;
			}
		}
		return newList;
	}

	@Override
	public List<Team> getAllTeamList()
	{
		List<Team> temp = new ArrayList<>();
		temp.addAll(easternConference);
		temp.addAll(westernConference);
		temp.addAll(customTeams);
		return temp;
	}

	public List<Team> getCustomTeams()
	{
		return customTeams;
	}


	@Override
	public List<Player> getFreeAgents()
	{
		return freeAgents;
	}

	@Override
	public int checkNumberTeams()
	{
		int counter = 0;
		for (Team team : easternConference)
		{
			counter++;
		}
		for (Team team : westernConference)
		{
			counter++;
		}
		for (Team team : customTeams)
		{
			counter++;			
		}
		return counter;
	}

	@Override
	public int checkNumberPlayers()
	{
		int counter = 0;
		List<Player> allPlayers = getAllPlayers();
		for (Player player : allPlayers)
		{
			counter++;
		}
		return counter;
	}

	public List<String> getCustomLogoStrings()
	{
		return customLogoList;
	}

	@Override
	public void createCustomLogoList()
	{
		customLogoList.add("customLogos/aces.png");
		customLogoList.add("customLogos/admirals.png");
		customLogoList.add("customLogos/atoms.png");
		customLogoList.add("customLogos/average.png");
		customLogoList.add("customLogos/aztecs.png");
		customLogoList.add("customLogos/badgers.png");
		customLogoList.add("customLogos/bakers.png");
		customLogoList.add("customLogos/battlewings.png");
		customLogoList.add("customLogos/broncos.png");
		customLogoList.add("customLogos/colonels.png");
		customLogoList.add("customLogos/democrats.png");
		customLogoList.add("customLogos/moose.png");
		customLogoList.add("customLogos/nuts.png");
		customLogoList.add("customLogos/ocean.png");
		customLogoList.add("customLogos/panthers.png");
		customLogoList.add("customLogos/pioneers.png");
		customLogoList.add("customLogos/raccoon.png");
		customLogoList.add("customLogos/republicans.png");
		customLogoList.add("customLogos/sheep.png");
		customLogoList.add("customLogos/waves.png");
	}

	@Override
	public String removePlayer(String name)
	{
		for (int i = 0; i < easternConference.size(); i++)
		{
			for (Player player : easternConference.get(i).getRoster())
			{
				if (player.getFullName().trim().equalsIgnoreCase(name.trim()))
				{
					easternConference.get(i).getRoster().remove(player);
					return "Player Found";
				}
			}
		}
		for (int i = 0; i < westernConference.size(); i++)
		{
			for (Player player : westernConference.get(i).getRoster())
			{
				if (player.getFullName().trim().equalsIgnoreCase(name.trim()))
				{
					westernConference.get(i).getRoster().remove(player);
					return "Player Found";
				}
			}
		}
		for (int i = 0; i < customTeams.size(); i++)
		{
			for (Player player : customTeams.get(i).getRoster())
			{
				if (player.getFullName().trim().equalsIgnoreCase(name.trim()))
				{
					customTeams.get(i).getRoster().remove(player);
					return "Player Found";
				}
			}
		}
		return "Player Not Found";
	}

}
