package main;

import java.util.Iterator;

public interface DictionaryInterface<K, V> {
	
	/* ---------------
	 * --- METHODS ---
	 * ---------------
	 */
	
	/**
	 * Returns the size of the table.
	 * @return size
	 */
	public int getSize();
	
	/**
	 * Returns true or false on whether
	 * the HashMap is empty.
	 * @return true or false.
	 */
	public boolean isEmpty();	
	
	/**
	 * Clears the entire table, removing all data
	 * from entries.
	 */
	public void clear();
	
	/**
	 * Adds data to the entry in the HashMap.
	 */
	public void add(K key, V value);
	
	/**
	 * Removes the specified key's entry and
	 * returns its value from the entry.
	 * @return value
	 */
	public V remove(K key);
	
	/**
	 * Returns the value from the
	 * entry of the specified key.
	 * @return value
	 */
	public V getValue(K key);
	
	/**
	 * Returns true or false on whether
	 * it contains the specified key in
	 * an entry.
	 * @return true or false
	 */
	public boolean contains(K key);
	
	/**
	 * Returns an iterator for all the
	 * keys in the table.
	 * @return key iterator
	 */
	public Iterator<K> getKeyIterator();
	
	/**
	 * Returns an iterator for all the
	 * values in the table.
	 * @return value iterator
	 */
	public Iterator<V> getValueIterator();

}
