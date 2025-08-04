package Deques;

//simulates a subway train using a deque
//Kendall McCullom

public class Train
{
	public static final int NUMBER_OF_STOPS = 4;

	private Deque<String> train;
	private String direction;
	private int stop;

	public Train()
	{
		train = new ArrayDeque< >();
		direction = "->";
		stop = 0;
	}

	public void enterFront(String [] pass)
	{
		if (pass == null)
		{
			throw new IllegalArgumentException ("use [] if no one getting on");
		}
		
		reverseIfAtEnd();
		for (int i = 0; i<pass.length; i++)
		{
			String p = pass[i];
			if (direction.equals("->"))
			{
				train.addLast(p);
			}
			else
			{
				train.addFirst(p);
			}
		}
		stop++;
	}

	public void enterRear(String [] pass)
	{
		if (pass == null)
		{
			throw new IllegalArgumentException ("use [] if no one getting on");
		}
		reverseIfAtEnd();
		for (int i = 0; i<pass.length; i++)
		{
			String p = pass[i];
			if (direction.equals("->"))
			{
				train.addFirst(p);
			}
			else
			{
				train.addLast(p);
			}
		}
		stop++;
	}

	public String[] exitFront(int n)
	{
		if (n > train.size())
		{
		 	throw new IllegalArgumentException(n + " exceeds number on board!");
		}
		reverseIfAtEnd();
		String [] leaving = new String[n];
		for (int i = 0; i<n; i++)
		{
			if (direction.equals("->"))
			{
				leaving[i] = train.getLast();
				train.removeLast();
			}
			else
			{
				leaving[i] = train.getFirst();
				train.removeFirst();
			}
		}
		stop++;
		return leaving;
	}

	public String[] exitRear(int n)
	{
		if (n > train.size())
		{
		 	throw new IllegalArgumentException(n + " exceeds number on board!");
		}
		reverseIfAtEnd();
		String [] leaving = new String[n];
		for (int i = 0; i<n; i++)
		{
			if (direction.equals("->"))
			{
				leaving[i] = train.getFirst();
				train.removeFirst();
			}
			else
			{
				leaving[i] = train.getLast();
				train.removeLast();
			}
		}
		stop++;
		return leaving;
		// add code
	}

	private void reverseIfAtEnd()
	{
		if (stop == NUMBER_OF_STOPS)
		{
			direction = (direction.equals("->")) ? "<-" : "->";
			stop = 0;
		}
	}

	public String toString()
	{
		return "stop number\t" + stop + "\ndirection\t" + direction +
			"\npassengers\t" + train.size() + "\ntrain\t\t" + train;
	}
}
