package SetsAndMaps;
//interface for a map
//data stored by key, with no duplicate keys allowed

import java.util.Iterator;

public interface Map<K, V> extends Iterable<K>
{
	V add (K key, V value);
	V set (K key, V value);
	V remove (K key);
	V get(K key);
	V swapValues(K key1, K key2);
	boolean contains(K key);
	int size();
	String toString();
	Iterator<K> iterator();
}
