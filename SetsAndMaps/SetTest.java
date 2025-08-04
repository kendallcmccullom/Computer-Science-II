package SetsAndMaps;
//SetTest.java
//program for testing add method in ArraySet and LinkedSet
//Kendall McCullom

public class SetTest
{
	public static void main (String [] args)
	{
		try
		{
			//Set<String> fruits = new ArraySet<String>();
			Set<String> fruits = new LinkedSet<String>();
			
			// adding to set
			String [] f = {"orange", "grape", "kiwi", "coconut", "lime"};
			for (int i = 0; i < f.length; i++)
			{
				fruits.add(f[i]);
			}
			
			// printing collection (using toString())
			System.out.println("\nHere's what's in our bag:\n" + fruits);
			
			System.out.println("\nLet's try to add another coconut\n" + fruits.add("coconut"));
			System.out.println(fruits);
			
			System.out.println("\nLet's try to add a banana\n" + fruits.add("banana"));
			System.out.println(fruits);
			
		}

		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
