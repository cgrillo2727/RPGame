package RPG.Game;

import java.util.Objects;

/*
 * @author Ian Gompers, Catherine Grillo
 * @date created Fri, Apr 15, 2016  2:36:34 AM
 * @last modified Fri, Apr 23, 2016
 * @description This class represents a game character.
 */
public class Character {
	
	// object data
	
	//name of character
	private String name = new String();
	//type is character class: warrior, ranger, wizard
	private String type = new String();
	//races: human, lizard, elf
	private String race = new String();
	//race bonus gives some attribute bonus based on race
	private double raceBonus = 0.05;

	private int constitution;
	private double health = (10+constitution)*15;
    private double maxHP = 100;
	private double currentHealth = health;
	private int strength;
	private int dexterity;
	private int wisdom;
	private double accuracy;
	private double defense;
	private double attack;
	
	//weapon type
	private String weapon = new String();
	//weapon bonus based on advancement
	private double weaponBonus = 0.0;

	//for combat
	//is character in "defend" mode
	private boolean defending = false;
	//defense counter
	int counter = 0;

    public double getMaxHP() {
        return maxHP;
    }

    // object constructor
	public Character(String type, String name, String race, int constitution, int strength, int dexterity, int wisdom) {
		this.setType(type);
		this.setName(name);
		this.setRace(race);
		this.setConstitution(constitution);
		this.setStrength(strength);
		this.setDexterity(dexterity);
		this.setWisdom(wisdom);
        this.maxHP = health; // Stores the MAX Health a character can have.
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
	
	double getHealth() {
		return this.health;
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
			weapon = "battle axe";
		}
		else if (Objects.equals(this.type,"wizard")) {
			weapon = "staff";
		}
		else {
			weapon = "longbow";
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
