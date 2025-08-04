package HashTables;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

//Spell.java
//implements a spell checker
//Kendall McCullom

public class Spell
{
	public static String removePunctuation (String s)
	{
		for (int k = 0; k<s.length(); k++)
		{
			//if there is a punctuation point in the word
			if (s.charAt(k) == '!' || s.charAt(k) == ',' || s.charAt(k) == '?' ||s.charAt(k) == '.')
			{
				s = s.substring(0, k); //make a substring of the word that ends before punctuation
			}
		}
		return s;
	}

	public static void main (String [] args)
	{
		try
		{
			Set<String> words = new HashSet<String>(143093);
			Scanner inFile1 = new Scanner(new File("dictionary.txt"));
			
			while (inFile1.hasNext())
			{
				String word = inFile1.next();
				word = removePunctuation(word);
				word = word.toLowerCase();
				words.add(word);
			}
			
			Scanner inFile2 = new Scanner(new File("test.txt"));
			PrintWriter outFile = new PrintWriter("misspelled.txt");
			
			while(inFile2.hasNext())
			{
				String word2 = inFile2.next();
				word2 = removePunctuation(word2);
				word2 = word2.toLowerCase();
				if (words.contains(word2))
				{
					continue;
				}
				else
				{
					System.out.println(word2);
					outFile.println(word2);
				}
			}
			inFile1.close();
			inFile2.close();
			outFile.close();
			// to be implemented
		}

		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
