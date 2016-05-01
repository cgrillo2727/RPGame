// package
package RPG.Game;

import java.util.Scanner;


/*
 * @author Cecil College | CSC 218 
 * @date created Fri, Apr 15, 2016  2:36:34 AM
 * @last modified Mon Apr 25 20:08:59 EDT 2016
 * @description This class facilitates the quest
 */

public class QuestManager {
    
    // scanner init
    static Scanner io = go.getScanner();

    public static void beginCredits()throws InterruptedException{
        String intro = "Welcome to...";
        for (int index = 0; index < intro.length();
             index++) {
            char aChar = intro.charAt(index);
            System.out.print(aChar);
            Thread.sleep(200);
        }
        System.out.println(" ");
        Thread.sleep(800);
        String intro2 = "The Adventures of Eric Lake!";
        for (int index = 0; index < intro2.length();
             index++) {
            char aChar = intro2.charAt(index);
            System.out.print(aChar);
            Thread.sleep(75);
        }
        System.out.println(" ");
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
        String sequenceB1Message6 = "Many days of walking leads you towards ";
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
    
    public void sequenceC1() {
        
    }

    // ----
    
    public static void sequenceB2() {
        System.out.println("you suck");

    }
    
    public void sequenceC2() throws InterruptedException{
        Scanner io = new Scanner(System.in);
        /* the "i helped the villager" sequence*/
        System.out.println("A lake!");
        System.out.println("following your map, you find the cave that is marked on the map.");
        System.out.println("at the beginning of the cave, just inside.");
        System.out.println("you see three weapons on the floor! Which one do you take?");
        System.out.println("(Hint: Chose a number to make a selection");
        System.out.println("1. Sword.  2. Bow.  3. Staff");
        int wep;
        wep = Integer.parseInt(io.next());
        switch (wep){
            case 1: ;
                break;
            case 2: ;
                break;
        }


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
