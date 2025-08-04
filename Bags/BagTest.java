package Bags;
// BagTest.java
//program for testing methods in ArrayBag and LinkedBag

import java.util.Iterator;

public class BagTest
{
	public static void main (String [] args)
	{
		try
		{
			// comment out the implementation not being tested 	
		//	Bag<String> fruits = new ArrayBag<String>();
			Bag<String> fruits = new LinkedBag<String>();

			// adding to bag
			String [] f = {"orange", "grape", "kiwi", "coconut", "lime"};
			for (int i = 0; i < f.length; i++)
			{
				fruits.add(f[i]);
			}
			// printing collection (using toString())
			System.out.println("\nHere's what's in our bag\n" + fruits);

			// printing contents individually (using an iterator)
			System.out.println("\nLet's take out each fruit one at a time\n");
			
			Iterator<String> iter = fruits.iterator();
			while (iter.hasNext())
			{
				System.out.println(iter.next());
			}

			// seeing if bag contains item
			boolean result = fruits.contains("kiwi");
			System.out.println("\nDoes our bag contain a kiwi? " +
				(result ? "yes" : "no"));
			result = fruits.contains("mango");
			System.out.println("Does our bag contain a mango? " +
				(result ? "yes" : "no"));

			// getting random items
			System.out.println("\nSelecting two random items (varies)");
			System.out.println(fruits.getRandom());
			System.out.println(fruits.getRandom());

			// removing specific items
			System.out.println("\nRemoving kiwi from the bag");
			fruits.remove("kiwi");
			System.out.println(fruits);
			System.out.println("\nRemoving orange from the bag");
			fruits.remove("orange");
			System.out.println(fruits);
			System.out.println("\nRemoving lime from the bag");
			fruits.remove("lime");
			System.out.println(fruits);
			System.out.println("\nLet's empty the bag");
			fruits.remove("grape");
			fruits.remove("coconut");
			System.out.println(fruits);

			// getting item from empty bag
			System.out.println("\nTrying to get a random item\n" +
				fruits.getRandom());

			// removing specific item from empty bag
			System.out.println("\nTrying to remove kiwi\n" +
				fruits.remove("kiwi"));

			System.out.println("\nAdding the items back in");
			for (int i = 0; i < f.length; i++)
			{
				fruits.add(f[i]);
			}
			System.out.println(fruits);

			// code for testing your method 
			// removing random items
			System.out.println("\nRemoving three random items");
			for (int i = 0; i < 3; i++)
			{
				System.out.println("removed: " + fruits.removeRandom());
				System.out.println(fruits + "\n");
			}

			// removing random item from empty bag
			System.out.println("Let's empty the bag");
			int size = fruits.size();
			for (int i = 0; i < size; i++)
			{
				fruits.removeRandom();
			}
			
			System.out.println(fruits);
			
			System.out.println("\nTrying to remove a random item\n" +
				fruits.removeRandom());
		}

		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
