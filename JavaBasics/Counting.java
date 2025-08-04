package JavaBasics;
/*
 * counts the number of occurrences of a symbol in a sequence of characters
 *
 * sample ouput:
 *
 *    Sequence: @!#@@$%@!#
 *    Symbol: @
 *    The symbol @ occurs 4 times in the sequence @!#@@$%@!#
 */

import java.util.Scanner;

public class Counting
{
	//returns the number of times the symbol occurs in the sequence
	public static int countOccurrences(String s, char c)
	{
		int count = 0; 
		for (int i = 0; i<s.length(); i++)
		{
			if (s.charAt(i) == c)
			{
				count++;
			}
		}
		return count;
	}

	public static void main (String [] args)
	{
		Scanner input = new Scanner (System.in);
		System.out.print("Enter a sentence: ");
		String sentence = input.nextLine();
		System.out.print("Enter a character you want to count: ");
		char character = input.next().charAt(0);
		System.out.println("Tht symbol occurs " + countOccurrences(sentence, character) + " times in that sequence.");
		input.close();
	}
}
