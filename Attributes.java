/**
 * @author Catherine Grillo
 * @date created 3/09/2016
 *@date updated 4/09/2016
 *attribute class to set the strength, wisdom, dexterity,
 *constitution, and intelligence of a character.
 */

import java.util.Objects;

public class Attributes {
	//races: human, lizard, elf
	private String race = new String;
	//type is character class: warrior, ranger, wizard
	private String type = new String;
	//strength used for melee attacks
	private int str;
	//dexterity used for ranged attacks
	private int dex;
	//constitution used for health
	private int con;
	//wisdom used for magic attacks
	private int wis;
	//attack points
	private int ap;
	//defense (reduce damage done by a percentage)
	private double defense;
	//accuracy (determines character's chance to hit) (percentage)
	private double acc;
	//total health (doesn't change)
	private int totalhp = 10+con;
	//current health (starts = to totalhp, reduced by combat)
	private int currenthp = totalhp;
	
	
	//methods to alter attributes
	public void setStr(int str) {
		this.str = str;
	}
	
	public void setDex(int dex) {
		this.dex = dex;
	}
	
	public void setCon(int con) {
		this.con = con;
	}
	
	public void setWis(int wis) {
		this.wis = wis;
	}
	
	//calculate attack points based on type
	public void setAttack(String type) {
		if (Objects.equals(type,"warrior")) {
			//warriors have medium attack power (but will have high defense and low accuracy)
			this.ap = 15+str;
		}
		else if (Objects.equals(type,"wizard")) {
			//wizards have high attack power (but will have low defense and medium accuracy)
			this.ap = 17+wis;
		}
		else if (Objects.equals(type,"ranger")) {
			//rangers have low attack power (but will have high accuracy and medium defense)
			this.ap = 12+dex;
		}
	}
}
