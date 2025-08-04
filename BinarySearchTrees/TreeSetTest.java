package BinarySearchTrees;

//test program for TreeSet

import java.util.Iterator;

public class TreeSetTest
{
	public static void main (String [] args)
	{
		Set<String> vegetables = new TreeSet<>();
		
		// add
		String [] v = {"radishes", "kale", "bok choi", "spinach", "turnips", 
			"parsnips", "eggplant"};
		for (int i = 0; i < v.length; i++)
		{
			vegetables.add(v[i]);
		}
		System.out.println("\nHere's what's available at the farmer's market " 
			+ "today:");
		Iterator<String> iter = vegetables.iterator();
		while (iter.hasNext())
		{
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		vegetables.add("kale");
		System.out.println("\nAlso kale- oh, it looks like it's already on "
			+ "the list:");
		iter = vegetables.iterator();
		while (iter.hasNext())
		{
			System.out.print(iter.next() + " ");
		}
		System.out.println();

		// contains
		String result = vegetables.contains("parsnips") ? "yes" : "no";
		System.out.println("\nAre parsnips available? " + result);
		result = vegetables.contains("rhubarb") ? "yes" : "no";
		System.out.println("What about rhubarb? " + result);
	}
}
