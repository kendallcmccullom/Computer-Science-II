package BinarySearchTrees;

//SuessWords3.java
//gets the fifty unique words in Green Eggs and Ham, and saves them in a file
//uses a tree implementation
//Kendall McCullom

import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;

public class SeussWords3
{
	public static String removePunctuation (String s)
	{
		for (int k = 0; k<s.length(); k++)
		{
			if (s.charAt(k) == '!' || s.charAt(k) == ',' || s.charAt(k) == '?' ||s.charAt(k) == '.')
			{
				s = s.substring(0, k);
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
			Set<String> words = new TreeSet<String>();
			
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
		}

		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
}

