package Bags;
//test program for Lottery class

import java.util.Iterator;

public class PeanutsLottery
{
	public static void main (String [] args)
	{
		Lottery potOfGold = new Lottery();
		String [] names = {"Sally", "CharlieBrown", "Lucy", "Snoopy",
			"Linus", "PeppermintPatty", "Schroeder", "Woodstock"};
		for (String n: names)
		{
			potOfGold.addEntry(n);
		}

		System.out.println("\nBuy a raffle ticket to win a pot of gold!");
		System.out.println("There are " + potOfGold.numberOfEntries() 
			+ " entries thus far:");
		System.out.println(potOfGold.raffleTicketHolders());
		System.out.println("\nIt seems that a few entrants want to buy some"
			+ " additional raffle tickets:\n");
		
		for (String n: names)
		{
			int random = (int)(Math.random()*3);
			if (random != 0)
			{
				System.out.println(n + " is buying " + random + 
					" additional ticket" + (random == 1 ? "" : "s"));
			}
 
			for (int i = 0; i < random; i++)
			{
				potOfGold.addEntry(n);
			}
		}	

		System.out.println("\nThere are now " + potOfGold.numberOfEntries() 
			+ " entries!");
		System.out.println("Let's put all the names in a bag:\n");

		Iterator<String> iter = potOfGold.iterator();
		while (iter.hasNext())
		{
			System.out.println(iter.next() + " ");
		}

		System.out.println("\nShaking the bag....");
		System.out.println("\nAnd the lucky winner is " 
			+ potOfGold.pickWinner()+ "!!!\n"); 
	}
}
