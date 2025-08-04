package Heaps;

//implements a passenger class
//passengers are compared by price paid for a ticket
//Kendall McCullom

public class Passenger implements Comparable<Passenger>
{
	private String name;
	private int price;

	public Passenger(String n, int p)
	{
		name = n;
		price = p;
	}

	public String getName()
	{
		return name;
	}

	public int getPrice()
	{
		return price;
	}

	// to be implemented
	public int compareTo(Passenger p)
	{
		if (price == p.price)
		{
			return 0;
		}
		if (price< p.price)
		{
			return -1;
		}
		return 1;
	}
}
