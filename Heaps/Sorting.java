package Heaps;

//contains several methods to sort an array
//Kendall McCullom

public class Sorting
{
	//for each item in array, make pass through array, swapping pairs
	//of adjacent items if second item bigger than first
	public static <T extends Comparable<? super T>> void bubbleSort (T [] items)
	{
		boolean sorted = false;

		for (int i = 0; i < items.length-1; i++)
		{
			if (sorted)
			{
				break;
			}

			sorted = true;

			for (int j = 0; j < items.length-1-i ; j++)
			{
				if (items[j].compareTo(items[j+1]) > 0)
				{
					T temp = items[j];
					items[j] = items[j+1];
					items[j+1] = temp;

					sorted = false;
				}
			}
		}
	}

	//for each position in array, find item that goes there
	//and swap with item in that spot
	public static <T extends Comparable<T>> void selectionSort (T [] items)
	{
		for (int i = 0; i < items.length-1; i++)
		{
			int smallest = i;

			for (int j = i+1; j < items.length; j++)
			{
				if (items[j].compareTo(items[smallest]) < 0)
				{
					smallest = j;
				}
			}

			if (smallest > i)
			{
				T temp = items[i];
				items[i] = items[smallest];
				items[smallest] = temp;
			}
		}
	}

 	//for each item in array
   	//locate position where it goes in sorted subarray to its left
   	//move items over to make room
   	//insert item in its sorted position
   	//8 7 4 2 9    slide 8 over to insert 7
   	//7 8 4 2 9    slide 7 and 8 over to insert 4
   	//4 7 8 2 9    slide 4, 7, and 8 over to insert 2
   	//2 4 7 8 9

	// to be implemented
	public static <T extends Comparable<T>> void insertionSort (T[] items)
	{
		for (int i = 0; i<items.length; i++)
		{
			T moving = items[i];
			int location = i;
			for (int j = i-1; j>=0; j--)
			{
				int compare = moving.compareTo(items[j]);
				if (compare>0)
				{
					break;
				}
				if (compare<=0)
				{
					items[j+1] = items[j];
					location = j;
					continue;
				}
				
			}
			items [location] = moving;
		}
	}

	//uses a maxheap to sort an array by successively removing
	//the largest number
	// to be implemented
	public static <T extends Comparable<T>> void heapSort (T [] items)
	{
		Heap<T> h = new Heap<>(items);
		for (int i = items.length; i > 0; i--)
		{
			T removing = h.removeFirst();
			items[i-1] = removing;
		}
	}
}
