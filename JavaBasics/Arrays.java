package JavaBasics;
/*
 * integer array methods
 *
 * illustrates that with arrays, actual array in memory gets modified
 */

public class Arrays
{
	/*
	 * doubles values in original array
	 * => array changed permanently in memory so doesn't need to be returned
	 */

	public static void modifiedArray(int [] a)
	{
		for (int i = 0; i< a.length; i++)
		{
			a[i] = 2*(a[i]);
		}
	}

	/*
	 * creates new array containing doubled values
	 * => new array needs to be returned, to give calling method access to it
	 */

	public static int [] createdArray(int [] a)
	{
		modifiedArray(a);
		return a;  // so method will compile until code added
	}

	/*
	 * prints integer array
	 */

	public static void printArray(int [] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main (String [] args)
	{
		int [] numbers = {1, 7, 2, 11, -4};
		System.out.println("\nOriginal array: ");
		printArray(numbers);
		System.out.println("\nAfter calling method that modifies array "
			+ "directly:");
		System.out.println("(contents changed)");
		modifiedArray(numbers);
		printArray(numbers);
		System.out.println("\nOriginal array: ");
		printArray(numbers);
		numbers = new int [] {1, 7, 2, 11, -4};
		System.out.println("\nAfter calling method that creates new array:");
		System.out.println("(original array untouched)");
		printArray(numbers);
		System.out.println("\nAfter saving new array first: ");
		int [] numbers2 = createdArray(numbers);
		printArray(numbers2);
	}
}
