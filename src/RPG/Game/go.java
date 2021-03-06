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
    static boolean end = false;
    static String currentMenu = "";
    static boolean youWon = false;

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


            while(running) {

                if(player != null && !end){ // we have a player character

                    QuestManager.sequenceA1(); // Starts quest

                    endMenu();
                    checkInput();

                } else {
                    startMenu();
                   checkInput();
                }

            }

        }


        io.close(); // only close the scanner object when you're done getting all input.
        System.exit(0);
    }

    public static void startMenu() throws InterruptedException, IOException {
        clearScreen();
        QuestManager.beginCredits();
        currentMenu = "start";
        System.out.println();
        System.out.println(" |`````````````````````````````````|");
        System.out.println(" |           Start Menu            |");
        System.out.println(" |`````````````````````````````````|");
        System.out.println(" |  1. New Game                    |");
        System.out.println(" |  [ quit/q/exit to Quit ]        |");
        System.out.println(" |_________________________________|");
        System.out.print("> ");
        input = io.next();
        clearScreen();
    }

    public  static void endMenu() throws IOException, InterruptedException {

        // reset game
        currentMenu = "end";
        end = true;
        player = null;
        if(youWon){
            System.out.println("Congrats! You won the game.");
        }
        System.out.println("   ____                         ___                 ");
        System.out.println("  / ___| __ _ _ __ ___   ___   / _ \\__   _____ _ __ ");
        System.out.println(" | |  _ / _` | '_ ` _ \\ / _ \\ | | | \\ \\ / / _ \\ '__|");
        System.out.println(" | |_| | (_| | | | | | |  __/ | |_| |\\ V /  __/ |   ");
        System.out.println("  \\____|\\__,_|_| |_| |_|\\___|  \\___/  \\_/ \\___|_|   ");
        System.out.println("                                                    ");
     //   System.out.println(" |`````````````````````````````````|");
    //    System.out.println(" |           Game Over             |");
        System.out.println(" |`````````````````````````````````|");
        System.out.println(" |  1. Return to Main Menu         |");
        System.out.println(" |  [ quit/q/exit to Quit ]        |");
        System.out.println(" |_________________________________|");
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

    public static boolean getYouWon() {
       return youWon;
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

    public static void setYouWon(boolean youWon) {
        go.youWon = youWon;
    }

    public static void checkInput() throws InterruptedException {

        if((input.equals("1") || input.equals("new") || input.equals("new game")) && currentMenu.equals("start")){
            player = CreateCharacter.createCharacter();
            setPlayer(player);
        } else if((input.equals("1") || input.equals("start") || input.equals("start menu")) && currentMenu.equals("end")){

        }
        if(input.equals("quit") || input.equals("q") || input.equals("exit")){

            if (end) {
                System.out.println("The End.");

                System.out.println();
                System.out.println();
                System.out.println("Thanks for playing!");
                System.out.println("A game by CSC201 Computer Science II Spring 2016");
                System.out.println();
                System.out.println();
                for(int i=10;i>=0; Thread.sleep(1000), i--){
                    if(i==0) {
                        System.out.print("***    GAME CLOSING...                         ****");
                        Thread.sleep(1000);
                        break;
                    }
                    System.out.print("***    CLOSING GAME IN " + i + " SECONDS...     ****\r");
                }
            } else {
                System.out.println("Shutting down game in 3 seconds.");
                Thread.sleep(3000);
            }
            //closeTerminal();
            running = false;

        }


    }

}
