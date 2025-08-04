package HashTables;

//driver program for testing HashSet

import java.util.Iterator;

public class HashSetTest
{
	public static void main (String [] args)
	{
		Set<Integer> letters = new HashSet< >();

		// adding to set
		Integer [] toAdd = {700,50,73,76,85,92,101};//{'C', 'b', 'c', 'Q', 'z', 'D', 'E', 'P', 'j', 'F',
			//'E', 'I', 'y', 'f', 'i', 'U', 'V', 'm', 'e', 'W'};

		for (int i = 0; i < toAdd.length; i++)
		{
			letters.add(toAdd[i]);
		}
		
		// printing set
		//System.out.println("\nThe set of letters:");
//		Iterator iter = letters.iterator();
//		System.out.print("[");
//		while (iter.hasNext())
//		{
//			System.out.print(iter.next() + (iter.hasNext() ? ", " : "]\n"));
//		}
//
//		// printing internal representation of set
		System.out.println("\nHow they're stored:\n\n" + letters); 

		// searching for items
//		System.out.println("Does the set contain 'e'? " +
//			(letters.contains('e') ? "yes" : "no"));
//		System.out.println("Does the set contain 'a'? " +
//			(letters.contains('a') ? "yes" : "no"));
//
//		// removing items from only, first, middle, last position, and non-item
//		System.out.println("After removing e, P, i, D, and i:\n");
//		letters.remove('e');
//		letters.remove('P');
//		letters.remove('i');
//		letters.remove('D');
//		letters.remove('i');
//		System.out.println(letters);
	}
	
	
}
