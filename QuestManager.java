package RPG.game;
import java.util.Scanner;

public class QuestManager {
//scanner initialize
  static Scanner io = go.getScanner();

  public static void beginCredits()throws InterruptedException{
      System.out.println("Welcome to...");
      Thread.sleep(800);
      System.out.println("The Adventures of Eric Lake!");
      Thread.sleep(800);

  }
  public static void characterSelfStats(){
      System.out.println();
  }

  public static void sectionSwapper() throws InterruptedException{
      Thread.sleep(3000);
      System.out.println("The story continues");
      Thread.sleep(3000);
  }
  
  public static void startQuest() throws InterruptedException {
      
      // call class to create character
      sequenceA1();
      
  }
  /*
  public static void sequenceController() {
      Scanner io3 = new Scanner(System.in);
      int decision = io3.nextInt();
      if(decision == 1) {
          sequenceB1();
      } else {
          sequenceB2();
      }
  }
*/

  // ----
  
  /*public static int sequenceA1() {
      Scanner io2 = new Scanner(System.in);
      String sequenceAMessage1 = "As you exit the store you hear a faint scream in the distance";
      String sequenceAMessage2 = "The scream grows louder and louder until a woman appears from the woods, she pleads for your help. (1: Yes, 2: No)";
      int sequenceAChoice1 = io2.nextInt();
      return sequenceAChoice1;
  }
  */

  public static void sequenceA1() throws    InterruptedException{

      System.out.println("As you exit the store you hear a faint scream in the distance");
      System.out.println("The scream grows louder and louder until a woman appears from the woods, she pleads for your help. (1: Yes, 2: No)");


      int decision;
      decision = Integer.parseInt(io.next());
      switch (decision){
          case 1: sequenceB1();
              break;
          case 2: sequenceB2();
              break;
      }

      /*if(decision == 1) {
          sequenceB1();
      } else {
          sequenceB2();
      }*/
  }
  public static void sequenceB1() throws InterruptedException{
      String sequenceB1Message1 = "My child stolen by Trogdor! You must help me get him back!";
      String sequenceB1Message2 = "He lives in the cave on the far side of the lake, deep beneath the earth";
      String sequenceB1Message3 = "I cannot pay you, but please, take this map. It leads to a very expensive weapon.";
      String sequenceB1Message4 = "The only weapon that can destroy Trogdor! Maybe some day we will all live in peace";
      String sequenceB1Message5 = "You take the map, accepting the quest and starting your journey...";
      String sequenceB1Message6 = "Many days of walking through a forest leads you towards ";
      System.out.println(sequenceB1Message1);
      Thread.sleep(1500);
      System.out.println(sequenceB1Message2);
      Thread.sleep(1500);
      System.out.println(sequenceB1Message3);
      Thread.sleep(1500);
      System.out.println(sequenceB1Message4);
      Thread.sleep(1500);
      System.out.println(sequenceB1Message5);
      Thread.sleep(1500);
      System.out.println(sequenceB1Message6);
      Thread.sleep(1500);

  }
  public static void sequenceB2() throws InterruptedException{
    System.out.println("You take 2 steps and start to hear a whistling noise. You look around and can't judge where its coming from.");
    Thread.sleep(800);
    System.out.println("Then you look up and an arrow from the sky peirces your head and you die...");
    System.exit(0);

}

  
  public static void sequenceC1() throws InterruptedException{
  	String sequenceC1Message1 = "As you are walking through the forest that night you hear howling and trees moving in the wind";
  	String sequenceC1Message2 = "You walk past some bushes and you hear rustling.";
  	String sequenceC1Message3 = "You also hear growling and you keep you eyes on the bushes as you continue to pass.";
  	String sequenceC1Message4 = "Three wolves jump out of the bushes that are slobbering and are foamed at the mouth!!";
  	String sequenceC1Message5 = "Startled you have to make a quick decision (1: RUNNN!!! 2: See if they are friendly and try to pet them...)";
  	System.out.println(sequenceC1Message1);
    Thread.sleep(1500);
    System.out.println(sequenceC1Message2);
    Thread.sleep(1500);
    System.out.println(sequenceC1Message3);
    Thread.sleep(1500);
    System.out.println(sequenceC1Message4);
    Thread.sleep(1500);
    System.out.println(sequenceC1Message5);
  	int decision;
    decision = Integer.parseInt(io.next());
    switch (decision){
        case 1: sequenceC2();
            break;
        case 2: sequenceC3();
            break;
    }
  }

