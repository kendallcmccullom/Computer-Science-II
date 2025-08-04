package BinarySearchTrees;

//driver program for Vote class 

import java.util.Iterator;

public class Infrastructure
{
	public static void main (String [] args)
	{
		Vote v = new Vote();
		System.out.println("\nSenators present: ");
		String [] senators = {"Rubio", "Buttigieg", "Booker", "Sanders", 
			"Santorum", "Paul", "Bennet"};
		for (int i = 0; i < senators.length; i++)
		{
			System.out.print(senators[i] + " ");
			v.addVote(senators[i]);
		}
		System.out.println();

		System.out.println("\nHere are the votes on the infrastructure " 
			+ "bill:\n");
		Iterator<String> iter = v.iterator();
		while (iter.hasNext())
		{
			String name = iter.next();
			System.out.printf("%-12s %-3s\n",name,v.getVote(name));
		} 

		String change = senators[(int)(Math.random()*senators.length)];
		v.changeVote(change);
		System.out.println("\nSenator " + change + " wants to change "
			+ "his vote:\n");
		iter = v.iterator();
		while (iter.hasNext())
		{
			String name = iter.next();
			System.out.printf("%-12s %-3s\n",name,v.getVote(name));
		} 

		System.out.println("\nOut of " + v.size() + " votes, the number of "
			+ "yes votes is " + Vote.yesVotes());
		System.out.println("The bill " + v.result());	
	}
}
