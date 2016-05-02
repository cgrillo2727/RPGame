package RPG.Game;

import java.util.Objects;
import java.util.Scanner;


public class CreateCharacter {
	
	//check user input to make sure it is of right type and within range
	public static int testStat(String input) throws InterruptedException{
		Scanner io = go.getScanner();
		//initialize stat so that , if it is not modified, it will enter the while loop
		int stat = 21;
		
		//try to parse input. If it fails, catch error and notify user.
		try {
			stat = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("You must only enter numbers!");
			Thread.sleep(2000);
		}
		//if input could not be parsed or was too large, get new input.
		while (stat>20) {
			//repeat instructions in case user did not understand previously
			System.out.println("Please enter a number below 20.");
			try {
				stat = Integer.parseInt(io.next());
			} catch (NumberFormatException e) {
				System.out.println("You must only enter numbers!");
				Thread.sleep(2000);
			}
		}
		//return checked stat
		return stat;
	}//end testStat method
	
	
	//primary method to make character
	public static Character createCharacter() throws InterruptedException{
	    // scanner init
	    Scanner io = go.getScanner();
		System.out.println("You walk into town and enter a shop.");
		Thread.sleep(1600);
		
	    // welcoming message and get character name
	    String characterCreationMessage1 = "Welcome to my store! What is your name? ";
	    System.out.println(characterCreationMessage1);
        System.out.print("> ");
	    String name = io.next();
	    
	    //get race
	    System.out.println("My apologies, but the great beast Trogdor has blinded me. Could you tell me what you are? (Enter human, lizard, elf)");
        System.out.print("> ");
	    String race = io.next().toLowerCase();
	    //check that race is an accepted value
	    while (!Objects.equals(race, "lizard") && !Objects.equals(race, "human") && !Objects.equals(race, "elf")){
			System.out.println("Oops, I didn't catch that. Please enter 'lizard', 'human', or 'elf'.");
            System.out.print("> ");
			race = io.next().toLowerCase();
	    }
	    
	    //get type(class)
	    System.out.println("Do you battle with a sword, a bow, or a staff? (Enter warrior, ranger, wizard)");
        System.out.print("> ");
	    String type = io.next().toLowerCase();
	    //check that type is an accepted value
	    while (!Objects.equals(type, "warrior") && !Objects.equals(type, "ranger") && !Objects.equals(type, "wizard")){
			System.out.println("Oops, I didn't catch that. Please enter 'warrior', 'ranger', or 'wizard'.");
            System.out.print("> ");
			type = io.next().toLowerCase();
	    }
	    
	    //get base stats
	    //initialize string variables to hold user input before it is parsed
	    String str, dex, wis, con;
	    //initialize int variables so that the while loop runs at beginning.
	    int strength = 21, dexterity = 21, wisdom = 21, constitution = 21;
	    //print out instructions to user
	    System.out.println("Distribute 60 points among four attributes.");
	    Thread.sleep(2000);
	    System.out.println("\tConstitution determines your health.");
	    Thread.sleep(2000);
		System.out.println("\tStrength determines your melee attack power.");
		Thread.sleep(2000);
		System.out.println("\tDexterity determines your ranged attack power.");
		Thread.sleep(2000);
		System.out.println("\tWisdom determines your magical attack power.");
		Thread.sleep(2000);
	    //while stats add up to greater than 60, repeat stat gathering
	    while ((constitution+strength+dexterity+wisdom) > 60){
	    	System.out.println("No attribute can have more than 20 points.");
	    	Thread.sleep(2000);
			System.out.print("Set your constitution: ");
			con = io.next();
			constitution = testStat(con);
			
			System.out.print("Set your strength: ");
			str = io.next();
			strength = testStat(str);
			
			System.out.print("Set your dexterity: ");
			dex = io.next();
			dexterity = testStat(dex);
			
			System.out.print("Set your wisdom: ");
			wis = io.next();
			wisdom = testStat(wis);
	    }
	    
	    Character player = new Character(type, name, race, constitution, strength, dexterity, wisdom);
	    
	    return player;
	}//end createCharacter method
	
	
	/*//test createCharacter class
	public static void main(String args[]) throws InterruptedException{
		Character player = createCharacter();
		player.printchar();
	}*/
	
}//end CreateCharacter class
