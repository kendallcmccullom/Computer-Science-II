package HashTables;

// driver program for testing HashMap

import java.util.Iterator;

public class HashMapTest
{
	public static void main (String [] args)
	{
		try
		{
			Map<String, Integer> desserts = new HashMap<String, Integer>(5);

			// adding to set
			desserts.add("cakes", 5);
			desserts.add("cookies", 42);
			desserts.add("pies", 7);
			desserts.add("cupcakes", 36);
			desserts.add("fruits", 11);

			// printing set
			System.out.println("\nHere are the desserts:");
			Iterator<String> iter = desserts.iterator();
			System.out.print("{");
			while (iter.hasNext())
			{
				String name = iter.next();
				System.out.print(name + "=" + desserts.get(name)
					+ (iter.hasNext() ? ", " : "}\n"));
			}

			// printing internal representation of set
			System.out.println("\nHere's how they're stored:\n\n" + desserts); 

			// removing middle pair
			System.out.println("The pies have all been eaten");
			System.out.println("There were " + desserts.remove("pies") 
				+ "\n");
			System.out.println(desserts);

			// removing last pair
			System.out.println("So have the cookies\n");
			desserts.remove("cookies");
			System.out.println(desserts);

			// removing first pair
			System.out.println("The fruits too\n");
			desserts.remove("fruits");
			System.out.println(desserts);

			// removing only pair
			System.out.println("Even the cupcakes and cakes\n");
			desserts.remove("cupcakes");
			desserts.remove("cakes");
			System.out.println(desserts);

			// trying to remove pair that isn't in map
			System.out.println("Trying to remove fruits again");
			System.out.println(desserts.remove("fruits"));
		}

		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