  public static void sequenceC2() throws InterruptedException{
  	String sequenceC2Message1 = "You see that they clearly aren't friendly and take off! ";
  	String sequenceC2Message2 = "The wolves are right on your tail";
  	String sequenceC2Message3 = "You duck and weave in and out of the forest using the trees and bushes to your advantage but they keep cathcing up to you!";
  	String sequenceC2Message4 = "After it felt like you had been running for 3  years, 2 months, 14 days, and 16 hours...";
  	String sequenceC2Message5 =	"You turn around and can see that you lost them and that it is already ready dawn.";
  	System.out.println(sequenceC2Message1);
    Thread.sleep(1500);
    System.out.println(sequenceC2Message2);
    Thread.sleep(1500);
    System.out.println(sequenceC2Message3);
    Thread.sleep(1500);
    System.out.println(sequenceC2Message4);
    Thread.sleep(1500);
    System.out.println(sequenceC2Message5);
    Thread.sleep(1500);
  }
 
  public static void sequenceC3() throws InterruptedException{
  	String sequenceC3Message1 = "You begin slowly walking towards the wolves.";
  	String sequenceC3Message2 = "The two wolves in the back see you calmly approaching and put their ears down in comfort.";
  	String sequenceC3Message3 = "The leader of the pack isnt amused and barks and all three wolves then jump and attack you.";
  	String sequenceC3Message4 = "Being surrounded you have to chance to defend yourself and you get torn to pieces";
  	String sequenceC3Message5 = "When the wolves are through they leave your cold dead corpse to rot away...";
  	System.out.println(sequenceC3Message1);
    Thread.sleep(1500);
    System.out.println(sequenceC3Message2);
    Thread.sleep(1500);
    System.out.println(sequenceC3Message3);
    Thread.sleep(1500);
    System.out.println(sequenceC3Message4);
    Thread.sleep(1500);
    System.out.println(sequenceC3Message5);
    Thread.sleep(1500);
  }
  

  // ----
  
  
 /* public void sequenceB4() {
  	String sequenceC2Message1 = "After walking for 2 days you arrive at the Eric Lake!";
  	String sequenceC2Message2 = "You start searching the Lake for the expensive weapon the person told you about. ";
  	String sequenceC2Message3 = "As you walk up the lake you see a bag with the tip of a " + weapon + " sticking out." ;
  	String sequenceC2Message4 = "You take it out of the bag and pick it up and it weirdly feels comfortable in your hands as it is an extension of yourself.";  
  	String sequenceC2Message5 = "As you're inspecting it you find an etching on it. Its called The " + weapon + "of Eric Lake!" ;
  	String sequenceC2Message6 = "You feel empowered by The " + weapon + "of Eric Lake and you proceed to the cave just down by the far side of the Lake.";
  
      
  }
  */
  // ----
  
  
  // ----
  

  public static void sequenceC4() throws InterruptedException {
      System.out.println("A as you walk, you approach a cave. You enter the cave");
      Thread.sleep(3000);
      System.out.println("The cave is dark....");
      Thread.sleep(1700);
      System.out.println(".");
      Thread.sleep(650);
      System.out.println("..");
      Thread.sleep(650);
      System.out.println("...");
      Thread.sleep(650);
      System.out.println(".");
      Thread.sleep(650);
      System.out.println("..");
      Thread.sleep(650);
      System.out.println("...");
  }
  
  // ----
     
} // end class

