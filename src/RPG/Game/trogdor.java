package RPG.Game;

/**
 * Created by Shawn-L on 4/28/2016.
 */
public class trogdor  {
    public static Character createTrogdor(){

        String name="Trogdor";
        String type="wizard";
        String race="lizard";
        int constitution = 50;
        int strength = 5;
        int dexterity = 5;
        int wisdom = 10;



        Character Trogdor = new Character(type, name, race, constitution, strength, dexterity, wisdom);
        return Trogdor;
    }

}
