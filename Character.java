/*
 * @author Ian Gompers
 * @date created Fri, Apr 15, 2016  2:36:34 AM
 * @last modified Fri, Apr 15, 2016  2:57:33 AM
 * @description This class represents a game character.
 */
public class Character {

	// object data
	private double health;
	private double strength;
	private double dexterity;
	private double wisdom;
	private double accuracy;
	
	// object constructor
	public Character(double h, double s, double d, double w, double a) {
		health = h;
		strength = s;
		dexterity = d;
		wisdom = w;
		accuracy = a;
	}
	
	// access object data
	double getHealth() {
		return this.health;
	}
	
	double getStrength() {
		return this.strength;
	}
	
	double getDexterity() {
		return this.dexterity;
	}
	
	double getWisdom() {
		return this.wisdom;
	}
	
	double getAccuracy() {
		return this.accuracy;
	}
	
	// modify object data
	void setHealth(double h) {
		this.health = h;
	}
	
	void setStrength(double s) {
		this.strength = s;
	}
	
	void setDexterity(double d) {
		this.dexterity = d;
	}
	
	void setWisdom(double w) {
		this.wisdom = w;
	}
	
	void setAccuracy(double a) {
		this.accuracy = a;
	}
			
} // end Character class
