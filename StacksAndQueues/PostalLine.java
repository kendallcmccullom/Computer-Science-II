package StacksAndQueues;

//class for a postal line
//Kendall McCullom

import java.util.Iterator;

public class PostalLine
{
	private Queue<Customer> line;
	
	public PostalLine()
	{
		line = new ArrayQueue<>();
	}

	// adds customer to line	
	public void getInLine(Customer c)
	{
		line.addLast(c);
	}

	// removes customer from line, returns their errand
	public String completeErrand()
	{
		Customer c = line.getFirst();
		line.removeFirst();
		String errand = c.getErrand();
		return errand;
	}

	// returns next customer's number
	public int nextCustomer()
	{
		Customer c = line.getFirst();
		int num = c.getNumber();
		return num;
	}

	// returns length of line
	public int inLine()
	{
		int lineNum = line.size();
		return lineNum;
	}

	// returns customers in line along with their errands
	public String toString()
	{
		String s = "";
		Iterator<Customer> iter = line.iterator();

		while (iter.hasNext())
		{
			s+= iter.next();
			if (iter.hasNext()) s+= "\n";
		}

		return s;
	}
}
