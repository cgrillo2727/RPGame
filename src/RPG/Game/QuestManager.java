package RPG.Game;
import java.util.Scanner;
import java.util.Objects;



public class QuestManager {
    //scanner initialize
	static Scanner io = go.getScanner();
	static Character player;
	static Character trogdor = RPG.Game.Trogdor.createTrogdor();

  public static void beginCredits()throws InterruptedException{
      System.out.println("Welcome to...");
      Thread.sleep(800);
      //System.out.println("The Adventures of Eric Lake!");
      System.out.println("  _____ _            _      _             _                   ");
      System.out.println(" |_   _| |_  ___    /_\\  __| |_ _____ _ _| |_ _  _ _ _ ___ ___");
      System.out.println("   | | | ' \\/ -_)  / _ \\/ _` \\ V / -_) ' \\  _| || | '_/ -_|_-<");
      System.out.println("   |_| |_||_\\___| /_/ \\_\\__,_|\\_/\\___|_||_\\__|\\_,_|_| \\___/__/");
      System.out.println("       __   ___     _      _         _                        ");
      System.out.println("  ___ / _| | __|_ _(_)__  | |   __ _| |_____                  ");
      System.out.println(" / _ \\  _| | _|| '_| / _| | |__/ _` | / / -_)_                ");
      System.out.println(" \\___/_|   |___|_| |_\\__| |____\\__,_|_\\_\\___(_)               ");
      System.out.println("                                                              ");
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
  
  public static void sequenceA1() throws    InterruptedException{
      player = go.getPlayer(); // Set the player to the current player
      System.out.println("As you exit the store you hear a faint scream in the distance");
      System.out.println("The scream grows louder and louder until a woman appears from the woods, she pleads for your help. \ny: Yes \nn: No)");


      String decision;
      System.out.print("> ");
      decision = io.next();
      while (!Objects.equals(decision, "y") && !Objects.equals(decision, "n")){
			System.out.println("Oops, you didn't enter a y or n. Try again!");
       System.out.print("> ");
       decision = io.next().toLowerCase();
     }
      switch (decision.charAt(0)){
          case 'y': sequenceB1();
              break;
          case 'n': sequenceB1();
              break;
      }


  }
  public static void sequenceB1() throws InterruptedException{
      String sequenceB1Message1 = "My child stolen by Trogdor! You must help me get him back!";
      String sequenceB1Message2 = "He lives in the cave on the far side of the lake, deep beneath the earth";
      String sequenceB1Message3 = "I cannot pay you, but please, take this map. It leads to a very expensive weapon.";
      String sequenceB1Message4 = "The only weapon that can destroy Trogdor! Maybe some day we will all live in peace";
      String sequenceB1Message5 = "You take the map, accepting the quest and starting your journey...";
      String sequenceB1Message6 = "Many days of walking through the forest awaits you ";
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
      System.out.println(".");
      Thread.sleep(650);
      System.out.println("..");
      Thread.sleep(650);
      System.out.println("...");
      Thread.sleep(650);
      System.out.println("....");
      Thread.sleep(650);
      System.out.println(".....");

      sequenceC1();

  }
  public static void sequenceB2() throws InterruptedException{
      System.out.println("You take 2 steps and start to hear a whistling noise. You look around and can't judge where its coming from.");
      Thread.sleep(800);
      System.out.println("Then you look up and an arrow from the sky pierces your head...");
      System.out.println(player.getName() + " died.");
      sequenceZ();
}

  
  public static void sequenceC1() throws InterruptedException{
  	String sequenceC1Message1 = "As you are walking through the forest that night you hear howling and trees moving in the wind";
  	String sequenceC1Message2 = "You walk past some bushes and you hear rustling.";
  	String sequenceC1Message3 = "You also hear growling and you keep you eyes on the bushes as you continue to pass.";
  	String sequenceC1Message4 = "Three wolves jump out of the bushes that are slobbering and are foamed at the mouth!!";
  	String sequenceC1Message5 = "Startled you have to make a quick decision: \ny: RUNNN!!! \nn: See if they are friendly and try to pet one...";
  	System.out.println(sequenceC1Message1);
    Thread.sleep(1500);
    System.out.println(sequenceC1Message2);
    Thread.sleep(1500);
    System.out.println(sequenceC1Message3);
    Thread.sleep(1500);
    System.out.println(sequenceC1Message4);
    Thread.sleep(1500);
    System.out.println(sequenceC1Message5);

    String decision;
    System.out.print("> ");
    decision = io.next();
    while (!Objects.equals(decision, "y") && !Objects.equals(decision, "n")){
			System.out.println("Oops, you didn't enter a y or n. Try again!");
     System.out.print("> ");
     decision = io.next().toLowerCase();
   }
      switch (decision.charAt(0)){
          case 'y': sequenceC2();
              break;
          case 'n': sequenceC3();
              break;
    }
  }

  public static void sequenceC2() throws InterruptedException{
      System.out.println();
  	String sequenceC2Message1 = "You see that they clearly aren't friendly and take off! ";
  	String sequenceC2Message2 = "The wolves are right on your tail";
  	String sequenceC2Message3 = "You duck and weave in and out of the forest using the trees and bushes to your advantage but they keep cathcing up to you!";
  	String sequenceC2Message4 = "After it felt like you had been running for 3 years, 2 months, 14 days, and 16 hours...";
  	String sequenceC2Message5 =	"You turn around and can see that you lost them and that it is already dawn.";
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
    System.out.println(".");
    Thread.sleep(650);
    System.out.println("..");
    Thread.sleep(650);
    System.out.println("...");
    Thread.sleep(650);
    System.out.println("....");
    Thread.sleep(650);
    System.out.println(".....");

    sequenceB4();
  }

  public static void sequenceC3() throws InterruptedException{
      System.out.println();
  	String sequenceC3Message1 = "You begin slowly walking towards the wolves.";
  	String sequenceC3Message2 = "The two wolves in the back see you calmly approaching and put their ears down in comfort.";
  	String sequenceC3Message3 = "The leader of the pack isn't amused and barks and all three wolves then jump and attack you.";
  	String sequenceC3Message4 = "Being surrounded you have to chance to defend yourself and you get torn to pieces";
  	String sequenceC3Message5 = "When the wolves are through, they leave your cold dead corpse to rot away...";
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
    sequenceZ();
  }


  // ----


  public static void sequenceB4() throws InterruptedException{
      System.out.println();
  	String sequenceB4Message1 = "After walking for almost 2 days you arrive at the Lake Eric!";
  	String sequenceB4Message2 = "You start searching the Lake for the expensive weapon the woman told you about. ";
  	String sequenceB4Message3 = "As you walk up and down the lake you come across the bag the woman told you about." ;
  	String sequenceB4Message4 = "Do you want to... (y: Take it n: Kick the bag into the lake)";


  	System.out.println(sequenceB4Message1);
    Thread.sleep(1500);
    System.out.println(sequenceB4Message2);
    Thread.sleep(1500);
    System.out.println(sequenceB4Message3);
    Thread.sleep(1500);
    System.out.println(sequenceB4Message4);
    
    String decision;
    System.out.print("> ");
    decision = io.next();
    while (!Objects.equals(decision, "y") && !Objects.equals(decision, "n")){
			System.out.println("Oops, you didn't enter a y or n. Try again!");
     System.out.print("> ");
     decision = io.next().toLowerCase();


    }

    switch (decision.charAt(0)){
        case 'y': sequenceB5();
            break;
        case 'n': sequenceB6();
            break;
    }

  }
  
    public static void sequenceB5() throws InterruptedException{
        System.out.println();
        player.setWeapon();
    	player.setWeaponBonus(0.1);
    	String sequenceB5Message1 = "You take it out of the bag and pick it up and it weirdly feels comfortable in your hands as it is an extension of yourself.";
    	String sequenceB5Message2 = "As you're inspecting it you find an etching on it. Its called The "+player.getWeapon()+"!" ;
    	String sequenceB5Message3 = "You feel empowered by The "+player.getWeapon()+" and you proceed to the cave thats on the far side of the Lake.";
    	System.out.println(sequenceB5Message1);
      Thread.sleep(1500);
      System.out.println(sequenceB5Message2);
      Thread.sleep(1500);
      System.out.println(sequenceB5Message3);
      sequenceC4();
    }
    public static void sequenceB6() throws InterruptedException{
        System.out.println();
    	String sequenceB6Message1 = "The bag flies into the Lake never to be seen again... ";
    	String sequenceB6Message2 = "You don't need a weapon... Your hands are deadly enough!!!";
    	String sequenceB6Message3 = "You proceed to the cave on the far side of the Lake";
    	System.out.println(sequenceB6Message1);
      Thread.sleep(1500);
      System.out.println(sequenceB6Message2);
      Thread.sleep(1500);
      System.out.println(sequenceB6Message3);
      sequenceC4();
    }
  
  // ----
  

  public static void sequenceC4() throws InterruptedException {
      System.out.println();
      System.out.println("You approach the cave. You enter the cave");
      Thread.sleep(3000);
      System.out.println("The cave is dark....");
      Thread.sleep(1700);
      System.out.println(".");
      Thread.sleep(650);
      System.out.println("The cave is eerily quiet.");
      Thread.sleep(650);
      System.out.println("...");
      Thread.sleep(650);
      System.out.println("What have you gotten yourself into...");
      Thread.sleep(650);
      System.out.println("..");
      Thread.sleep(650);
      System.out.println("Should you turn around now..");
      Thread.sleep(650);
      System.out.println("...");
      Thread.sleep(650);
      System.out.println("......");
      sequenceD4();
  }
  public static void sequenceD4() throws InterruptedException {
      System.out.println();
  	String sequenceD4Message1 = "As you aimlessly walk through this cave you hear loud screams from what sounds like the kid! ";
  	String sequenceD4Message2 = "You start to look more panically and you finally start to see a flashing light far down the tunnel...";
  	String sequenceD4Message3 = "As you get closer and closer you can tell that the light is coming from the Trodor breathing fire! ";
  	String sequenceD4Message4 = "You turn around the corner to see the Trogdor trying to Burninate the child!!";
  	String sequenceD4Message5 = "In a might of rage you yell... ";
  	String sequenceD4Message6 = "Trogdorrrrr!!!! You leave that child alone or you will feel the wrath of me!";
  	String sequenceD4Message7 = "***Trogdor turns and growls***";
    String sequenceD4Message8 = "You puny being... nothing can stop Trogdor!";
    String sequenceD4Message9 = "(meanwhile the kid runs off attempting to escape Trogdor and exit the cave)";
    String sequenceD4Message10 = "You shake off some adrenaline and try to focus to prepare to take on the allmighty Trogdor.";
  	System.out.println(sequenceD4Message1);
    Thread.sleep(3000);
    System.out.println(sequenceD4Message2);
    Thread.sleep(3000);
    System.out.println(sequenceD4Message3);
    Thread.sleep(3000);
    System.out.println(sequenceD4Message4);
    Thread.sleep(3000);
    System.out.println(sequenceD4Message5);
    Thread.sleep(3000);
    System.out.println(sequenceD4Message6);
    Thread.sleep(3000);
    System.out.println(sequenceD4Message7);
    Thread.sleep(3000);
    System.out.println(sequenceD4Message8);
    Thread.sleep(3000);
    System.out.println(sequenceD4Message9);
    Thread.sleep(3000);
    System.out.println(sequenceD4Message10);
  	Thread.sleep(3000);
  	boolean won = CombatManager.combatManager(player, trogdor);
  	if(won) {sequenceE4();}
    else {sequenceZ();}

  	
  }
  public static void sequenceE4() throws InterruptedException {
      System.out.println();
  	String sequenceE4Message1 = "***Spits blood out of mouth and then wipes mouth***";
  	String sequenceE4Message2 = "You pick up one of the sticks still on fire from Trogdors Burnination and exit the cave.";
  	String sequenceE4Message3 = "When you finally make it outside you are rewarded with an applaud from the townspeople! ";
  	String sequenceE4Message4 = "The woman runs up to you and hugs you in appreciation as well as her son.";
  	String sequenceE4Message5 = "The head townsman approaches you and says...";
  	String sequenceE4Message6 = "Thank you for killing the Trogdor we will forever be in you gratitude. Please take this.";
  	String sequenceE4Message7 = "He then begins to hand you a Cup Of Golden Treasure!!";
  	String sequenceE4Message8 = "You take the cup and nod, then walk off into the sunset for the next challange that awaits...";
  	System.out.println(sequenceE4Message1);
  	Thread.sleep(3000);
  	System.out.println(sequenceE4Message2);
  	Thread.sleep(3000);
  	System.out.println(sequenceE4Message3);
  	Thread.sleep(3000);
  	System.out.println(sequenceE4Message4);
  	Thread.sleep(3000);
  	System.out.println(sequenceE4Message5);
  	Thread.sleep(3000);
  	System.out.println(sequenceE4Message6);
  	Thread.sleep(3000);
  	System.out.println(sequenceE4Message7);
  	Thread.sleep(3000);
  	System.out.println(sequenceE4Message8);
  	Thread.sleep(3000);
  }
  
  public static void sequenceZ() throws InterruptedException{
  	String sequenceZMessage1 = player.getName() + "failed to save the child and return him to his mother.";
   String sequenceZMessage2 = "Trogdor the Burninator will continue to wreak havoc on the town.";
   String sequenceZMessage3 = "Maybe if you make some better life choices you wouldn't have caused the deaths of thousands.";
   System.out.println(sequenceZMessage1);
  	Thread.sleep(3000);
  	System.out.println(sequenceZMessage2);
  	Thread.sleep(3000);
  	System.out.println(sequenceZMessage3);

   
   
  }
 
     
} // end class
