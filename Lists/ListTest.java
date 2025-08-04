package Lists;

//test program for lists

public class ListTest
{
	public static void main (String [] args)
	{
		try
		{
		//	List<String> animals = new ArrayList<String>();
			List<String> animals = new LinkedList<String>();

			System.out.println("\nhere's what's in our zoo:");
			animals.add("ostrich");
			animals.add("yak");
			animals.add("peacock");
			animals.add("hedgehog");
			animals.add("snail");
			System.out.println(animals);

			// removing by item
    		System.out.println("\nremoving specific item ('yak')");
			animals.remove("yak");
			System.out.println(animals);

			// removing by index
    		System.out.println("\nremoving last item");
			System.out.println("removed: " + animals.remove(animals.size()-1));
			System.out.println(animals);

    		System.out.println("\nremoving first item");
			System.out.println("removed: " + animals.remove(0));
			System.out.println(animals);

    		System.out.println("\nremoving second item");
			System.out.println("removed: " + animals.remove(1));
			System.out.println(animals);

    		System.out.println("\nremoving only item");
			System.out.println("removed: " + animals.remove(0));
			System.out.println(animals);

			// item not in list
    		System.out.println("\ntrying to remove from empty list ('emu')");
			System.out.println("was it removed? " +
				((animals.remove("emu"))? "yes" : "no"));
    		System.out.println(animals);

			System.out.println("\na kangaroo has joined the group");
			animals.add("kangaroo");
			System.out.println(animals);

			// removing item from list of size 1
    		System.out.println("\ntrying to remove only item ('kangaroo')");
			System.out.println("was it removed? " +
			  ((animals.remove("kangaroo"))? "yes" : "no"));
    		System.out.println(animals);

			// index out of range
   			System.out.println("\ntrying to remove at index outside list");
			animals.remove(-1);
		}

		catch (IndexOutOfBoundsException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
