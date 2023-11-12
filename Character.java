package main;

import java.util.Objects;

public class Character {
    private String name; //intializing name
    private double height;//intializing height
    private double weight; //intializing weight
    private int moralAlignment; //intializing moral alignment for the character
    private int health; //intializing health
// This is my constructor. When I create a new character, I use this to set all their initial attributes.
    public Character(String name, double height, double weight, int moralAlignment, int health) {
        // Here, I'm assigning the values I received to my character's attributes.
        this.name = name; // I'm setting my character's name.
        this.height = height; // Here's where I set my character's height.
        this.weight = weight; // I'm setting my character's weight here.
        this.moralAlignment = moralAlignment; // This line sets my character's moral alignment.
        this.health = health; // And finally, I'm setting my character's health.
    }

    // Below are my getter methods. They allow me to access my character's private attributes from outside this class.

    public String getName() {
        // I'm returning my character's name with this method.
        return name;
    }

    public double getHeight() {
        // I'm returning my character's height with this method.
        return height;
    }

    public double getWeight() {
        // I'm returning my character's weight with this method.
        return weight;
    }

    public int getMoralAlignment() {
        // I'm returning my character's moral alignment with this method.
        return moralAlignment;
    }

    public int getHealth() {
        // I'm returning my character's current health with this method.
        return health;
    }
    
    // Now, I'm going to write setter methods. These let me change my character's attributes after they've been created.

    public void setName(String name) {
        // I'm using this method to change my character's name.
    	this.name = name;
    }
    
    public void setHeight(double height) {
        // I'm using this method to update my character's height.
    	this.height = height;
    }
    
    public void setWeight(double weight) {
        // I'm using this method to change my character's weight.
    	this.weight = weight;
    }
    
    public void heal(int heal) {
        // I'm using this method to heal my character. If the heal amount is negative, I'll throw an exception because that doesn't make sense.
    	if(heal < 0) {
    		throw new IllegalArgumentException("Heal amount must be non-negative.");
    	} else if(health + heal > 100) {
            // I'm making sure my character's health doesn't exceed 100 because that's the maximum.
    		health = 100;
    	} else {
            // I'm increasing my character's health by the heal amount.
    		health += heal;
    	}
    }
    
    public void injure(int damage) {
        // I'm using this method to apply damage to my character. If the damage is positive, I'll throw an exception because damage should reduce health.
    	if(damage < 0) {
    		throw new IllegalArgumentException("Damage must be non-negative.");
    	} else if(health - damage < 0) {
            // I'm making sure my character's health doesn't drop below 0 because that means they would be dead.
    		health = 0;
    	} else {
            // I'm decreasing my character's health by the damage amount.
    		health -= damage;
    	}
    }
    
    public void changeAlignment(int change) {
        // I'm using this method to change my character's moral alignment.
    	int newAlignment = moralAlignment + change;
    	if(newAlignment >= -1 && newAlignment <= 1) {
            // I'm checking if the new alignment is within the valid range: -1 for evil, 0 for neutral, and 1 for good.
    		moralAlignment = newAlignment;
    	} else {
            // If the change is not within the valid range, I'll throw an exception.
    		throw new IllegalArgumentException("Alignment change is out of bounds. Must be within -1 to 1.");
    	}
    }

    // The equals method is used to compare my character with another object to see if they are the same.
    @Override
    public boolean equals(Object o) {
        // First, I check if the other object is not a Character at all.
        if (!(o instanceof Character)) return false;
        // Then, I cast the other object to a Character type so I can compare attributes.
        Character that = (Character) o;
        // I'm using the Objects helper class to compare my character's attributes with the other character's attributes.
        return Objects.equals(this.name, that.name) &&
               this.height == that.height &&
               this.weight == that.weight &&
               this.moralAlignment == that.moralAlignment &&
               this.health == that.health;
    }

    // The hashCode method is used to generate a unique identifier for my character based on their attributes.
    @Override
    public int hashCode() {
        // I'm using the Objects helper class to generate a hash code from my character's attributes.
        return Objects.hash(name, height, weight, moralAlignment, health);
    }
    
    // The toString method is used to create a string representation of my character.
    @Override
    public String toString() {
        // I'm formatting the string to show my character's attributes in a readable format.
    	return String.format(
            "[Name=%s, Height=%.2f, Weight=%.2f, MoralAlign=%d, Health=%d]",
            name, height, weight, moralAlignment, health
        );
    }

    // This is the main method where I'm testing the functionality of my Character class.
    public static void main(String[] args) {
        // I'm creating two characters to test if the equals and hashCode methods work as expected.
        Character character1 = new Character("Hero", 1.80, 75.0, 1, 100);
        Character character2 = new Character("Hero", 1.80, 75.0, 1, 100);

        // I'm printing out whether the two characters are considered equal.
        System.out.println("Character1 equals Character2: " + character1.equals(character2));
        // I'm printing out the hash codes of my characters to see if they match.
        System.out.println("Character1 hashCode: " + character1.hashCode());
        System.out.println("Character2 hashCode: " + character2.hashCode());
    }
}
