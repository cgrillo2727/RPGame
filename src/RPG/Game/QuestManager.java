// package
package RPG.Game;

// imports
import java.util.Scanner;

/*
 * @author Cecil College | CSC 218 
 * @date created Fri, Apr 15, 2016  2:36:34 AM
 * @last modified Mon Apr 25 20:08:59 EDT 2016
 * @description This class facilitates the quest
 */

public class QuestManager {
    
    // scanner init
    Scanner io = new Scanner(System.in);
    
    public void startQuest() {
        
        // call class to create character
        sequenceController();
        
    }
    
    public void sequenceController() {
        if(sequenceA1() == 1) {
            sequenceB1();
        } else {
            sequenceB2();
        }
    }
    
    // ----
    
    public int sequenceA1() {
        String sequenceAMessage1 = "As you exit the store you hear a faint scream in the distance";
        String sequenceAMessage2 = "The scream grows louder and louder until a woman appears from the woods, she pleads for your help. (1: Yes, 2: No)";
        int sequenceAChoice1 = io.nextInt();
        return sequenceAChoice1;
    }
    
    public void sequenceB1() {
        String sequenceB1Message1 = "My child stolen by Trogdor! You must help me get him back!";
        String sequenceB1Message2 = "He lives in the cave on the far side of the lake, deep beneath the earth";
        String sequenceB1Message3 = "I cannot pay you, but please, take this map. It leads to a very expensive weapon.";
        String sequenceB1Message4 = "The only weapon that can destroy Trogdor! Maybe some day we will all live in peace";
        String sequenceB1Message5 = "You take the map, accepting the quest and starting your journey...";
        String sequenceB1Message6 = "Many days of walking leads you towards ";
        

    }
    
    public void sequenceC1() {
        
    }

    // ----
    
    public void sequenceB2() {
        
    }
    
    public void sequenceC2() {
        
    }
    
    // ----
    
    public void sequenceB3() {
        
    }
    
    public void sequenceC3() {
        
    }
    
    // ----
    
        
    public void sequenceB4() {
        
    }

    public static void sequenceC4() throws InterruptedException {
        System.out.println("A as you walk, you approach a cave. You enter the cave");
        Thread.sleep(2000);
        System.out.println("The cave is dark....");
        Thread.sleep(500);
        System.out.println(".");
        Thread.sleep(500);
        System.out.println("..");
        Thread.sleep(500);
        System.out.println("...");
        Thread.sleep(500);
        System.out.println(".");
        Thread.sleep(500);
        System.out.println("..");
        Thread.sleep(500);
        System.out.println("...");
    }
    
    // ----
       
} // end class
