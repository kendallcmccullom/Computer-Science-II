package SetsAndMaps;
//SuessCount.java
//gets the counts for the words in Green Eggs and Ham, and saves them in a file
//Kendall McCullom

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;

public class SeussCount
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
			Map<String, Integer> wordCount = new ArrayMap<>();
			Scanner inFile = new Scanner(new File("greenEggs.txt"));
			PrintWriter outFile = new PrintWriter("counts.txt");
			
			int count =0;

			while (inFile.hasNext())
			{
				String word = inFile.next();
				word = removePunctuation(word); //remove punctuation
				word = word.toLowerCase(); //word to lowercase
				if (wordCount.get(word) == null) //if the value is null, aka the key value pair have not been set
				{
					count = 0; //set count to zero
				}
				else //if there is an existing key/value pair set, the count
				{
					count = wordCount.get(word); //count = the original value
				}
				
				wordCount.add(word, count); //overwrites, now adding the new count value
				
				if (wordCount.contains(word)) //if word already in key of map
				{
					wordCount.set(word, count+1); //increase word count (value) of that word by 1
				}
			}
			
			Iterator<String> iter = wordCount.iterator();
			
			outFile.println("Here are the wordcounts for all the words in Dr. Seuss' Green Eggs and Ham:\n");
			
			int sum = 0;
			while (iter.hasNext())
			{	
				String spacing = "\t";
				String name = iter.next(); //the key
				if(wordCount.get(name) < 10) //if the word count is single digit
				{
					spacing += " "; //add an extra space for so they line up to the left
				}
				outFile.println(name + spacing +  wordCount.get(name));
				sum += wordCount.get(name);
			}
			outFile.println("\nTotal Word Count: " + sum);
			inFile.close();
			outFile.close();	
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
