package RPG.Game;

import java.util.Objects;
import java.util.Scanner;


public class CreateCharacter {
	public static Character createCharacter()throws InterruptedException {
        Scanner io = go.getScanner();
		String name;
		String EricLake="Eric Lake";
	    // welcoming message and get character name
	    System.out.println( "Shopkeeper: Welcome to my store! Please tell me your name");
		name = io.next();
		System.out.println("Shopkeeper: Ahh, " + name + ", I would have been able to guess it had i been my old self.");
		Thread.sleep(2300);
	    System.out.println("Shopkeeper: This old magic is failing me, ever since...");

		Thread.sleep(1000);
		System.out.println(".");
		Thread.sleep(1000);
		System.out.println("..");
		Thread.sleep(1000);
		System.out.println("...");
		Thread.sleep(2000);
	    //get race
	    System.out.println("My apologies, but the great beast Trogdor has blinded me.");
		Thread.sleep(1000);
		System.out.println("Could you tell me what you are? (Enter human, lizard, elf)");
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
	    while (!Objects.equals(type, "warrior") && !Objects.equals(type, "ranger") && !Objects.equals(type, "wizard")){
			System.out.print("Oops, I didn't catch that. Please enter \"warrior\", \"ranger\', or \"wizard\".");
			type = io.next();
	    }
	    
	    //get base stats
	    int strength, dexterity, wisdom, constitution = 20;
	    int choice = 0;
	    while (true) {
	        System.out.println("Are you 1. strong, 2. dexterous, 3. or wise? (hint: pick a number to make a selection, then hit the ENTER key)");
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

	    
	    return player;
	}

}
