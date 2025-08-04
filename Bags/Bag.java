package Bags;
//Bag.java
//interface for a bag
//unordered collection with duplicates allowed

import java.util.Iterator;

public interface Bag<T>
{
	//adds items to the collection
	void add (T item);

	//removes specified item
	//returns true if item removed, false if not found
	boolean remove (T item);

	//removes and returns random item
	T removeRandom();

	//returns random item
	T getRandom();

	//returns true if item is in the collection
	boolean contains (T item);

	//returns size of collection
	int size();

	//returns string representation of contents of collection
	String toString();

	//returns iterator for traversing collection
	Iterator<T> iterator();

	//discussion section methods

	//adds an additional copy of an item for every occurrence of it
	//returns the number of items added
	int doubleTheFun (T item);

	//adds an item if it occurs no more than one time 
	//returns true if the item was added
	boolean addToGalaxianSet (T item);
}
