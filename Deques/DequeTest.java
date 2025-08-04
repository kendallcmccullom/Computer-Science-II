package Deques;
//test program for deques

public class DequeTest
{
	public static void main (String [] args)
	{
		try
		{
			//Deque<String> words = new ArrayDeque<String>();
			//Deque<String> words = new CircularDeque<String>(); 	
			Deque<String> words = new LinkedDeque<String>();
			//Deque<String> words = new DoubleEndedDeque<String>();
			//Deque<String> words = new DoublyLinkedDeque<String>();	

			// adding to front (empty list)
			System.out.println("\nadding hello to front");
			words.addFirst("hello");
			System.out.println(words);

			// adding to front
			System.out.println("\nadding ‘well’ to front");
			words.addFirst("well");
			System.out.println(words);

			// adding to end
			System.out.println("\nadding ‘world’ to end");
			words.addLast("world");
			System.out.println(words);

			// retrieving from front
			System.out.println("\ngetting first item");
			System.out.println(words.getFirst());

			// retrieving from end
			System.out.println("\ngetting last item");
			System.out.println(words.getLast());

			// removing first item
			System.out.println("\nremoving first item");
			words.removeFirst();
			System.out.println(words);

			// removing last item
			System.out.println("\nremoving last item");
			words.removeLast();
			System.out.println(words);

			// removing last item (list of one)
			System.out.println("\nremoving last item");
			words.removeLast();
			System.out.println(words);

			// removing last item (empty list)
			System.out.println("\ntrying to remove last item");
			System.out.println(words.removeLast());

			// adding to end (empty list)
			System.out.println("\nadding 'hello' to end");
			words.addLast("hello");
			System.out.println(words);

			// removing first item (list of one)
			System.out.println("\nremoving first item");
			words.removeFirst();
			System.out.println(words);

			// removing first item (empty list)
			System.out.println("\ntrying to remove first item");
			System.out.println(words.removeFirst());
		}

		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
