package RPG.Game;

// imports
import java.util.Objects;

/*
 * @author Cecil College | CSC 218 
 * @date created Fri, Apr 15, 2016  2:36:34 AM
 * @last modified Fri, May 01, 2016
 * @description This class represents a game character.
 */

public class Character {
	
	// object data
	
	//character name, type: warrior, ranger, or wizard
	//race:human, lizard, elf
	private String name, type, race;
	//race bonus gives some attribute bonus based on race
	private double raceBonus = 0.05;

	//influence maxHealth of character
	private int constitution;
	//maxHealth relies on constitution.
	private double maxHealth = (10+constitution)*10;
	//currentHealth starts out as maxHealth
	private double currentHealth = maxHealth;
	//damage variables
	private int strength, dexterity, wisdom;
	private double accuracy, defense, attack;
	
	//weapon type
	private String weapon;
	//weapon bonus based on advancement
	private double weaponBonus = 0.0;

	//for combat
	//is character in "defend" mode
	private boolean defending = false;
	//defense counter
	int counter = 0;

    // object constructor
	public Character(String type, String name, String race, int constitution, int strength, int dexterity, int wisdom) {
		this.type = type;
		this.name = name;
		this.race = race;
		this.constitution = constitution;
		this.strength = strength;
		this.dexterity = dexterity;
		this.wisdom = wisdom;
	}




    // access object data
	String getName() {
		return this.name;
	}
	
	String getType() {
		return this.type;
	}
	
	String getRace() {
		return this.race;
	}
	
	double getRaceBonus() {
		return this.raceBonus;
	}
	
	int getConstitution() {
		return this.constitution;
	}
	
    public double getMaxHealth() {
        return maxHealth;
    }
    
	double getCurrentHealth() {
		return this.currentHealth;
	}
	
	int getStrength() {
		return this.strength;
	}
	
	int getDexterity() {
		return this.dexterity;
	}
	
	int getWisdom() {
		return this.wisdom;
	}
	
	double getAccuracy() {
		return this.accuracy;
	}
	
	double getDefense() {
		return this.defense;
	}
	
	double getAttack() {
		return this.attack;
	}
	
	String getWeapon() {
		return this.weapon;
	}
	
	double getWeaponBonus() {
		return this.weaponBonus;
	}
	
	boolean getDefending() {
		return this.defending;
	}
	
	int getCounter() {
		return this.counter;
	}
	
	
	
	
	// modify object data	
	void setName(String name) {
		this.name = name;
	}
	
	void setType(String type) {
		this.type = type;
	}
	
	void setRace(String race) {
		this.race = race;
	}
	
	void setRaceBonus(double raceBonus) {
		this.raceBonus = raceBonus;
	}
	
	void setConstitution(int constitution) {
		this.constitution = constitution;
	}
	
	void setCurrentHealth(double currentHealth) {
		this.currentHealth = currentHealth;
	}
	
	void setStrength(int strength) {
		this.strength = strength;
	}
	
	void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	
	void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}
	
	void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}
	
	void setDefense(double defense) {
		this.defense = defense;
	}
	
	void setAttack(double attack) {
		this.attack = attack;
	}
	
	//set weapon type based on character type
	void setWeapon() {
		if (Objects.equals(this.type,"warrior")) {
			weapon = "Sword of the Lake";
		}
		else if (Objects.equals(this.type,"wizard")) {
			weapon = "Staff of the Lake";
		}
		else {
			weapon = "Bow of the Lake";
		}
	}
	
	void setWeaponBonus(double weaponBonus) {
		this.weaponBonus = weaponBonus;
	}
	
	void setDefending(boolean defending) {
		this.defending = defending;
	}
	
	void setCounter(int counter) {
		this.counter = counter;
	}
	
	
	
	
	void printchar() {
		System.out.println("name: "+this.name+"\nclass: "+
				this.type+"\nrace: "+this.race+"\nweapon: "+this.weapon+"\nstrength: "+this.strength+"\nwisdom: "+
				this.wisdom+"\ndexterity: "+this.dexterity+"\nconstitution: "+this.constitution+"\naccuracy: "+this.accuracy+
				"\ndefense: "+this.defense+"\nattack: "+this.attack);

	}
			
} // end Character class
