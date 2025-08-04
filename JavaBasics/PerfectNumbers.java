package JavaBasics;
import java.util.Scanner;

//finds all the perfect numbers with a specified range
//Kendall McCullom

public class PerfectNumbers 
{
	// returns true if number is perfect
	public static boolean isPerfect(int n)
	{
		int sum = 0;
		for (int i = 1; i <= n / 2 + 1; i++) 
		{
			if (n % i == 0) 
			{
				sum += i;
			}
		}
		if (sum == n) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}

	// prints all perfect numbers within specified range
	public static void printPerfectNumbers(int start, int end)
	{
		for (int i = start; i <= end; i++) 
		{
			if (isPerfect(i) && i != 1) 
			{
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a start range: ");
		int start = input.nextInt();
		System.out.print("Enter a start range: ");
		int end = input.nextInt();
		System.out.println("The perfect numbers between " + start + " and " + end + " are:");
		printPerfectNumbers(start, end);
		input.close();
	}
}
