package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class HashedDictionary<K, V> implements DictionaryInterface<K, V> {
	
	/* -------------------
	 * --- TABLE ENTRY ---
	 * -------------------
	 */
	
	// The table storing all the entries.
	private ArrayList<TableEntry<K, V>> table;
	
	class TableEntry<K, V> {
		
		/* -----------------
		 * --- VARIABLES ---
		 * -----------------
		 */
		
		private K key;
		private V value;
		
		/* --------------------
		 * --- CONSTRUCTORS ---
		 * --------------------
		 */
		
		/**
		 * Initializes the table entry
		 * with a specified key and value.
		 * @param key
		 * @param value
		 */
		public TableEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		/**
		 * Initializes an empty table entry with
		 * null data.
		 */
		public TableEntry() {
			this(null, null);
		}
		
		/* ---------------
		 * --- METHODS ---
		 * ---------------
		 */
		
		/**
		 * Returns true or false on whether
		 * the entry is empty or not.
		 * @return true or false
		 */
		public boolean isEmpty() {
			return key == null && value == null;
		}
		
		/**
		 * Clears the table entry, removing
		 * all data leaving the entry null.
		 */
		public void clear() {
			this.key = null;
			this.value = null;
		}
		
		/**
		 * Sets a new key variable
		 * for the entry.
		 * @param key
		 */
		public void setKey(K key) {
			this.key = key;
		}
		
		/**
		 * Returns the key from the
		 * entry.
		 * @return key
		 */
		public K getKey() {
			return key;
		}
		
		/**
		 * Sets a new value variables
		 * for the entry.
		 * @param value
		 */
		public void setValue(V value) {
			this.value = value;
		}
		
		/**
		 * Returns the value from the
		 * entry.
		 * @return value
		 */
		public V getValue() {
			return value;
		}
		
		/**
		 * Returns the data formatted into
		 * a string.
		 */
		public String toString() {
			
			String toString = "[";
			
			if(key == null) {
				toString += "null";
			}	else {
				toString += key.toString();
			}
			
			toString += "=";
			
			if(value == null) {
				toString += "null";
			}	else {
				toString += value.toString();
			}
			
			toString += "]";
			
			return toString;
		}
		
		/* -------------------
		 * --- COMPARATORS ---
		 * -------------------
		 */
		
		/**
		 * Compares this entry's key to another
		 * object, and evaluates to whether or not
		 * they are the same.
		 * @param object
		 * @return true or false
		 */
		public boolean compareKeyTo(Object o) {
			
			// If both classes are not the same,
			// return false.
			if(this.key.getClass() != o.getClass()) {
				return false;
			}
			
			// If the data in key does not equal the 
			// data in the object, return false.
			if(!this.key.equals(o)) {
				return false;
			}
			
			// If the object by-passed each check,
			// return true because it is the same.
			return true;
		}
		
		/**
		 * Compares this entry's value to another
		 * object, and evaluates to whether or not
		 * they are the same.
		 * @param object
		 * @return true or false
		 */
		public boolean compareValueTo(Object value) {
			
			// If both classes are not the same,
			// return false.
			if(this.value.getClass() != value.getClass()) {
				return false;
			}
			
			// If the data in value does not equal the 
			// data in the object, return false.
			if(!this.value.equals(value)) {
				return false;
			}
			
			// If the object by-passed each check,
			// return true because it is the same.
			return true;
		}
		
		/**
		 * Compares this entry's key and value to two
		 * other objects specified as the key and value,
		 * and evaluates to whether or not they are the
		 * same.
		 * @param key
		 * @param value
		 * @return true or false
		 */
		public boolean compareTo(Object key, Object value) {			
			return compareKeyTo(key) && compareValueTo(value);
		}
		
		/**
		 * Compares this entry to another entry, and 
		 * evaluates to whether or not they are the
		 * same.
		 * @param entry
		 * @return true or false
		 */
		public boolean compareTo(TableEntry<K, V> entry) {
			return compareTo(entry.getKey(), entry.getValue());
		}
	}
	
	// A counter that keeps track
	// of the number of entries.
	private int numberOfEntries;
	
	/* --------------------
	 * --- CONSTRUCTORS ---
	 * --------------------
	 */
	
	/**
	 * Initializes a HashMap that uses quadratic
	 * probing to a specified size.
	 * @param size
	 */
	public HashedDictionary(int size) {
		// Initializes the array list that
		// stores the table's entries.
		table = new ArrayList<>();
		
		// Sets the count for the amount
		// of entries to zero.
		numberOfEntries = 0;
		
		// Initializes each table entry in
		// the array so that data can be added.
		for(int i = 0; i < size; i++) {
			table.add(new TableEntry<K, V>());
		}		
	}
	
	/**
	 * Initializes a HashMap that uses quadratic
	 * probing.
	 * @param size
	 */
	public HashedDictionary() {
		// Default for HashMaps is 16,
		// at least, according to the
		// internet.
		this(16);
	}
	
	/* ---------------
	 * --- METHODS ---
	 * ---------------
	 */
	
	/**
	 * Returns the size of the table.
	 * @return size
	 */
	public int getSize() {
		return table.size();
	}
	
	/**
	 * Checks the amount of entries
	 * in the filled in the HashMap.
	 * @return number of entries
	 */
	public int checkCapacity() {
		return numberOfEntries;
	}
	
	/**
	 * Returns true or false on whether
	 * the HashMap is empty.
	 * @return true or false
	 */
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	/**
	 * Clears the entire table by checking
	 * and removing the data from each
	 * entry.
	 */
	public void clear() {
		// Loop through table...
		for(int i = 0; i < table.size(); i++) {
			
			// Check if entry is empty...
			if(!table.get(i).isEmpty()) {
				
				// If not, clear the data
				// in the entry.
				table.get(i).clear();
				
				// And deincrement the counter
				// for entries.
				numberOfEntries--;
				
				// If the counter reaches
				// zero, break the method
				// as we no longer need to
				// keep counting as it is
				// now empty.
				if(numberOfEntries == 0) {
					return;
				}
			}
		}
		
		// A potential debugger that catches
		// if the number of entries is not zero.
		if(numberOfEntries != 0) {
			throw new IllegalArgumentException("numberOfEntries is not zero.");
		}
	}
	
	/**
	 * Checks if the number of entries filled is 
	 * greater than or equal to 75% of the table 
	 * size.
	 * @return true or false
	 */
	public boolean isHashTableTooFull() {
		return numberOfEntries >= 0.75 * table.size();
	}
	
	/**
	 * Increases the size of the hash table
	 * and re-inputs the data into the larger
	 * hash table.
	 * @param size
	 */
	public void enlargeHashTable(int size) {
		
		// Throw new illegal argument exception
		// if the size is smaller that the 
		// the table. I did this because there's
		// potential to not be able to fit all
		// the data into the table if it was
		// smaller.
		if(size <= table.size()) {
			throw new IllegalArgumentException("New size must be greater than table size.");
		}
		
		// Get the iterators for the entries.
		Iterator<K> keyIt = getKeyIterator();
		Iterator<V> valIt = getValueIterator();
		
		// Clear the table.
		clear();
		
		// Loop through the table and add the new entries
		// to the array list.
		for(int i = 0; i < size - table.size(); i++) {
			table.add(new TableEntry<K, V>());
		}
		
		// Then, iterate through the keys and values,
		// and add those into the table.
		while(keyIt.hasNext() && valIt.hasNext()) {
			add(keyIt.next(), valIt.next());
			// Also increment the number of entries.
			numberOfEntries++;
		}
	}
	
	/**
	 * Prints the data from the hash table
	 * to the console.
	 */
	public void displayHashTable() {
		for(int i = 0; i < table.size(); i++) {
			System.out.println(i + ": " + table.get(i).toString());
		}
	}
	
	/**
	 * Retrieves the hash code of the
	 * object.
	 * @param key
	 * @return hash code
	 */
	private int getHashCode(K key) {
		return Objects.hashCode(key);
	}
	
	/**
	 * Calculates and returns the hash index
	 * based on the size of the hash map.
	 * @param key
	 * @return hash index
	 */
	private int getHashIndex(K key) {
		int hashIndex = getHashCode(key) % table.size();
		if(hashIndex < 0) {
			hashIndex *= -1;
		}	
		return hashIndex;
	}
	
	/**
	 * Locates the next empty bucket if
	 * the current bucket is filled.
	 * @param hashIndex
	 * @return new index
	 */
	private int probe(int hashIndex) {
		
		int index = hashIndex;
		
		// Loops through table...
		for(int i = 0; i < table.size(); i++) {
			
			// Use quadratic probing to find next
			// available entry.
			index = (hashIndex + i*i) % table.size();
			
			// If entry is empty, return index.
			if(table.get(index).isEmpty()) {
				return index;
			}
		}
		
		// If no empty bucket is found, return -1
		// to indicate that there is no available
		// index.
		return -1;
	}
	
	/**
	 * Locates the index of the specified
	 * key.
	 * @param key
	 * @return index
	 */
	private int locate(K key) {
		
		int hashIndex = getHashIndex(key);
		
		// Loops through table...
		for(int i = 0; i < table.size(); i++) {
			
			// Use quadratic probing to find next
			// potential matching entry.
			int index = (hashIndex + i*i) % table.size();
			
			// Grab key from entry.
			K otherKey = table.get(index).getKey();
			
			// If keys match, return index.
			if(key.equals(otherKey)) {
				return index;
			}
		}
		
		// If no matching key is found, return -1
		// to indicate that there is no available
		// matching key.
		return -1;
		
	}
	
	/**
	 * Adds data to the entry in the HashMap.
	 */
	public void add(K key, V value) {
		
		// Retrieves hash index.
		int hashIndex = getHashIndex(key);
		
		// Probe hash index.
		int index = probe(hashIndex);
			
		// If new index is -1...
		if(index == -1) {
			// Throw illegal argument exception.
			throw new IllegalArgumentException("No valid entry open.");			
		}
		
		// Enter the new entry.
		table.get(index).setKey(key);
		table.get(index).setValue(value);
		
		// Increment number of entries.
		numberOfEntries++;
		
		// Print the key's index and hash index to console.
		System.out.println(key.toString() + ": index=" + index + ", hashIndex=" + hashIndex);
	}

	/**
	 * Removes the specified key's entry and
	 * returns its value from the entry.
	 * @return value
	 */
	public V remove(K key) {
		
		// Locates index.
		int index = locate(key);
		
		// If index is not -1...
		if(index != -1) {
			
			// Retrieve and store value from entry.
			V value = table.get(index).getValue();
			
			// Remove entry.
			table.set(index, new TableEntry<K, V>());
			
			// De-increment number of entries.
			numberOfEntries--;
			
			// Return stored value.
			return value;
		}
		
		// Else if it doesn't exist,
		// return null.
		return null;
	}

	/**
	 * Returns the value from the
	 * entry of the specified key.
	 * @return value
	 */
	public V getValue(K key) {
		
		// Locates index.
		int index = locate(key);
		
		// If index is not -1...
		if(index != -1) {
			// Return the value from its entry.
			return table.get(index).getValue();
		}
		
		// Else if it doesn't exist,
		// return null.
		return null;
	}

	/**
	 * Returns true or false on whether
	 * it contains the specified key in
	 * an entry.
	 * @return true or false
	 */
	public boolean contains(K key) {
		// If the located index 
		// is not -1... 
		if(locate(key) != -1) {
			// Return true, duh.
			return true;
		}
		// Or false if not.
		return false;
	}

	/* -----------------
	 * --- ITERATORS ---
	 * -----------------
	 */
	
	/**
	 * Returns an iterator for all the
	 * keys in the table.
	 * @return key iterator
	 */
	public Iterator<K> getKeyIterator() {
		return new KeyIterator<K>(table);
	}
	
	class KeyIterator<K> implements Iterator<K> {
		
		/* ----------------
		 * --- VARIABLE ---
		 * ----------------
		 */
		
		private Queue<K> queue;
		
		/* -------------------
		 * --- CONSTRUCTOR ---
		 * -------------------
		 */
		
		/**
		 * Initializes the key iterator.
		 * @param table
		 */
		public KeyIterator(ArrayList<TableEntry<K, V>> table) {
			
			// Initialize the queue.
			queue = new LinkedList<>();
			
			// Loop through the table and add the
			// key from each entry to the queue.
			for(int i = 0; i < table.size(); i++) {
				// Ignore the entry if it is empty.
				if(!table.get(i).isEmpty()) {
					queue.add(table.get(i).getKey());
				}
			}
		}
		
		/**
		 * Returns true or false on whether
		 * the current entry is not empty.
		 * @return true or false
		 */
		public boolean hasNext() {
			return queue.peek() != null;
		}

		/**
		 * Returns the next key in
		 * the table. 
		 * @return key
		 */
		public K next() {
			return queue.remove();
		}
		
	}
	
	/**
	 * Returns an iterator for all the
	 * values in the table.
	 * @return value iterator
	 */
	public Iterator<V> getValueIterator() {
		return new ValueIterator<V>(table);
	}
	
	class ValueIterator<V> implements Iterator<V> {

		/* ----------------
		 * --- VARIABLE ---
		 * ----------------
		 */
		
		private Queue<V> queue;
		
		/* -------------------
		 * --- CONSTRUCTOR ---
		 * -------------------
		 */
		
		/**
		 * Initializes the value iterator.
		 * @param table
		 */
		public ValueIterator(ArrayList<TableEntry<K, V>> table) {
			
			// Initialize the queue.
			queue = new LinkedList<>();
			
			// Loop through the table and add the
			// key from each entry to the queue.
			for(int i = 0; i < table.size(); i++) {
				// Ignore the entry if it is empty.
				if(!table.get(i).isEmpty()) {
					queue.add(table.get(i).getValue());
				}
			}
		}
		
		/**
		 * Returns true or false on whether
		 * the current entry is not empty.
		 * @return true or false
		 */
		public boolean hasNext() {
			return queue.peek() != null;
		}

		/**
		 * Returns the next value in
		 * the table. 
		 * @return value
		 */
		public V next() {
			return queue.remove();
		}
		
	}
	
}
