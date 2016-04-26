// package
//package RPG.Game;

// imports
import java.util.Scanner;
import java.io.*;
import java.util.Objects;

/*
 * @author Cecil College | CSC 218 
 * @date created Fri, Apr 15, 2016  2:36:34 AM
 * @last modified Fri, Apr 25, 2016
 * @description This class facilitates combat.
 */

public class QuestManager {
    
    // scanner init
    Scanner io = new Scanner(System.in);
    
    public void startQuest() {
        
        createCharacter();
        sequenceController();
        
    
    }
    
    public void sequenceController() {
        
    }
    
    public void createCharacter() {
        
        // welcoming message and get character name
        String characterCreationMessage1 = "Welcome to my store! What is your name? ";
        System.out.print(characterCreationMessage1); 
        String name = io.next();
        
        //get race
        System.out.println("My apologies, but the great beast Trogdor has blinded me. Could you tell me what you are? (Enter human, lizard, elf)");
        String race = io.next().toLowerCase();
        //check that race is an accepted value
        while (!Objects.equals(race, "lizard") && !Objects.equals(race, "human") && !Objects.equals(race, "elf")){
			System.out.print("Oops, I didn't catch that. Please enter 'lizard', 'human', or 'elf'.");
			race = io.next();
        }
        
        //get type(class)
        System.out.println("Do you battle with a sword, a bow, or a staff? (Enter warrior, ranger, wizard)");
        String type = io.next();
        //check that type is an accepted value
        while (!Objects.equals(type, "lizard") && !Objects.equals(type, "human") && !Objects.equals(type, "elf")){
			System.out.print("Oops, I didn't catch that. Please enter 'lizard', 'human', or 'elf'.");
			type = io.next();
        }
        
        //get base stats
        int strength, dexterity, wisdom, constitution = 20;
        int choice = 0;
        while (true) {
	        System.out.println("Are you 1. strong, 2. dexterous, 3. or wise?");
	        choice = Integer.parseInt(io.next());
	        if (choice==1) {
	        	strength = 20;
	        	dexterity = 10;
	        	wisdom = 15;
	        	break;
	        }
	        else if (choice==2) {
	        	strength = 15;
	        	dexterity = 20;
	        	wisdom = 10;
	        	break;
	        }
	        else if (choice==3) {
	        	strength = 10;
	        	dexterity = 15;
	        	wisdom = 20;
	        	break;
	        }
	        else {System.out.println("Oops, I didn't catch that. Please enter '1', '2', or '3'.");}
        }
        
        Character player = new Character(type, name, race, constitution, strength, dexterity, wisdom);
        
        
    }
    
    // ----
    
    public void sequenceA() {
        
    }
    
    public void sequenceB() {
        
    }
    
    public void sequenceC() {
        
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
    
    public void sequenceC4() {
        
    }
    
    // ----
       
} // end class