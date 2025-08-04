package StacksAndQueues;

//test program for queue implementations

public class QueueTest
{
	public static void main (String [] args)
	{
		//Queue<Character> letters = new ArrayQueue<>();
		//Queue<Character> letters = new CircularQueue<>();
		//Queue<Character> letters = new LinkedQueue<>();
		Queue<Character> letters = new DoubleEndedQueue<>();

		// adding (for testing linked implementations)
		Character [] let = {'a','r','k','z','q','p','t','z','a','c', 'q', 'w'};
		System.out.println("\nAdding twelve letters to the queue: ");
		
		for (int i = 0; i < let.length; i++)
		{
			letters.addLast(let[i]);
		}
		
		System.out.println(letters);

		// removing (for testing array implementations)
		System.out.println("\nRemoving each in turn: ");
		int originalSize = letters.size();
		
		for (int i = 0; i < originalSize; i++)
		{
			System.out.println(letters.removeFirst());
		}
		
		// removing from empty queue
		System.out.println("\nTrying to remove from an empty queue: " +
			letters.removeFirst());
	}
}
