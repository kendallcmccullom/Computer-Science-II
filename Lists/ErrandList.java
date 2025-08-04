package Lists;

//driver program for Organizer

public class ErrandList
{
	public static void main (String [] args)
	{
		try
		{
			// creates Organizer object
			Organizer o = new Organizer();

			// adds items to list
			o.addTask("buy eggs");
			o.addTask("return library book");
			o.addTask("go to laundromat");
			o.addTask("pick up dry cleaning");
			o.addTask("buy milk");

			// prints number of errands to do
			System.out.println("\nWe have " + o.tasks() + " errands to do");

			// prints list of errands
			System.out.println("Here's our list of errands:\n\n" + o);

			// switches items on list
			System.out.println("It's more efficient to buy all the groceries "
				+ "together");
			System.out.println("Let's switch the milk and book errands:\n");
			o.switchTasks("buy milk", "return library book");
			System.out.println(o);

			// adds item to specified location on list
			System.out.println("Let's also buy some bread while we're at "
				+ "the store:\n");
			o.insertTask(2, "buy bread");
			System.out.println(o);

			// removes item from list
			System.out.println("There isn't enough laundry to do, so we'll "
				+ "take it off the list\n");
			o.removeTask("go to laundromat");
			System.out.println(o);

			// tries to remove item not on list
			System.out.println("Trying to remove errand: buy butter");
			if (!o.removeTask("buy butter"))
			{
				System.out.println("Item not on to-do list!\n");
			}
			System.out.println(o);

			// tries to switch items when on list
			System.out.println("Trying to switch errands: go to laundromat and "
				+ "pick up dry cleaning");
			if (!o.switchTasks("go to laundromat", "pick up dry cleaning"))
			{
				System.out.println("One or both items not on to-do list!\n");
			}
			System.out.println(o);

			// trying to add beyond size of list
			System.out.println("Trying to insert ice cream as errand 12 ");
			o.insertTask(12, "buy ice cream");
		}

		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
