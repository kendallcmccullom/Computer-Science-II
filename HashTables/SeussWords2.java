package HashTables;

//SuessWords2.java
//gets the fifty unique words in Green Eggs and Ham, and saves them in a file
//uses a hash implementation
//Kendall McCullom

import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;

public class SeussWords2
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
			Scanner inFile = new Scanner(new File("greenEggs.txt"));
			PrintWriter outFile = new PrintWriter("words.txt");
			Set<String> words = new HashSet<String>(53);
			
			while (inFile.hasNext())
			{
				String word = inFile.next();
				word = removePunctuation(word);
				word = word.toLowerCase();
				words.add(word);
			}
			
			Iterator<String> iter = words.iterator();
			outFile.println("Here are all the words in Dr.Suess' Green Eggs and Ham:\n");
			while (iter.hasNext())
			{
				outFile.println(iter.next());	
			}	
			inFile.close();
			outFile.close();
			System.out.println(words);
			// change to hash set with 53 buckets
		}

		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
