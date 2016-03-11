package web;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Player
{
	
	private String primaryPosition = "G";
	private String secondaryPosition = "";
	private String position = "G";
	@Min(00)
	@Max(99)
	private int number = 0;
	@NotNull
	private String firstName = "First Name";
	@NotNull
	private String lastName = "Last Name";
	@NotNull
	private String height = "6 ft 0 in";
	@NotNull
	private String weight = "175 lb";
	@NotNull
	private String dateOfBirth = "1990-01-01";
	@NotNull
	private String fromOrigin = "N/A";
	
	private String age;
	private String fullName;
	private static  Date date = new Date();
	private static Timestamp ts = new Timestamp(date.getTime());
	private String pictureLocation = "stockplayer/stockplayer.png";
	public Player()
	{
		
	}
	public Player(String position, int number, String firstName, String lastName, String height, String weight,
			String dateOfBirth, String from)
	{
		if(position.contains("/"))
		{
			this.primaryPosition = position.split("/")[0];
			this.secondaryPosition = position.split("/")[1];			
		}
		else
		{
			this.primaryPosition = position;
		}
		this.position = position;
		this.number = number;
		this.firstName = firstName;
		this.lastName = lastName;
		this.height = height;
		this.weight = weight;
		this.dateOfBirth = dateOfBirth;
		this.fromOrigin = from;
		this.fullName = firstName + " " + lastName;

		//                   Current Date                                 -                                Player's DOB  
		this.age =  (Integer.parseInt(ts.toString().split(" ")[0].split("-")[0].trim()) - Integer.parseInt(dateOfBirth.split("-")[0]) )+ " years old";

		//For user created player will reset position
		if(position.length() == 2)
		{
			this.primaryPosition = position.toCharArray()[0] + "";
			this.secondaryPosition = position.toCharArray()[1] + "";
			this.position = position.toCharArray()[0] + "/" + position.toCharArray()[1];
		}
	}
	public String getPictureLocation()
	{
		return pictureLocation;
	}
	public void setPictureLocation(String pictureLocation)
	{
		this.pictureLocation = pictureLocation;
	}

	public String getAge()
	{
		return this.age;
	}
	public String getPosition()
	{
		return position;
	}

	public void setPosition(String position)
	{
		System.out.println(position);
		if(position.contains(","))
		{
			this.primaryPosition = position.split(",")[0];
			this.secondaryPosition = position.split(",")[1];
			this.position = position.split(",")[0] + "/" + position.split(",")[1];
		}
		else
		{
			this.primaryPosition = position;			
		}
	}

	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
		this.fullName = firstName + " " + lastName;

	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
		this.fullName = firstName + " " + lastName;

	}

	public String getHeight()
	{
		return height;
	}

	public void setHeight(String height)
	{
		this.height = height;
	}

	public String getWeight()
	{
		return weight;
	}

	public void setWeight(String weight)
	{
		this.weight = weight;
	}

	public String getDateOfBirth()
	{
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
			this.age =  (Integer.parseInt(ts.toString().split(" ")[0].split("-")[0].trim()) - Integer.parseInt(dateOfBirth.split("-")[0]) )+ " years old";

		
	}

	public String getFrom()
	{
		return fromOrigin;
	}

	public void setFrom(String from)
	{
		this.fromOrigin = from;
	}
	public String getFullName()
	{
		return fullName;
	}
	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}
	@Override
	public String toString()
	{
		return position + " " + getFullName() + " " + this.height + " " + this.weight + " " + this.dateOfBirth + " " + this.fromOrigin;
	}
	
}
