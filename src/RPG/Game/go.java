package RPG.Game;
import java.io.Console;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.Scanner;
import java.util.StringJoiner;

/*
 * author Cecil College | CSC 218
 */
public class go {

    // create ONE scanner object and have other files get it.
    static final Scanner io = new Scanner(System.in);
    static boolean isJar = false;

    public static void main(String args[]) throws InterruptedException, URISyntaxException {

        String gameWindowTitle = "[ RPG Game ] The Trogdor Adventures by Cecil College Students ( CSC 218 Computer Science II )";

        Console console = System.console();
        String os = System.getProperty("os.name", "generic").toLowerCase();

        if( Character.class.getResource("Character.class").toString().contains("jar") ) {
            isJar = true;
        }

        if(console == null && isJar) {
            try {
                Runtime rt = Runtime.getRuntime();
                String game_jar_dir = System.getProperty("user.dir");

                if(os.contains("win")) { // we are running windows
                    rt.exec("cmd.exe /c cd \"" + game_jar_dir + "\" & start \" " + gameWindowTitle + "\" cmd.exe /k \"java -cp .;RPG-Game.jar; RPG.Game.go \"");
                } else if (os.contains("linux")) { // we are running linux

                    String game_jar_dir2 = Character.class.getProtectionDomain().getCodeSource().getLocation().getPath();
                    game_jar_dir = URLDecoder.decode(game_jar_dir2, "UTF-8");
                    game_jar_dir=game_jar_dir.replace("/RPGame.jar", "");

                    String cmd[] = {"gnome-terminal", "-x", "bash", "-c", "cd " + game_jar_dir + " ; java -cp .:RPGame.jar: RPG.Game.go" };

                    Process pr = new ProcessBuilder(cmd).start();





                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else { // we are in a windows cmd

            // start the game

            QuestManager.beginCredits();
            CreateCharacter.createCharacter();
            QuestManager.sequenceA1();
            QuestManager.sequenceC4();

        }


        io.close(); // only close the scanner object when you're done getting all input.
    }

    public static Scanner getScanner(){
        return io;
    }

}
