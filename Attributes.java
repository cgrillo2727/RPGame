import java.util.Objects;
/**
 * @author Catherine Grillo
 * @date created 3/09/2016
 *@date updated 4/09/2016
 *attribute class to set the strength, wisdom, dexterity,
 *constitution, and intelligence of a character.
 */
public class Attributes {
	//strength used for melee attacks
	private int str;
	//dexterity used for ranged attacks
	private int dex;
	//constitution used for health
	private int con;
	//wisdom used for magic attacks
	private int wis;
	//accuracy
	private int acc;
	
	private int healthT;
	//current health
	private int currenthp;
	//melee damage
	private int melee;
	//ranged damage
	private int ranged;
	//spell damage
	private int spell;
	
	
	
	totalhp = 10+(con)/2;
	melee = str-10+;
	ranged = dex-10;
	spell = wis-10;
	currenthp = totalhp;
	
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
	
	
}
