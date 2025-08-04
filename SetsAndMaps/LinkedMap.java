package SetsAndMaps;
//linked implementation of a map
//data stored by key, with no duplicate keys allowed
//Kendall McCullom

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedMap<K, V> implements Map<K, V>
{
	private class Node
	{
		private K key;
		private V value;
		private Node next;

		public Node(K key, V value)
		{
			this.key = key;
			this.value = value;
			next = null;
		}

		public String toString()
		{
			return key + "=" + value;
		}
	}

	private Node head;
	private int size;

	public LinkedMap()
	{
		head = null;
		size = 0;
	}

	//if key in map, replaces old value with new and returns old value
	//otherwise adds key value pair and returns null
	public V add (K key, V value)
	{
		checkForNull(key, value);
		Node current = head;

		for (int i = 0; i < size; i++)
		{
			if (key.equals(current.key))
			{
				V oldValue = current.value;
				current.value = value;
				return oldValue;
			}

			current = current.next;
		}

		Node newNode  = new Node(key, value);
		newNode.next = head;
		head = newNode;
		size++;
		return null;
	}

	//if key in map, replaces old value with new and returns old value
	//otherwise returns null
	public V set (K key, V value)
	{
		checkForNull(key, value);
		Node current = head;

		for (int i = 0; i < size; i++)
		{
			if (key.equals(current.key))
			{
				V oldValue = current.value;
				current.value = value;
				return oldValue;
			}

			current = current.next;
		}

		return null;
	}

	// start of added code

  	//removes key value pair from map and returns value
	//if key not found, returns null
	public V remove (K key)
	{
		checkForNull(key);
		Node current = head;
		for (int i = 0; i < size; i++)	
		{
			if (key.equals(current.key)) //if key trying to remove is in map
			{
				V returned = current.value; //save value at key as variable
				current.key = head.key; //move current data to beginning
				current.value = head.value;
				head = head.next; //move head over one
				size--; //decrement size
				return returned;
			}
			current = current.next; //move current over one
		}
		return null;
	}

	//end of added code 
	
	//returns value associated with key
	//if key not found, returns null
	public V get (K key)
	{
		checkForNull(key);
		Node current = head;

		while (current != null)
		{
			if (key.equals(current.key))
			{
				return current.value;
			}

			current = current.next;
		}

		return null;
	}

	//returns true if key is in map
	public boolean contains(K key)
	{
		checkForNull(key);
		Node current = head;

		while (current != null)
		{
			if (key.equals(current.key))
			{
				return true;
			}

			current = current.next;
		}

		return false;
	}

	//returns size of collection
	public int size()
	{
		return size;
	}

	//returns string representation of contents of collection
	public String toString()
	{
		if (size == 0)
		{
			return "{}";
		}

		String list = "{";
		Node current = head;

		while (current.next != null)
		{
			list += current + ", ";
			current = current.next;
		}

		return list + current + "}";
	}

	//returns iterator for traversing collection
	public Iterator<K> iterator()
	{
		return new LinkedIterator();
	}

	// private helper methods 

	//checks whether key or value is null and if so, throws exception
	private void checkForNull (K key, V value)
	{
		if (key == null || value == null)
		{
			throw new IllegalArgumentException("Key/value can't be null");
		}
	}

	//checks whether key is null and if so, throws exception
	private void checkForNull (K key)
	{
		if (key == null)
		{
			throw new IllegalArgumentException("Key can't be null");
		}
	}

	// iterator class
	private class LinkedIterator implements Iterator<K>
	{
		// instance variables
		private Node position;

		// constructor 
		public LinkedIterator()
		{
			position = head;
		}

		//returns true if another item exists
		public boolean hasNext()
		{
			return position!= null;
		}

		//returns next item and moves iterator forward
		public K next()
		{
			if (hasNext())
			{
				K key = position.key;
				position = position.next;
				return key;
			}

			else
			{
				throw new NoSuchElementException ("Off end of list");
			}
		}

		//removes next item
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}

	
	public V swapValues(K key1, K key2) 
	{
		checkForNull(key1);
		checkForNull(key2);
		Node current = head;
		V v1 = null;
		V v2 = null;
		for (int i = 0; i< size; i++)
		{
			if (current.key.equals(key1))
			{
				 v1 = current.value; 
			}
			else if (current.key.equals(key2))
			{
				v2 = current.value;
			}
			current = current.next;
		}
		
		current = head;
		for (int j = 0; j< size; j++)
		{
			if (current.key.equals(key1))
			{
				current.value = v2; 
			}
			else if (current.key.equals(key2))
			{
				current.value = v1;
			}
			current = current.next;
		}
		
		return v1;
	}
}
