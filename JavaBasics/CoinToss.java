package JavaBasics;
import java.util.Scanner;

 //CSCI 1102 Spring 2022
 //simulates tossing a coin
 //illustrates creating and returning arrays, and using their cells as counters
 //(requires debugging first)

public class CoinToss
{
	public static int [] tossCoin (int n)
	{
		int [] tallies = new int [2];

		for (int i = 0; i < n; i++)
		{
			int toss = (int) (Math.random()* 2);
			if (toss == 0)
			{
				tallies[0]++;
			}
			else
			{
				tallies[1]++;
			}
		}
		return tallies;
	}

	public static void main (String [] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("How many times would you like to flip the coin? ");
		int number = input.nextInt();
		int [] counts = tossCoin(number);
		System.out.println("heads " + counts[0]);
		System.out.println("tails " + counts[1]);
		input.close();
	}
}
