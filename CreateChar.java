/**
 * @author Catherine Grillo
 *@date created 03/09/2016
 *@date updated 04/09/2016
 *create classes with different attribute levels, races, and weapons
 *sorcerer, fighter, and ranger based on those found in Pathfinder
 */
import java.util.Objects;

public class CreateChar extends Attributes {
	//more features each new rpgclass can have
	public String race = new String();
	public String weapon = new String();
	public String name = new String();
	//class type
	public String type = new String();
	//total health
	public int healthT;
	//current health
	public int currenthp;
	//melee damage
	public int melee;
	//ranged damage
	public int ranged;
	//spell damage
	public int spell;
	
	//class with base stats
	//intention is for 28 extra points to be distributed
	//among the attributes as desired after initialization
	public RPGClass() {
		str = 10;
		wis = 10;
		dex = 10;
		con = 10;
		
		race = "human";
		weapon = "sword";
		name = "John";
		type = "Unspecified";
		
		totalhp = 10+(con)/2;
		melee = str-10;
		ranged = dex-10;
		spell = wis-10;
		currenthp = totalhp;
	}
	
	//create a sorcerer, fighter, or ranger
	//with preset stats and weapon that are best for those classes
	//creator can pick race and name
	public RPGClass(String type, String race, String name){
		this.race = race;
		this.name = name;
		this.type = type;
		
		if (Objects.equals(ty,"sorcerer")) {
			str = 12;
			wis = 16;
			dex = 12;
			con = 10;
			
			weapon = "staff";

		}
		else if (Objects.equals(ty,"fighter")) {
			str = 20;
			wis = 10;
			dex = 18;
			con = 16;
			
			weapon = "short-sword";
		}
		else if (Objects.equals(ty,"ranger")) {
			str = 18;
			wis = 12;
			dex = 20;
			con = 16;
			
			weapon = "long bow";
		}
		
		totalhp = 10+(con+str)/2;
		melee = str-10;
		ranged = dex-10;
		spell = wis-10;
		currenthp = totalhp;
	}
	
	public void printchar() {
		System.out.println("name: "+this.name+"\nclass: "+
				this.type+"\nrace: "+this.race+"\nweapon: "+this.weapon+"\nstr: "+this.str+"\nwis: "+
				this.wis+"\ndex: "+this.dex+"\ncon: "+
				this.con);

	}
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


