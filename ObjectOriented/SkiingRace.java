package ObjectOriented;

// test program for Skier
// Kendall McCullom

public class SkiingRace
{
	//simulates a race, with higher-ranked competitors having the advantage
	//but a low-ranked competitor occasionally able to win

	public static Skier runCompetition(Skier [] c)
	{
		int [] results = new int[c.length];
		for (int i = 0; i < c.length; i++)
		{
			int ranking = c[i].getRanking();
			int handicap = ranking > 8 ? 3 : ranking > 4 ? 2 : 1;
			int wildcard = (int)(Math.random()*10);
			if (wildcard == 9)
			{
				if (ranking > 8) handicap -=2;
				else if (ranking > 4) handicap -=1;
			}
			c[i].setFinished(((int)(Math.random()*2)) + handicap);
			results[i] = c[i].getFinished();
		}
		Skier winner = c[0];
		int placed = results[0];
		for (int i = 1; i < results.length; i++)
		{	
			int newPlaced = results[i];
			int choice = (newPlaced == placed) ? (int)(Math.random()*2) : 0;
			if (choice == 1 || newPlaced < placed)
			{
				winner = c[i];
				placed = newPlaced;
			}
		}	
		return winner;
	}

	public static void main (String [] args)
	{
		// create some skiers for the competition (constructor) 

		Skier one = new Skier ("Switzerland", 1);
		Skier two = new Skier ("USA", 3);
		Skier three = new Skier ("Jamaica", 2);
		Skier four = new Skier ("Italy", 5);
		Skier five = new Skier ("France", 5);
		Skier six = new Skier ("China", 10);
		Skier seven = new Skier ("Norway", 4);
		Skier eight = new Skier ("USA", 11);
		Skier nine = new Skier ("Russia", 7);
		Skier ten = new Skier ("Norway", 9);
		Skier eleven = new Skier ("Switzerland", 12);
		Skier twelve = new Skier ("Canada", 8);
		
		Skier [] competitors = {one, two, three, four, five, six, 
			seven, eight, nine, ten, eleven, twelve};

		// get number of skiers (static method)
		System.out.println("\nThere are " + Skier.numberOfSkiers() 
			+ " skiers in the competition:\n");

		// print their countries and rankings (toString())
		for (int i = 0; i < competitors.length; i++)
		{
			System.out.println(competitors[i].getClass().getName() + " " 
				+ (i+1) + "\n" + competitors[i].toString());
		}

		// compare rankings (instance method)
		System.out.println("Do skiers 4 and 5 have the same ranking? " +
			(four.hasSameRanking(five) ? "yes" : "no"));
		System.out.println("Do skiers 2 and 11 have the same ranking? " +
			(two.hasSameRanking(eleven) ? "yes" : "no"));

		// get and change properties (getters and setters)
		System.out.println("\nWhere is skier 3 from? " + three.getCountry());
		System.out.println("Skier 3 is actually from Canada, so let's "
			+ "change that");
		three.setCountry("Canada");
		System.out.println("country: " + three.getCountry());
		System.out.println("\nWhat is skier 5's ranking? " 
			+ five.getRanking());
		System.out.println("Skier 5's ranking should be 6, which is easily "
			+ "fixed");
		five.setRanking(6);			
		System.out.println("ranking: " + five.getRanking());

		// run race 
		String [] events = {"Downhill", "Slalom", "Giant Slalom", 
			"Alpine Combined", "Super-G"};
		System.out.println("\nFirst Run");
		System.out.printf("%-20s%-13s%s\n", "EVENT", "COUNTRY", "RANKING");
		for (int i = 0; i < 5; i++)
		{
			Skier winner = runCompetition(competitors);
			System.out.printf("%-20s%-13s%2d\n", events[i], 
				winner.getCountry(), winner.getRanking());
		}
		System.out.println("\nSecond Run");
		System.out.printf("%-20s%-13s%s\n", "EVENT", "COUNTRY", "RANKING");
		for (int i = 0; i < 5; i++)
		{
			Skier winner = runCompetition(competitors);
			System.out.printf("%-20s%-13s%2d\n", events[i], 
				winner.getCountry(), winner.getRanking());
		}
	}
}
