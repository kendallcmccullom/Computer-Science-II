package Heaps;

//simulates boarding and deplaning a flight

public class EuropeBound
{
	public static void main (String [] args)
	{
		Flight peanutsGang = new Flight();
		String [] travelers = {"Charlie Brown", "Snoopy", "Lucy", "Linus",
			"Franklin", "Peppermint Patty"};
		String [] locations = {"Greenland", "Armenia", "Switzerland", "Spain",
			"Finland", "Malta", "Turkey"};
		String destination = locations[(int)(Math.random() * locations.length)];
		System.out.println("\nFlight 123 is going to " + destination);
		System.out.println("\nNow boarding:");
		for (int i = 0; i < travelers.length; i++)
		{
			int fare = (int)(Math.random() * 100 + 35);
			peanutsGang.boardPlane(new Passenger(travelers[i], fare));
			System.out.printf("%-17s$%d\n", travelers[i], fare);
		}
		System.out.println("\nFlying to Europe... \u2708");
		System.out.println("\nNow deplaning:");
		int onBoard = peanutsGang.numberOfPassengers();
		for (int i = 0; i < onBoard; i++)
		{
			Passenger gotOff = peanutsGang.deplane();
			System.out.printf("%-17s$%d\n", gotOff.getName(),gotOff.getPrice());
		}
	}
}	
