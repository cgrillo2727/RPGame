package RPG.Game;

/**
 * Created by Shawn-L on 4/28/2016.
 */
public class Trogdor  {
    public static Character createTrogdor(){

        String name="Trogdor";
        String type="wizard";
        String race="lizard";
        int constitution = 15;
        int strength = 100;
        int dexterity = 100;
        int wisdom = 15;

        return new Character(type, name, race, constitution, strength, dexterity, wisdom);
    }

}
