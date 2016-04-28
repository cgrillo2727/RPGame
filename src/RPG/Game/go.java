package RPG.Game;
import java.util.Scanner;

/*
 * Created by Shawn-L on 4/25/2016.
 */
public class go {

    // create ONE scanner object and have other files get it.
    static final Scanner io = new Scanner(System.in);

    public static void main(String args[])throws InterruptedException{

        QuestManager.beginCredits();
        CreateCharacter.createCharacter();
        QuestManager.sequenceA1();
        QuestManager.sequenceC4();


        io.close(); // only close the scanner object when you're done getting all input.
    }

    public static Scanner getScanner(){
        return io;
    }

}
