package SetsAndMaps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HappeningNow 
{
	public static void main (String args [])
	{
		try
		{
			Scanner inFile = new Scanner(new File("words2.txt"));
			PrintWriter outFile = new PrintWriter("event.txt");	
			while (inFile.hasNext())
			{
				String word = inFile.next();
				
				if (word.length() == 4)
				{
						if (word.contains("i"))
						{
							if (word.contains("'"))
							{
								char k = word.charAt(0);
								word = Character.toUpperCase(k) + word.substring(1, word.length());
								
							}
							else
							{
								word = word + "!";
							}
							outFile.println(word);
					}
				}
				
				if (word.charAt(0) == 'm')
				{
					char k = word.charAt(0);
					word = Character.toUpperCase(k) + word.substring(1, word.length());
					outFile.println(word);
				}
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
