package main;

public interface CharacterDatabaseInterface {
	
	// I'm declaring a method to add a new character with specific stats to my database.
	public void addCharacter(String name, double height, double weight, int moralAlign, int health);
	
	// I'm declaring a method to remove a character from my database using their name.
	public void removeCharacter(String name);
	
	// I'm declaring a method to retrieve a character's details from my database using their name.
	public Character getCharacter(String name);
	
	// I'm declaring a method to get the entire hash table that represents my database.
	public HashedDictionary<Integer, Character> getHashTable();
	
	// I'm declaring a method to print out a list of all characters in my database.
	public void printList();
	
	// In the main method, I'm going to test the functionality of my CharacterDatabase.
	public static void main(String[] args) {
		// I'm creating a new instance of CharacterDatabase.
		CharacterDatabase cd = new CharacterDatabase();
		
		// I'm adding characters to my database and checking their indices.
		cd.addCharacter("FB", 170.0, 62.0, 0, 100);
		cd.addCharacter("Ea", 170.0, 62.0, 0, 100);
		cd.addCharacter("Daegon", 170.0, 62.0, 0, 100);
		cd.addCharacter("Gandalf", 170.0, 62.0, 1, 100);
		
		// I'm printing the hash table to verify the placement of my characters.
		cd.getHashTable().displayHashTable();
		
		// I'm removing the character named Daegon from my database.
		cd.removeCharacter("Daegon");
		
		// I'm printing the hash table again to make sure Daegon was removed.
		cd.getHashTable().displayHashTable();
		
		// I'm printing the list of characters to check if Daegon's spot is now null.
		cd.printList();
		
		// I'm retrieving Gandalf's character sheet to check his stats.
		System.out.println(cd.getCharacter("Gandalf").toString());
		
		// I'm changing Gandalf's moral alignment.
		cd.getCharacter("Gandalf").changeAlignment(-1);
		
		// I'm injuring Gandalf by a certain amount.
		cd.getCharacter("Gandalf").injure(-50);
		
		// I'm healing Gandalf by a certain amount.
		cd.getCharacter("Gandalf").heal(25);
		
		// I'm printing Gandalf's character sheet again to verify the changes.
		System.out.println(cd.getCharacter("Gandalf").toString());
	}
	
}
