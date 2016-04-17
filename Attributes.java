/**
 * @author Catherine Grillo
 * @date created 3/09/2016
 *@date updated 4/17/2016
 *attribute class to hold and set all attributes of a character.
 */

import java.util.Objects;

public class Attributes {
	//name of character
	String name = new String();
	//races: human, lizard, elf
	String race = new String();
	//race bonus gives some attribute bonus based on race
	int rBonus = 5;
	//type is character class: warrior, ranger, wizard
	String type = new String();
	
	//character starts off not advanced. After first encounter, they become advanced
	boolean isAdvanced = false;

	
	//strength used for warrior attacks
	int str;
	//dexterity used for ranger attacks
	int dex;
	//wisdom used for wizard attacks
	int wis;
	//constitution used for health
	int con;
	
	//weapon type
	String weapon = new String();
	//weapon bonus based on advancement
	int wBonus = 5;
	
	//attack points
	int ap;
	//defense (reduce damage done by a percentage)
	double defense;
	//accuracy (determines character's chance to hit) (percentage)
	double acc;
	
	//total health (doesn't change)
	int totalhp = (10+con)*20;
	//current health (starts = to totalhp, reduced by combat)
	int currenthp = totalhp;
	
	
	//methods to alter attributes
	public void setName(String name) {
		this.name = name;
	}
	
	public void setRace(String race) {
		this.race = race;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
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
	
	//set weapon type based on character type
	public void setWeapon(String type) {
		if (Objects.equals(type,"warrior")) {
			weapon = "battle axe";
		}
		else if (Objects.equals(type,"wizard")) {
			weapon = "staff";
		}
		else {
			weapon = "longbow";
		}
	}
	
	//increase weapon bonus after advancement
	public void upWBonus() {
		wBonus = 10;
	}
	
	//calculate attack points based on type
	public void setAp(String type) {
		//warriors have medium attack power
		if (Objects.equals(type,"warrior")) {
			this.ap = 15+str+wBonus;
		}
		//wizards have high attack power
		else if (Objects.equals(type,"wizard")) {
			this.ap = 17+wis+wBonus;
		}
		//rangers have low attack power
		else {
			this.ap = 12+dex+wBonus;
		}
		//lizards get a racial bonus to attack power
		if (Objects.equals(race, "lizard")) {
			this.ap+=(rBonus/2);
		}
	}
	
	//calculate defense based on type (and constitution)
		public void setDefense(String type) {
			//warriors have high defense
			if (Objects.equals(type,"warrior")) {
				this.defense = (17+con/2.0)/100;
			}
			//wizards have low defense
			else if (Objects.equals(type,"wizard")) {
				this.defense = (12+con/2.0)/100;
			}
			//rangers have medium
			else  {
				this.defense = (15+con/2.0)/100;
			}
			//humans get a racial bonus to defense
			if (Objects.equals(race, "human")) {
				this.defense+=(rBonus/100.0);
			}
		}
		
		//calculate accuracy based on type
		public void setAcc(String type) {
			//warriors have low accuracy
			if (Objects.equals(type,"warrior")) {
				this.acc = 90/100.0;
			}
			//wizards have medium accuracy
			else if (Objects.equals(type,"wizard")) {
				this.acc = 92/100.0;
			}
			//rangers have high accuracy
			else  {
				this.acc = 95/100.0;
			}
			//elves get a racial bonus to accuracy
			if (Objects.equals(race, "elf")) {
				this.acc+=(rBonus/100.0);
			}
		}
		
		//reduce character health
		public void loseHealth(int damage) {
			this.currenthp -= damage;
			if (this.currenthp <=0) {
				System.out.println(this.name+" has died");
				this.currenthp = 0;
			}
			else {
				System.out.println(this.name+" has "+this.currenthp+" health left");
			}
		}
}
