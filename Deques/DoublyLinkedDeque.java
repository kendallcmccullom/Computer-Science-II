package Deques;

//DoublyLinkedDeque.java
//linked implementation of a deque 
//uses previous pointer to access penultimate node 
//Kendall McCullom

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedDeque<T> implements Deque<T>
{
	private class Node
	{
		private T data;
		private Node next;
		private Node prev;

		public Node(T item)
		{
			data = item;
			next = null;
			prev = null;
		}
	}

	private Node head;
	private Node tail;	
	private int size;

	public DoublyLinkedDeque()
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

		else head.prev = newNode;
		size++;	
	}

	//copy from queue, and update to connect new node to lefthand neighbor 
	public void addLast(T item)
	{
		checkForNull(item);
		Node newNode = new Node(item);
		Node last = null;
		if (size == 0)
			{
				head=newNode;
				
			}
		else
		{
			last = tail;
			last.next = newNode;
		}
		newNode.prev = tail;
		tail = newNode;
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

		else
		{
			head.prev = null;
		}

		size--;
		return removed;
	}

	// to be implemented
	public T removeLast()
	{
		T saved = tail.data;
		if (size == 0)
		{
			return null;
		}
		else if (size == 1)
		{
			saved = head.data;
			head = null;
		}
		else
		{
			tail = tail.prev;
			tail.next = null;
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
