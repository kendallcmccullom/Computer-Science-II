package JavaBasics;
// Bulls and Cows
// Kendall McCullom
// implements a deductive logic game for guessing a sequence of n unique digits

import java.util.Scanner;

public class BullsAndCows
{
	public static final int DIGITS = 4;
	public static final int TURNS = 10;

	//explains how the game works
	public static void printRules()
	{
		System.out.println("Guess the " + DIGITS + " digit number; " +
			"all digits are unique.");
		System.out.println("A cow means right digit, wrong position.");
		System.out.println("A bull means right digit, right position.");
		System.out.println("You have " + TURNS + " turns.");
		System.out.println("Enter 'q' to quit at any time.");
		System.out.println("Good luck!\n");
	}

	//returns true if the character is contained in the string
	public static boolean contains(String s, char c)
	{
		for (int i = 0; i<s.length(); i++)
		{
			if (s.charAt(i)==c)
			{
				return true;
			}
		}
		return false;
	}

	//returns a string of unique randomly-chosen digits
	public static String pickNumber()
	{
		String randNum = "";
		while (true)
		{
			int num = (int) (Math.random()* TURNS);
			char b = (char)(num + '0');
			if(!contains(randNum, b))
			{
				randNum+=num;
			}
			if (randNum.length() == DIGITS)
			{
				break;
			}
		}
		return randNum;
	}

	// compares the user's guess to the random sequence and returns the number of bulls and cows
	public static int [] tallyResults (String number, String guess)
	{
		int bulls = 0;
		int cows = 0;
		for (int i = 0; i<DIGITS; i++)
		{
			for (int k = 0; k<DIGITS; k++)
			{
				if (number.charAt(i) == guess.charAt(k) && i == k)
				{
					bulls++;
				}
				else if (number.charAt(i) == guess.charAt(k) && i != k)
				{
					cows ++;
				}
			}
		}
		int [] candb = {bulls, cows};
		return candb;
	}

	// returns true if the string contains a duplicate character
	public static boolean hasDuplicates (String s)
	{
		for (int i=0; i<DIGITS; i++)
		{
			for (int k = i+1; k<DIGITS; k++)
			{
				if (s.charAt(i)==s.charAt(k))
				{
					return true;
				}
			}
		}
		return false;
	}

	// returns true if the string contains a non-digit
	public static boolean hasNonDigits (String s)
	{
		for (int i = 0; i<DIGITS; i++)
		{
			if (s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3' || s.charAt(i) == '4'|| s.charAt(i) == '5'|| s.charAt(i) == '6'|| s.charAt(i) == '7'|| s.charAt(i) == '8'|| s.charAt(i) == '9'|| s.charAt(i) == '0')
			{
				continue;
			}
			else
			{
				return true;
			}
		}
		return false;
	}

	// gets the user's guess and displays the bulls and cows until game over
	public static void playGame()
	{
		Scanner input = new Scanner(System.in);
		String computer = pickNumber();
		int count = 1;
		int k = 0;
		while (true)
		{
			if (count > k)
			{
				System.out.println("Turn " + count);
				k = count;
			}
			
			System.out.print("Enter a " + DIGITS + " digit number: ");
			String guess = input.nextLine();
			
			if (guess.equals("q"))
			{
				System.out.println("The number was: " +  computer);
				break;
			}
			else if (guess.length() < DIGITS || hasNonDigits(guess) || guess.length() > DIGITS|| hasDuplicates(guess))
			{
				System.out.println("Must contain " + DIGITS + " unique digits");
				continue;
			}
			else
			{
				count++;
				int results [] = tallyResults(computer, guess);
				System.out.println(results [0] + " bulls, " + results [1] + " cows\n");
				if (results[0] == DIGITS)
				{
					System.out.println("You guessed it! The number was " + computer);
					break;
				}
				if (count > TURNS)
				{
					System.out.println("You've run out of turns, the number was " + computer);
					break;
				}
			}
		}
		input.close();
	}

	public static void main (String [] args)
	{
		printRules();
		playGame();
	}
}
