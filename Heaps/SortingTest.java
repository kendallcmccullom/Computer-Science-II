package Heaps;

//test program for sorting an array 

public class SortingTest
{
	//prints array of Strings
	public static void printArray(String [] items)
	{
		System.out.print("[");

		for (int i = 0; i < items.length; i++)
		{
			System.out.print(items[i]);

			if (i < items.length-1)
			{	
				System.out.print(", ");
			}
		}

		System.out.println("]");
	}

	public static void main (String [] args)
	{
		String [] words = {"banana", "grape", "coconut", "plum", "apple", 
			"cherry"};
		System.out.print("\nbefore sorting\n");
		printArray(words);
		//Sorting.bubbleSort(words);
		//Sorting.selectionSort(words);      
		Sorting.insertionSort(words);
		//Sorting.heapSort(words);			
		System.out.print("\nafter sorting\n");
		printArray(words);
	}
}
