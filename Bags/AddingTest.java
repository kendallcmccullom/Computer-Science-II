package Bags;
//program for testing discussion section problems

public class AddingTest
{
	public static void main (String [] args)
	{
		// creates bag and add items to it
		Bag<String> jumpsuits = new ArrayBag<>();
		//Bag<String> jumpsuits = new LinkedBag<>();
		String [] outfits = {"plaid", "striped", "plaid", "polka dotted",
			"plain"};
		for (int i = 0; i < outfits.length; i++)
		{
			jumpsuits.add(outfits[i]);
		}

		// tests doubleTheFun()
		System.out.println("\nHere are Galaxer !@!#z's jumpsuits:\n"
			+ jumpsuits);
		System.out.println("\nAn additional " + jumpsuits.doubleTheFun("plaid")
			+ " plaid jumpsuits were added to the collection:");
		System.out.println(jumpsuits);

		// tests addToGalaxianSet()
		System.out.println("\nCan they add a plaid one? " +
			(jumpsuits.addToGalaxianSet("plaid") ? " yes" : " no"));
		System.out.println(jumpsuits);
		System.out.println("\nCan they add a tie-dyed one? " +
			(jumpsuits.addToGalaxianSet("tie-dyed") ? " yes" : " no"));
		System.out.println(jumpsuits);
		System.out.println("\nSince this is Galaxian set...");
		System.out.println("\nCan they add a striped one? " +
			(jumpsuits.addToGalaxianSet("striped") ? " yes" : " no"));
		System.out.println(jumpsuits);
	}
}
