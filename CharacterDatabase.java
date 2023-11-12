package main;

import java.util.ArrayList;

public class CharacterDatabase implements CharacterDatabaseInterface {
    
    // I'm creating a dictionary to store characters using a hash table.
	private HashedDictionary<Integer, Character> characterDictionary;
	
	// I'm also keeping an array list to maintain an ordered list of characters.
	private ArrayList<Character> database;
	
	// When I create a new CharacterDatabase, I want to specify its size.
	public CharacterDatabase(int size) {
		// I initialize my character dictionary with the given size.
		characterDictionary = new HashedDictionary<>(size);
		// I also initialize my database as an empty array list.
		database = new ArrayList<>();
	}
	
	// If I don't specify a size, I'll default to 16.
	public CharacterDatabase() {
		// I call my other constructor with a default size of 16.
		this(16);
	}
	
	// When I add a character, I need their name, height, weight, moral alignment, and health.
	@Override
	public void addCharacter(String name, double height, double weight, int moralAlign, int health) {
		// I add the new character to my array list.
		database.add(new Character(name, height, weight, moralAlign, health));		
		// Then I add the character to my dictionary using the size of the array list as a key.
		characterDictionary.add(database.size() - 1, database.get(database.size() - 1));
	}
	
	// I need a private method to find a character by name and get their index in the database.
	private int locate(String name) {
		// I'll go through each character in my database.
		for(int i = 0; i < database.size(); i++) {
			// I need to check if the spot is not empty.
			if(database.get(i) != null) {
				// I'll get the name of the character at this index.
				String storedName = database.get(i).getName();
				// If the name matches the one I'm looking for, I've found my character.
				if(name.equals(storedName)) {
					return i;
				}
			}
		}
		// If I don't find the character, I'll return -1 to indicate they're not in my database.
		return -1;
	}

	// To remove a character, I just need their name.
	@Override
	public void removeCharacter(String name) {
		// First, I find the index of the character.
		int index = locate(name);
		// I'll set their spot in the array list to null to indicate it's empty.
		database.set(index, null);		
		// Then I remove them from the dictionary as well.
		characterDictionary.remove(index);
	}

	// To get a character, again, I just need their name.
	@Override
	public Character getCharacter(String name) {
		// I use the locate method to find the character and then get their details from the dictionary.
		return characterDictionary.getValue(locate(name));
	}

	// If I want to see the whole hash table, I can just get the character dictionary.
	@Override
	public HashedDictionary<Integer, Character> getHashTable() {
		return characterDictionary;
	}

	// And if I want to print out the list of characters, I can do so easily.
	@Override
	public void printList() {
		// I'm using the array list's toString method to print all characters.
		System.out.println(database.toString());
	}
}
