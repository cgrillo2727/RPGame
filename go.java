package RPG.Game;
import java.io.Console;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.Scanner;


/*
 * author Cecil College | CSC 218
 */
public class go {

    // create ONE scanner object and have other files get it.
    static final Scanner io = new Scanner(System.in);
    static boolean isJar = false;
    public static boolean isWindows;
    public static boolean isLinux;
    static String input = null;
    static boolean running = true;
    static Character player = null;
    //static Character trogdor = Trogdor.createTrogdor();

    public static void main(String args[]) throws InterruptedException, URISyntaxException, IOException {

        String gameWindowTitle = "[ RPG Game ] The Trogdor Adventures by Cecil College Students ( CSC 218 Computer Science II )";

        Console console = System.console();
        String os = System.getProperty("os.name", "generic").toLowerCase();

        if( Character.class.getResource("Character.class").toString().contains("jar") ) {
            isJar = true;
            if(os.contains("win")){
                isWindows=true;
            } else if(os.contains("linux")){
                isLinux=true;
            }
        }

        if(console == null && isJar) {
            try {
                Runtime rt = Runtime.getRuntime();
                String game_jar_dir = System.getProperty("user.dir");

                if(os.contains("win")) { // we are running windows
                    rt.exec("cmd.exe /c cd \"" + game_jar_dir + "\" & start \" " + gameWindowTitle + "\" cmd.exe /k \"java -cp .;RPG-Game.jar; RPG.Game.go \"");
                } else if (os.contains("linux")) { // we are running linux
                    isLinux = true;
                    isWindows=false;
                    String game_jar_dir2 = Character.class.getProtectionDomain().getCodeSource().getLocation().getPath();
                    game_jar_dir = URLDecoder.decode(game_jar_dir2, "UTF-8");
                    game_jar_dir=game_jar_dir.replace("/RPGame.jar", "");

                    String cmd[] = {"gnome-terminal", "-x", "bash", "-c", "cd " + game_jar_dir + " ; java -cp .:RPGame.jar: RPG.Game.go" };

                    Process pr = new ProcessBuilder(cmd).start();

                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {  // we are in a terminal/command prompt/IDE

        boolean end = false;

            while(running) {

                if(player != null && !end){ // we have a player character

                    QuestManager.sequenceA1();
                    
                    player = null; // reset the player
                    end = true; // it is the end of the game.
                    //input="";
                    //input="quit";

                } else {
                    startMenu();
                    if(input.equals("1") || input.equals("new") || input.equals("new game")){
                        player = CreateCharacter.createCharacter();
                        setPlayer(player);
                    }
                }

                if(input.equals("quit") || input.equals("q") || input.equals("exit") || end){

                    if (end) {
                        System.out.println("The End.");

	                    System.out.println();
	                    System.out.println();
	                    System.out.println("Thanks for playing!");
	                    System.out.println("A game by CSC201 Computer Science II Spring 2016");
	                    System.out.println();
	                    System.out.println();
	                    for(int i=3;i>=0; Thread.sleep(1000), i--){
	                        if(i==0) {
	                            System.out.print("***    GAME CLOSING...                         ****");
	                            Thread.sleep(1000);
	                            break;
	                        }
	                        System.out.print("***    CLOSING GAME IN " + i + " SECONDS...     ****\r");
	                    }
                    }
                    
                    closeTerminal();
                    running = false;

                }
            }

        }


        io.close(); // only close the scanner object when you're done getting all input.
        System.exit(0);
    }

    public static void startMenu() throws InterruptedException, IOException {
        clearScreen();
        QuestManager.beginCredits();
        System.out.println();
        System.out.println(" ***********************************");
        System.out.println(" *           Main Menu             *");
        System.out.println(" ***********************************");
        System.out.println(" *  1. New Game                    *");
        System.out.println(" *  [ quit/q/exit to Quit ]        *");
        System.out.println(" ***********************************");
        System.out.print("> ");
        input = io.next();
        clearScreen();
    }

    private static void closeTerminal() throws IOException, InterruptedException {
        if(isWindows){
            new ProcessBuilder("cmd", "/c", "exit").start();
        } else if(isLinux){
            new ProcessBuilder("gnome-terminal -c exit").start();
        }
    }


    public static Scanner getScanner(){
        return io;
    }

    public static void setPlayer(Character Player){
        player = Player;
    }
    public static Character getPlayer(){
        return player;
    }

    public static void clearScreen() throws IOException, InterruptedException {
        if(isWindows) {
           new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        } else if(isLinux){
            new ProcessBuilder("gnome-terminal -c clear").start();
        }
    }

}
