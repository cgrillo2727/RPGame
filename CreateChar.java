/**
 * @author Catherine Grillo
 *@date created 03/09/2016
 *@date updated 04/15/2016
 *CreateChar uses Attributes class to initialize characters
 */


public class CreateChar extends Attributes {

	
	//create a sorcerer, fighter, or ranger
	//with preset stats and weapon that are best for those classes
	//creator can pick race and name
	public CreateChar(String name, String race, String type, int str, int dex, int wis, int con){
		this.setType(type);
		this.setName(name);
		this.setRace(race);
		this.setStr(str);
		this.setDex(dex);
		this.setWis(wis);
		this.setCon(con);
		
		setWeapon(type);
		setAp(type);
		setDefense(type);
		setAcc(type);
	}
	
	public void printchar() {
		System.out.println("name: "+this.name+"\nclass: "+
				this.type+"\nrace: "+this.race+"\nweapon: "+this.weapon+"\nstrength: "+this.str+"\nwisdom: "+
				this.wis+"\ndexterity: "+this.dex+"\nconstitution: "+this.con+"\nattack power: "+this.ap+"\ndefense: "+
				(int)(this.defense*100)+"%"+"\naccuracy: "+(int)(this.acc*100)+"%");

	}

}


