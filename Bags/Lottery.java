package Bags;
///simulates a lottery using a bag to store the entries
//Kendall McCullom

import java.util.Iterator;

public class Lottery
{
	private Bag<String> entries;

	public Lottery()
	{
		entries = new ArrayBag<>();
	}

	//adds an entrant's name to the bag 
	public void addEntry(String name)
	{
		entries.add(name);
	}

	//picks a random winner 
	public String pickWinner()
	{
		String winner = entries.getRandom();
		return winner;
	}

	//returns the number of lottery entries 
	public int numberOfEntries()
	{
		int entSize = entries.size();
		return entSize;
	}

	//returns a string of the names of the entrants
	public String raffleTicketHolders()
	{
		String list = (entries.toString());
		return list;
	}

	//returns an iterator for traversing the entries
	public Iterator<String> iterator()
	{
		Iterator<String> iter = entries.iterator();
		return iter;
	}
}
