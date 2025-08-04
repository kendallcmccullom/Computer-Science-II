package SetsAndMaps;
//driver program for ArrayMap and LinkedMap
//Kendall McCullom

import java.util.Iterator;

public class MapTest
{
	public static void main (String [] args)
	{
		try
		{
			// creating map
			Map<String, Integer> fruits = new ArrayMap<>();
			//Map<String, Integer> fruits = new LinkedMap<>();

			// adding items 
			fruits.add("coconut", 5);
			fruits.add("kiwi", 3);
			fruits.add("orange", 3);
			fruits.add("lime", 1);
			
			// printing items (toString())
			System.out.println("\nHere is the fruit that we currently have:\n" 
				+ fruits);

			// using iterator
			System.out.println("\nLet's print them individually:\n");
			Iterator<String> iter = fruits.iterator();
			while (iter.hasNext())
			{
				String f = iter.next();
				System.out.printf("%-10s%d\n", f, fruits.get(f));
			}
			
			// adding key not in map
			System.out.println("\nWe just bought 2 dragonfruit");
			System.out.println("Before that we had: " 
				+ fruits.add("dragonfruit", 2));
			System.out.println(fruits);

			// adding key already in map (= replacing value)
			System.out.println("\nWe also got 5 more kiwis");
    		System.out.println("We previously had: " + fruits.add("kiwi", 8));
			System.out.println(fruits);

			// replacing value when key not in map (= doesn't get replaced)
			System.out.println("\nOur neighbor bought 3 mangoes");
			System.out.println("This doesn't change the number of mangoes we "
				+ "have: " + fruits.set("mango", 3));
			System.out.println(fruits);

			// replacing value when key in map (= gets replaced)
			fruits.add("mango", 3);
			System.out.println("\nOur neighbor just gave us his mangoes: " 
				+ fruits.set("mango", 5));
			System.out.println("We also bought 2 of our own");
			System.out.println(fruits);

			// searching for key in map
			System.out.println("\nDo we have any coconuts? " + 
				(fruits.contains("coconut") ? "yes" : "no"));
			System.out.println(fruits);

			// searching for key not in map
			System.out.println("\nAre there any persimmons? " +
				(fruits.contains("persimmon") ? "yes" : "no"));
			System.out.println(fruits);

			// getting value for key in map
			System.out.println("\nHow many coconuts are there?\n" 
				+ fruits.get("coconut"));

			// getting value for key not in map
			System.out.println("\nHow many pineapples are there?\n" 
				+ fruits.get("pineapple"));

			// removing pair in map
			//add test code here
			System.out.println("\nSomeone has eaten all the oranges!");
			System.out.println("It's alright, there were only: " + fruits.get("orange"));
			fruits.remove("orange");
			System.out.println(fruits);
			
			// trying to remove pair not in map
			// add test code here 
			System.out.println("\nTrying to remove another orange");
			
			System.out.println(fruits.remove("orange"));

			// trying to add null value
			System.out.println("\nTrying to add dragonfruit (with null value)");
			fruits.add("dragonfruit", null);
		}

		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
