package StacksAndQueues;
//CircularQueue.java
//implements a queue using a circular array 
//Kendall McCullom

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularQueue<T> implements Queue<T>
{
	public static final int DEFAULT_CAPACITY = 3;

	private T [] collection;
	private int size;
	private int first;

	public CircularQueue()
	{
		this(DEFAULT_CAPACITY);
	}

	public CircularQueue(int capacity)
	{
		if (capacity < 0)
			throw new IllegalArgumentException("bag can't be negative size!");

		@SuppressWarnings("unchecked")
		T [] temp  = (T []) new Object[capacity];
		collection = temp;
		temp = null;
		size = 0;
		first = 0;
	}

	//adds item to end of queue
	public void addLast(T item)
	{
		checkForNull(item);
		ensureSpace();
		collection[(first+size)%collection.length] = item;
		size++;
	}

	//removes item from end of queue
	public T removeFirst()
	{
		if (size == 0)
		{
			return null;
		}
		T returned = collection [first];
		//System.out.println(size);
		collection [first] = null;
		
		//first++;
		//System.out.print(size);
		first = (first+1)%collection.length;
		System.out.println(first);
		
		size--;
		
		return returned;
	}

	//returns first item
	public T getFirst()
	{
		if (size == 0)
		{
			return null;
		}

		return collection[first];
	}

	public boolean contains (T item)
	{
		for (int i = first; i < first+size; i++)
		{
			if (item.equals(collection[i%collection.length]))
			{
				return true;
			}
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

		for (int i = first; i < first+size; i++)
		{
			s+= collection[i%collection.length];

			if (i < first+size-1)
			{
				s+= ", ";
			}
		}

		return s + "]";
	}

	public Iterator<T> iterator()
	{
		return new ArrayIterator();
	}

	private void checkForNull(T item)
	{
		if (item == null)
		{
			throw new IllegalArgumentException("item can't be null");
		}
	}

	private void ensureSpace()
	{
		if (size == collection.length)
		{
			@SuppressWarnings("unchecked")
			T [] larger  = (T []) new Object [size * 2];

			for (int i = first; i < first+size; i++)
			{
				larger[i] = collection[i%collection.length];
			}

			collection = larger;
			larger = null;
		}
	}

	private class ArrayIterator implements Iterator<T>
	{
		private int count;

		public ArrayIterator()
		{
			count = 0;
		}

		public boolean hasNext()
		{
			return count < size;
		}

		public T next()
		{
			if (hasNext())
			{
				return collection[count++];
			}

			else
			{
				throw new NoSuchElementException("off end of list");
			}
		}

		public void remove()
		{
			throw new UnsupportedOperationException("remove not implemented");
		}
	}
}
