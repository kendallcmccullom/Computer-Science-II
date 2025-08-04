package StacksAndQueues;

//simulates a line at a post office

public class PostOffice
{
	public static final int NUMBER_OF_LINES = 2;
	public static final int MAXIMUM_LINE_SIZE = 5;

	public static void main (String [] args)
	{
		PostalLine pl = new PostalLine();

		for (int i = 0; i < NUMBER_OF_LINES; i++)
		{
			int lineSize = (int)(Math.random()*MAXIMUM_LINE_SIZE+1);
			String has = lineSize == 1 ? " has " : "s have ";
  			System.out.println("\n" + lineSize + " customer" + has 
				+ "gotten in line");
	
			for (int j = 0; j < lineSize; j++)
			{
				Customer c = new Customer();
				c.setErrand(c.randomErrand());
				if (i != 0) System.out.println(c);
				pl.getInLine(c);
			}		
	
			System.out.println("\nNow in line: " + pl.inLine());
			System.out.println(pl);

			int errandsCompleted = (int)(Math.random()*pl.inLine()+1);
			String is = errandsCompleted == 1 ? " is " : "s are ";
			System.out.println("\n" + errandsCompleted + " customer" + is 
				+ "moving through the line ");

			for (int j = 0; j < errandsCompleted; j++)
			{
				System.out.println("Customer " + pl.nextCustomer() 
					+ " finished " + pl.completeErrand()); 			
			}

			System.out.println("\nNow in line: " + pl.inLine());
			System.out.println(pl);
		}
	}
}	
