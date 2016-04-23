/*
 * @author Ian Gompers, Catherine Grillo
 * @date created Fri, Apr 15, 2016  2:36:34 AM
 * @last modified Fri, Apr 23, 2016
 * @description This class represents a game character.
 */
public class Character {
	
	// object data
	
	//name of character
	String name = new String();
	//type is character class: warrior, ranger, wizard
	String type = new String();
	//races: human, lizard, elf
	String race = new String();
	//race bonus gives some attribute bonus based on race
	int raceBonus = 5;



	
	private int constitution;
	private int health = (10+constitution)*15;
	private int currentHealth = health;
	private int strength;
	private int dexterity;
	private int wisdom;
	private double accuracy;
	private double defense;
	private double attack;
	
	//weapon type
	String weapon = new String();
	//weapon bonus based on advancement
	int weaponBonus;
	
	
	// object constructor
	//create a sorcerer, fighter, or ranger
	//with preset stats and weapon that are best for those classes
	//creator can pick race and name
	public Character(String type, String name, String race, int constitution, int strength, int dexterity, int wisdom) {
		this.setType(type);
		this.setName(name);
		this.setRace(race);
		this.setConstitution(constitution);
		this.setStrength(strength);
		this.setDexterity(dexterity);
		this.setWisdom(wisdom);
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
	
	int getRaceBonus() {
		return this.raceBonus;
	}
	
	int getConstitution() {
		return this.constitution;
	}
	
	int getHealth() {
		return this.health;
	}
	
	int getCurrentHealth() {
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
	
	int getWeaponBonus() {
		return this.weaponBonus;
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
	
	void setRaceBonus(int raceBonus) {
		this.raceBonus = raceBonus;
	}
	
	void setConstitution(int constitution) {
		this.constitution = constitution;
	}
	
	void setCurrentHealth(int currentHealth) {
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
	
	void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	
	void setWeaponBonus(int weaponBonus) {
		this.weaponBonus = weaponBonus;
	}
			
} // end Character class
