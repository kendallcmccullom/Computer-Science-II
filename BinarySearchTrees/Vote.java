package BinarySearchTrees;

//simulates a vote in Congress
//Kendall McCullom

import java.util.Iterator;

public class Vote
{
	private static int yesVotes = 0;

	private Map<String, String> votes;

	public Vote()
	{
		votes = new TreeMap<>();
	}

	// get random vote
	// if yes vote, adjust counter
	// add senator and vote
	public void addVote(String s)
	{
		String value = randomVote();
		if(value.equals("yes"))
		{
			yesVotes++;
		}
		votes.add(s, value);
	}

	// get senator's vote
	// switch it
	// adjust yes vote counter accordingly
	// return original vote
	public String changeVote(String s)
	{
		String value = votes.get(s);
		
		if (value.equals("no"))
		{
			votes.set(s, "yes");
			yesVotes++;
			
		}
		else
		{
			votes.set(s, "no");
			yesVotes--;
		}
		return value;
	}

	// return random yes or no vote
	public String randomVote()
	{
		int rand = (int)(Math.random()*2);
		if (rand == 0)
		{
			return "no";
		}
		return "yes"; 
	}

	public String getVote(String s)
	{
		return votes.get(s);
	}

	public String toString()
	{
		return votes.toString();
	}

	public int size()
	{
		return votes.size();
	}

	public Iterator<String> iterator()
	{
		return votes.iterator();
	}

	public static int yesVotes()
	{
		return yesVotes;
	}

	public String result()
	{
		return yesVotes*1./size() > .5 ? "passes" : "is not passed";
	}
}
