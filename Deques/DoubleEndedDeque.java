package Deques;

//DoubleEndedDeque.java
//linked implementation of a queue
//uses tail pointer to access last node
//Kendall McCullom

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleEndedDeque<T> implements Deque<T>
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
	private Node tail;	
	private int size;

	public DoubleEndedDeque()
	{
		head = null;
		tail = null;
		size = 0;
	}

	public void addFirst(T item)
	{
		checkForNull(item);
		Node newNode = new Node(item);
		newNode.next = head;
		head = newNode;
		if (size == 0) 
		{
			tail = newNode;
		}
		size++;	
	}

	//copy from queue
	public void addLast(T item)
	{
		checkForNull(item);
		Node newNode = new Node(item);
		Node last = null;
		if (size == 0) //nothing exists yet, need to set head
			{
				head=newNode;
				
			}
		else
		{
			last = tail;
			last.next = newNode;
		}
		
		tail = newNode; //setting location of tail to new node, which is the last node
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

		if (size == 1) 
		{
			tail = null;
		}

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
		else if (size == 1)
		{
			saved = head.data;
			tail = null;
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
			tail = current;
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

		return tail.data;
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

	private void checkForNull(T item)
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
