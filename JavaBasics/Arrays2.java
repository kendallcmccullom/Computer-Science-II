package JavaBasics;
/*
 * performs various tasks on an array of strings
 */

public class Arrays2
{
	/*
	 * puts all odd-length words in uppercase
	 */

	public static void oddInUppercase (String [] s)
	{
		for (int i = 0; i< s.length; i++)
		{
			if (s[i].length() % 2 != 0)
			{
				s[i] = s[i].toUpperCase();
			}
		}
	}

	/*
	 * returns an array with the length of each word
	 */

	public static int [] wordLengths (String [] s)
	{
		int [] lengths = new int [s.length];
		for(int i = 0; i<s.length; i++)
		{
			lengths[i] = s[i].length();
		}
		
		return lengths;  // so method will compile until code added
	}

	/*
	 * prints an array of strings
	 */

	public static void printStringArray(String [] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}

		System.out.println();
	}

	/*
	 * prints an array of integers
	 */

	public static void printIntegerArray(int [] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}

		System.out.println();
	}

	public static void main (String [] args)
	{
		String [] words = {"porcupine", "vase", "slippers", "wow", "serene",
			"asphalt", "tuxedo", "cucumber", "bookshelf", "umbrella"};
		System.out.println("Here's our array of words: ");
		printStringArray(words);
		System.out.println("\nHere are the words with all odd-length words in "
				+ "uppercase");
			oddInUppercase(words);
			printStringArray(words);
		System.out.println("\nHere's the length of each word: ");
		printIntegerArray(wordLengths(words));
		
	}
}
