package Deques;

//driver program for Train class

public class GreenLine 
{
	//prints contents of arraay
   	//used to print names of passengers who got off
	public static void printItems(String [] pass)
	{
		for (int i = 0; i < pass.length; i++)
		{
			System.out.print(pass[i] + " ");
		}

		System.out.println("\n");
	}

	public static void main (String [] args)
	{
		try
		{
			Train BC = new Train();

			String [] people = {"Harriet", "Oliver", "Larry"};
			System.out.println("\n" + people.length + " entering at front\n");
			BC.enterFront(people);
			System.out.println(BC);

			people = new String [] {"Jason"};
			System.out.println("\n" + people.length + " entering at rear\n");
			BC.enterRear(people);
			System.out.println(BC);

			people = new String [] {"Tom"};
			System.out.println("\n" + people.length + " entering at front\n");
			BC.enterFront(people);
			System.out.println(BC);

			people = new String [0];
			System.out.println("\n" + people.length + " entering at front\n");
			BC.enterRear(people);
			System.out.println(BC);

			int number = 2;
			System.out.println("\n" + number + " exiting at front");
			printItems(BC.exitFront(number));
			System.out.println(BC);

			number = 1;
			System.out.println("\n" + number + " exiting at rear");
			printItems(BC.exitRear(number));
			System.out.println(BC);

			people = new String [] {"Sam", "Nina"};
			System.out.println("\n" + people.length + " entering at rear\n");
			BC.enterRear(people);
			System.out.println(BC);

			people = new String [] {"Ted"};
			System.out.println("\n" + people.length + " entering at front\n");
			BC.enterFront(people);
			System.out.println(BC);

			number = 3;
			System.out.println("\n" + number + " exiting at front\n");
			printItems(BC.exitFront(number));
			System.out.println(BC);

			number = 2;
			System.out.println("\n" + number + " exiting at rear");
			printItems(BC.exitRear(number));
			System.out.println(BC);

			people = new String [0];
			System.out.println("\n" + people.length + " entering at rear");
			BC.enterRear(people);
			System.out.println(BC);

			number = 1;
			System.out.println("\n" + number + " exiting at front\n");
			printItems(BC.exitFront(number));
			System.out.println(BC);
		}

		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
	}	
}
