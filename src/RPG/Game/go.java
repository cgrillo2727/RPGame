package RPG.Game;
import java.util.Scanner;
/**
 * Created by Shawn-L on 4/25/2016.
 */
public class go {

    public static void main(String args[])throws InterruptedException{
        QuestManager.beginCredits();
        CreateCharacter.createCharacter();
        QuestManager.sequenceA1();
        QuestManager.sequenceC4();
    }
}
