package Heaps;

//implements a priority queue
//data removed in sorted order (descending order here)

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PriorityQueue<T extends Comparable<T>> implements Queue<T>
{
	public static final int DEFAULT_CAPACITY = 10;

	private T [] collection;
	private int size;

	public PriorityQueue()
	{
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public PriorityQueue(int capacity)
	{
		if (capacity <= 0)
		{
			throw new IllegalArgumentException("size must be positive!");
		}

		collection = (T []) new Comparable [capacity];
		size = 0;
	}

	/*
	 * converts an array to a heap
	 */

	public PriorityQueue(T [] array)
	{
		collection = array;
		size = array.length;
		int parent = (size-2) / 2;

		for (int i = parent; i >= 0; i--)
		{
			siftDown(i);
		}
	}

	//adds an item
	//item gets sifted up to its proper place 
	public void addLast (T item)
	{
		checkForNull(item);
		ensureSpace();
		collection[size] = item;
		size++;
		siftUp(size-1);
	}

	//removes an item
	//item that replaces it gets sifted down to its proper place
	public T removeFirst()
	{
		if (size == 0)
		{
			return null;
		}

		T removed = collection[0];
		collection[0] = collection[size-1];
		collection[size-1] = null;
		size--;
		siftDown(0);
		return removed;
	}

	public T getFirst()
	{
		if (size == 0)
		{
			return null;
		}

		return collection[0];
	}

	public boolean contains (T item)
	{
		for (int i = 0; i < size; i++)
		{
			if (item.equals(collection[i]))
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

		for (int i = 0; i < size; i++)
		{
			s+= collection[i];
			if (i < size-1)
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
			T [] larger  = (T []) new Comparable [size * 2];

			for (int i = 0; i < size; i++)
			{
				larger[i] = collection[i];
			}

			collection = larger;
			larger = null;
		}
	}

	//copy from Heap file
	private void siftUp(int i)
	{
		int parent = (i-1)/2;
		while (i > 0)
		{
			int comparison = collection[i].compareTo(collection[parent]); 
			if (comparison < 0)
			{
				break;
			}
			T temp1 = collection[i];
			T temp2 = collection[parent];
			collection[i] = temp2;
			collection[parent] = temp1;
			i = parent;
			parent = (i-1)/2;
		}
	}

	//sifts an item down to its proper place in the heap
	private void siftDown(int i)
	{
		int parent = i;
      	int left = 2*i + 1;
		int right = 2*i + 2;
		while (left < size)
		{
			int larger = right;
			if (right >= size || collection[left].compareTo(collection[right]) 
				> 0)
				larger = left; 
			if (collection[parent].compareTo(collection[larger]) > 0) break;
			T temp = collection[parent];
			collection[parent] = collection[larger];
			collection[larger] = temp;
			parent = larger;
			left = 2*parent+1;
			right = 2*parent+1;
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
