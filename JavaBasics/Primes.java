package JavaBasics;
import java.util.Scanner;
/*
 * CSCI 1102 Spring 2022
 *
 * Primes.java
 *
 * determines the number of prime numbers that occur within a particular range
 *
 * (requires debugging first)
 */

public class Primes
{
 	//returns true if number is prime
	public static boolean isPrime(int n)
	{
		if (n == 0 || n == 1)
		{
			return false;
		}

		for (int i = 2; i < n; i++)
		{
			if (n % i == 0)
			{
				return false;
			}
		}
		return true;
	}

	// returns the number of prime numbers that occur between a start
 	//(inclusive) and end (exclusive) value
	public static int countThePrimes(int s, int e)
	{
		int count = 0;

		for (int i = s; i < e; i++)
		{
			if (isPrime(i))
			{
				count++;
			}
		}

		return count;
	}

	public static void main (String [] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter start value: ");
		int start = input.nextInt();
		System.out.print("Enter end value: ");
		int end = input.nextInt();
		int number = countThePrimes(start, end);
		System.out.println("The number of primes between " + start + " and "
			+ end + " is " + number);
		input.close();
	}
}
