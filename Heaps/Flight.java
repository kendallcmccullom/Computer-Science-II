package Heaps;

//implements a flight of Passengers using a priority queue

public class Flight
{
	private Queue<Passenger> f;

	public Flight()
	{
		f = new PriorityQueue<>();
	}

	public void boardPlane(Passenger p)
	{
		f.addLast(p);
	}

	public Passenger deplane()
	{
		return f.removeFirst();
	}

	public int numberOfPassengers()
	{
		return f.size();
	}
}
