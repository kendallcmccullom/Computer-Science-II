package Heaps;

//driver program for Heap class

public class HeapTest
{
	public static void main (String [] args)
	{
		// creating array from heap
		Integer [] numbers = {4, 5, 3, 9, 2, 7};
		System.out.println("\noriginal array\n" 
			+ java.util.Arrays.toString(numbers)); 
		System.out.println("\nafter converting to a heap");
		Heap<Integer> h = new Heap<>(numbers);
		System.out.println(h);

		// removing from heap
		h.removeFirst();
		System.out.println("\nremoving the largest item\n" + h);
		h.removeFirst();
		System.out.println("\nremoving the largest item\n" + h);

		// adding to heap
		h.addLast(13);
		System.out.println("\nadding 13 to the heap\n" + h);
		h.addLast(6);
		System.out.println("\nadding 6 to the heap\n" + h);
		h.addLast(7);
		System.out.println("\nadding 7 to the heap\n" + h);
		h.addLast(11);
		System.out.println("\nadding 11 to the heap\n" + h);

		// removing all items
		int s = h.size();
		for (int i = 0; i < s; i++)
		{
			h.removeFirst();
		}
		System.out.println("\nafter removing everything" + "\n" + h);
	}
}
