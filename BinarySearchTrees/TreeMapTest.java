package BinarySearchTrees;

//test program for TreeMap

import java.util.Iterator;

public class TreeMapTest
{
	public static void main (String [] args)
	{
		Map<String, Integer> participants = new TreeMap< >();
		
		// add
		String [] states = {"MA", "ME", "NH", "VT", "CT", "RI"};
		int [] numbers = {16, 11, 12, 22, 14, 19};
		for (int i = 0; i < states.length; i++)
		{
			participants.add(states[i], numbers[i]);
		}
		System.out.println("\nA regional swim meet is being held");
		System.out.println("Here's how many participants there are from each "
			+ "state:\n");
		Iterator<String> iter = participants.iterator();
		while (iter.hasNext())
		{
			String state = iter.next();
			System.out.print(state + " " + participants.get(state) + "  ");
		}
		System.out.println();

		// set
		String state = "MA";
		System.out.println("\nAnother swimmer from " + state + 
			" just qualified");
		Integer n = participants.get(state);
		if (n!= null) participants.set(state, n+1);
		System.out.println("The previous number from that state was: " + n 
			+ "\n");
		iter = participants.iterator();
		while (iter.hasNext())
		{
			state = iter.next();
			System.out.print(state + " " + participants.get(state) + "  ");
		}
		System.out.println();

		state = "AZ";
		System.out.println("\nSomeone from " + state + " just signed up, "
			+ "but that's for a different competition");
		n = participants.get(state);
		if (n!= null) participants.set(state, n+1);
		System.out.println("The previous number from that state was: " + n 
			+ "\n");
		iter = participants.iterator();
		while (iter.hasNext())
		{
			state = iter.next();
			System.out.print(state + " " + participants.get(state) + "  ");
		}
		System.out.println();

		// contains
		String result = participants.contains("MA") ? "yes" : "no";
		System.out.println("\nIs MA in the competition? " + result);
		result = result.contains("NY") ? "yes" : "no";
		System.out.println("Is NY in the competition? " + result);

		// get
		state = "VT";
		System.out.println("\nHow many competitors are there from " + state
			+ "? " + participants.get(state));
		state = "WV";
		System.out.println("How many competitors are there from " + state
			+ "? " + participants.get(state));
	}
}
