package RPG.Game;

import java.util.Objects;
import java.util.Scanner;



public class CreateCharacter {
	
	public static int testStat(int stat) {
		Scanner io = go.getScanner();
		while (stat>20) {
			System.out.println("Please enter a number below 20.");
			try {
			stat = Integer.parseInt(io.next());
			} catch (NumberFormatException e) {
				System.out.println("Please only enter numbers.");
			}
		}
		return stat;
	}//end testStat method
	
	public static Character createCharacter() {
	    // scanner init
	    Scanner io = go.getScanner();
		
	    // welcoming message and get character name
	    String characterCreationMessage1 = "Shopkeeper: Welcome to my store! What is your name? ";
	    System.out.print(characterCreationMessage1); 
	    String name = io.next();
	    
	    //get race
	    System.out.println("Shopkeeper: My apologies, but the great beast Trogdor has blinded me. Could you tell me what you are? (Enter human, lizard, elf)");
	    String race = io.next().toLowerCase();
	    //check that race is an accepted value
	    while (!Objects.equals(race, "lizard") && !Objects.equals(race, "human") && !Objects.equals(race, "elf")){
			System.out.print("Oops, I didn't catch that. Please enter 'lizard', 'human', or 'elf'.");
			race = io.next().toLowerCase();
	    }
	    
	    //get type(class)
	    System.out.println("Shopkeeper: Do you battle with a sword, a bow, or a staff? (Enter warrior, ranger, wizard)");
	    String type = io.next().toLowerCase();
	    //check that type is an accepted value
	    while (!Objects.equals(type, "warrior") && !Objects.equals(type, "ranger") && !Objects.equals(type, "wizard")){
			System.out.print("Shopkeeper: Oops, I didn't catch that. Please enter 'warrior', 'ranger', or 'wizard'.");
			type = io.next().toLowerCase();
	    }
	    
	    //get base stats
	    int strength = 0, dexterity = 0, wisdom = 0, constitution = 0;
	    System.out.println("Distribute 60 points among four attributes. No attribute can be greater than 20."
	    		+ "\n\tConstitution determines your health."
				+ "\n\tStrength determines your melee attack power.\n\tDexterity determines your ranged attack power."
				+ "\n\tWisdom determines your magical attack power.");
	    while ((constitution+strength+dexterity+wisdom) != 60){
		    try {
				System.out.print("Set your constitution: ");
				constitution = Integer.parseInt(io.next());
				constitution = testStat(constitution);
				
				System.out.print("Set your strength: ");
				strength = Integer.parseInt(io.next());
				strength = testStat(strength);
				
				System.out.print("Set your dexterity: ");
				dexterity = Integer.parseInt(io.next());
				dexterity = testStat(dexterity);
				
				System.out.print("Set your wisdom: ");
				wisdom = Integer.parseInt(io.next());
				wisdom = testStat(wisdom);
				
			} catch (NumberFormatException e) {
				System.out.println("Oops, you must only enter numbers!");
			}
	    }
	    
	    Character player = new Character(type, name, race, constitution, strength, dexterity, wisdom);
	    
	    return player;
	}//end createCharacter method
	
	
	public CreateCharacter() {
		
	}
	
	
	
	/*//test createCharacter class
	public static void main(String args[]) {
		Character player = createCharacter();
		player.printchar();
	}
	*/
}//end CreateCharacter class
