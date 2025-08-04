package Heaps;

//Heap.java
//class for creating a maxheap
//Kendall McCullom

public class Heap<T extends Comparable<T>>
{
	public static final int DEFAULT_CAPACITY = 10;

	private T [] collection;
	private int size;

	public Heap()
	{
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public Heap(int capacity)
	{
		if (capacity <= 0)
		{
			throw new IllegalArgumentException("size must be positive!");
		}

		collection = (T []) new Comparable [capacity];
		size = 0;
	}

	//converts an array to a heap
	public Heap(T [] array)
	{
		collection = array;
		size = array.length;

		int parent = (size-2) / 2;

		for (int i = parent; i >= 0; i--)
		{
			siftDown(i);
		}
	}

	//adds an item to a heap
	public void addLast (T item)
	{
		ensureSpace();
		collection[size] = item;
		size++;
		siftUp(size-1);
	}

	//removes an item from a heap
	public T removeFirst ()
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

	//returns an item from a heap
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
		if (size == 0)
		{
			return "[ ]";
		}

		String s = "[";

		for (int i = 0; i < size()-1; i++)
		{
			s+= collection[i] + ", ";
		}

		return s += collection[size-1] + "]";
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

	//sifts an item up to its proper place in the heap
	// to be implemented
	private void siftUp(int i)
	{
		int child = i;
		int parent = (child-1)/2;
		while (child > 0)
		{
			int comparison = collection[child].compareTo(collection[parent]); 
			if (comparison < 0)
			{
				break;
			}
			T temp1 = collection[child];
			T temp2 = collection[parent];
			collection[child] = temp2;
			collection[parent] = temp1;
			child = parent;
			parent = (child-1)/2;
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
           int smaller = right;
           if (right >= size || 
				collection[left].compareTo(collection[right]) > 0)
               smaller = left; 
           if (collection[parent].compareTo(collection[smaller]) > 0) break;
           T temp = collection[parent];
           collection[parent] = collection[smaller];
           collection[smaller] = temp;
           parent = smaller;
           left = 2*parent+1;
           right = 2*parent+2;
         }
	}
}
