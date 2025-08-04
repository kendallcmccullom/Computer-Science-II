package SetsAndMaps;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class LargestAndSmallest 
{
	public static void main (String [] args)
	{
		try
		{
			Scanner inFile = new Scanner(new File("numbers.txt"));
			PrintWriter outFile = new PrintWriter("results.txt");	
			int num = inFile.nextInt();
			int largest = num;
			int smallest = num;
			while (inFile.hasNext())
			{
				num = inFile.nextInt();
				if (num < smallest)
				{
					smallest = num;
				}
				if (num > largest)
				{
					largest = num;
				}
			}
			outFile.println("largest: " + largest);
			outFile.println("smallest: " + smallest);
			inFile.close();
			outFile.close();
			
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
