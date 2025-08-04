package Deques;

//LinkedDeque.java
//traverses chain to add/remove at end
//Kendall McCullom

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedDeque<T> implements Deque<T>
{
	private class Node
	{
		private T data;
		private Node next;

		public Node(T item)
		{
			data = item;
			next = null;
		}
	}

	private Node head;
	private int size;

	public LinkedDeque()
	{
		head = null;
		size = 0;
	}

	public void addFirst(T item)
	{
		checkForNull(item);
		Node newNode = new Node(item);
		newNode.next = head;
		head = newNode;
		size++;	
	}


	//copy from queue 
	public void addLast(T item)
	{
		checkForNull(item);
		Node current = head;
		Node newNode = new Node (item);
		if (size == 0) //nothing exists yet, need to set head
			{
				head=newNode;
			}
		else
		{
			while(current.next!=null)
			{
				current = current.next;
			}	
			
			current.next = newNode;
		}
		size++;
	}

	public T removeFirst()
	{
		if (size == 0) 
		{
			return null;
		}

		T removed = head.data;
		head = head.next;
		size--;
		return removed;
	}

	//to be implemented
	public T removeLast()
	{
		Node current = head;
		T saved = null;
		if (size == 0)
		{
			return null;
		}
		if (size == 1)
		{
			saved = head.data;
			head = null;
		}
		else
		{
			for (int i = 0; i < size-2; i++)
			{
				current = current.next;
			}
			saved = current.next.data;
			current.next = null;
		}
		size--;
		return saved;
	}

	public T getFirst()
	{
		if (size == 0)
		{
			return null;
		}

		return head.data;
	}

	public T getLast()
	{
		if (size == 0)
		{
			return null;
		}

		Node current = head;

		for (int i = 0; i < size-1; i++)
		{
			current = current.next;
		}

		return current.data;
	}

	public boolean contains (T item)
	{
		Node current = head;

		while (current!= null)
		{
			if (item.equals(current.data))
			{
				return true;
			}

			current = current.next;
		}

		return false;
	}

	public int size()
	{
		return size;
	}

	public String toString()
	{
		String s = "[";
		Node current = head;

		while (current != null)
		{
			s += current.data;

			if (current.next != null)
			{
				s += ", ";
			}

			current = current.next;
		}

		return s + "]";
	}

	public Iterator<T> iterator()
	{
		return new LinkedIterator();
	}

	public void checkForNull(T item)
	{
		if (item == null)
		{
			throw new IllegalArgumentException("null not a possible value!");
		}
	}

	private class LinkedIterator implements Iterator<T>
	{
		private Node position;  	

		public LinkedIterator()
		{
			position = head;
		}

		public boolean hasNext()
		{
			return position!= null;
		}

		public T next()
		{
			if (hasNext())
			{
				T item = position.data;
				position = position.next;
				return item;
			}

			else
			{
				throw new NoSuchElementException ("Off end of list");
			}
		}

		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
}
