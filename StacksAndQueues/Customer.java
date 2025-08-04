package StacksAndQueues;

//class for a postal customer

public class Customer
{
	private static int customerNumber = 1;
	private static String [] errands = {"buying stamps", "mailing a package", 
		"taking a passport photo", "picking up a registered letter",
		"getting a shipping box", "mailing letters"};

	private int number;
	private String errand;

	public Customer()
	{	
		number = customerNumber++;
	}

	public void setErrand(String e)
	{
		errand = e;
	}

	public String getErrand()
	{
		return errand;
	}

	public int getNumber()
	{
		return number;
	}

	public String randomErrand()
	{
		return errands[(int)(Math.random()*errands.length)];
	}

	public String toString()
	{			
		return "Customer " + number + " is " + errand;
	}
}
