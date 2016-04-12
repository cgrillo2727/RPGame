/**
 * @author Catherine Grillo
 * @date created 3/09/2016
 *@date updated 4/09/2016
 *attribute class to set the strength, wisdom, dexterity,
 *constitution, and intelligence of a character.
 */

import java.util.Objects;

public class Attributes {
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
	
	private int totalhp;
	//current health
	private int currenthp;
	
	private String race = new String;
	private String type = new String;
	
	
	
	totalhp = 10+(con)/2;
	melee = str-10+ Math.random()*10;
	ranged = dex-10+ Math.random()*10;
	spell = wis-10+ Math.random()*10;
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
	
	public void setAttack(String type) {
		if (Objects.equals(type,"warrior")) {
			this.ap = 15+str;
		}
		else if (Objects.equals(type,"wizard")) {
			this.ap = 17+wis;
		}
		else if (Objects.equals(type,"ranger")) {
			this.ap = 12+dex;
		}
	}
}
