package RPG.Game;
import java.io.Console;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringJoiner;

/*
 * Created by Shawn-L on 4/25/2016.
 */
public class go {

    // create ONE scanner object and have other files get it.
    static final Scanner io = new Scanner(System.in);
    static boolean isJar = false;

    public static void main(String args[])throws InterruptedException{

        Console console = System.console();

        if( Character.class.getResource("Character.class").toString().contains("jar") ) {
            isJar = true;
        }

        if(console == null && isJar) {
            try {
                Runtime rt = Runtime.getRuntime();
                //String game_jar_dir = "C:\\Users\\Dan\\IdeaProjects\\RPGfinalProject\\out\\artifacts\\RPG_Game_jar";
                String game_jar_dir = System.getProperty("user.dir");
                rt.exec("cmd.exe /c cd \"" + game_jar_dir + "\" & start \"<RPG Game Final Project>\" /REALTIME cmd.exe /k \"java -cp .;RPG-Game.jar; RPG.Game.go \"");

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else { // we are in a windows cmd

            QuestManager.beginCredits();
            CreateCharacter.createCharacter();
            QuestManager.sequenceA1();
            QuestManager.sequenceC4();

            System.out.println("it wasent loaded from the console!");
            System.out.println(console);
        }


        io.close(); // only close the scanner object when you're done getting all input.
    }

    public static Scanner getScanner(){
        return io;
    }

}
