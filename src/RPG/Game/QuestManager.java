package RPG.Game;
/*
 * Created by James on 4/18/2016.
 */
public class QuestManager {
    //these will gain information after the task of choosing the character type has been done.
    public String chTitle = "";
    public String chWeapon = "";

    public QuestManager(String chTitle, String chWeapon) {
        //chTitle will take on the type of warrior, wizard, or ranger. The weapon will of course equal the proper name afterward.
        this.chTitle = chTitle;
        this.chWeapon = chWeapon;
        if (chTitle.equals("Warrior"))
            chWeapon.equals("Sword of the Lake");
        else if (chTitle.equals("Wizard"))
            chWeapon.equals("Staff of the Lake");
        else
            chWeapon.equals("Bow of the Lake");
    }


    public void town()
    {
        String npc1 = "Would like to exchange goods for services?";
        String npc2 = "Wow! a " + this.chTitle + "! What great timing! We've been hearing roars and rumbles near the lake! Could you check it out?";
    }

    public void lake()
    {
        String narr1 = "The " + this.chTitle + " enters the beach surrounding an ominous lake. It has a faint glow about it eminating from the bottom.";
        String narr2 = "Dive in and see what it is?";

        String narrYes = "You dive in to the cold, mysterious water and find inside it, the " + this.chWeapon + "!";

        String narrNo = "You decide to move on to the cave of uncertainty. Inside, you find a scroll that reads 'Those who enter before ready, shall parish'. You decide the lake is worth diving into.";

        String narrYes2 = "With the prepared weapon in hand, you are ready for the Cave of Uncertainty. You step inside...";


    }

    public static void cave()
    {
        String narrYes3 = "After just 10 minutes of exploring the cave, you see a treasure chest with the same glow the lake so cheesily bore. Approach the chest?";

        String narrYesChest = "Your greed takes you toward the chest. Opening it, you discover nothing, the chest explodes, leaving you with only 60% health. But an opening appears where the chest once was. You proceed.";

        String narrNoChest = "You show restraint toward the greed. Instead, you search behind the chest to find an opening. You proceed with caution.";

        String narrBossYesChest = "Inside, you find an angry, destructive man- ermm, dragon-man!... No, just a dragon. This is the berninator that's been trembling the town. You ready your sword!";
        String trogChest = "I am TROGDOR!!! THE BERNINATOR!!!!! I will have your head!";
        String chestScript1 = "You drop your sword from both fear and the fatigue the chest caused you. In this lapse of judgement, Trogdor eats you alive. Your path has ended.";

        String narrBossNoChest = "Inside, you find a sleeping dragon. You take the moment to sink in the surroundings, gaining an upper hand on Trogdor. You ready your sword.";
        String narrBossNoChest2 = "As you approach the sleeping dragon, he awakens. A bead of sweat rolls down your face. But you are ready.";
        String trogNoChest = "I will devour your soul and lay flame to all the town! For I AM THE BERNINATOR!!!!!";
        String narrBoss1 = "You remember his weakness of being a man, and cut off his legs. Only 50% health remains for Trogdor.";
        String trog3 = "You simple human! I am no man. I am a DRAGON MAN!";
        String narrBoss2 = "You remember the weakness of being a dragon man and cut out his tongue. Leaving only 30% health.";
        String trog4 = "vu fink vat can phop me! I am USS A RAGON!";
        String narrBoss3 = "After understanding what he attempted to say through his tongueless mouth, you decide there is only one thing to do, cut off his head. After several hacks to the tongueless, leggless trogdor, you finally have him killed. 0% health left for Trogdor.";

        String narrEnd = "You head back to the town and show everyone the gruesome head proving you won. Everyone condemns you to solitude for destroying such a fine specimen that could have been researched. The End.";
    }
}
