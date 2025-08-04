package ObjectOriented;
//class for a Skier object
//Kendall McCullom

public class Skier 
{
	//static variables
	private static int skierObjects;
	
	//instance variables
	private String country;
	private int ranking;
	private int finished; 
	
	//constructor
	public Skier (String c, int r)
	{
		country = c;
		ranking = r;
		skierObjects++;
		
	}
	
	//static method
	public static int numberOfSkiers()
	{
		return skierObjects;
	}
	
	//getters
	public String getCountry()
	{
		return country;
	}
		
	public int getRanking()
	{
		return ranking;
	}
		
	public int getFinished()		
	{
		return finished;
	}
	
	//setters
	public void setCountry(String c)
	{
		country = c;
	}
	
	public void setRanking(int r)
	{
		ranking = r;
	}
	
	public void setFinished(int f)
	{
		finished = f;
	}
	
	//instance method
	public boolean hasSameRanking(Skier s)
	{
		if (this.ranking == s.ranking)
		{
			return true;
		}
		return false;
	}
	
	//overridden method
	public String toString()
	{
		return "country: " + country + "\nranking: " + ranking + "\n";
	}
		
}
