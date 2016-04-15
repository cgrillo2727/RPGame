/**
 * 
 *@author Catherine Grillo
 *@date created 03/17/2016
 *@date updated 04/15/2016
 *Originally CSC 218.01 Midterm. Now just test program
 *Allow user to create 2 characters and have them battle
 *
 *Current battle simulation works but does not incorporate all aspects of the character. This is simply a leftover program that,
 *with a little tweaking, allowed me to test out many changes I made to the Attributes class and the CreateChar class
 */

//import scanner for user input
import java.util.Objects;
import java.util.Scanner;

public class BattleSimulation {

	public static void main(String[] args) throws java.io.IOException{
		CreateChar chars[] = new CreateChar[2];
		//create new scanner instance user_input
		Scanner user_input = new Scanner(System.in);
		try {
			//loop until user has made 2 characters
			for (int i = 0; i<2; i++) {
				
				//get character type
				System.out.println("Would you like your character to be a wizard, a warrior, or a ranger?");
				String type = user_input.next();
				//make sure it it is a valid type
				while (!Objects.equals(type, "wizard") && !Objects.equals(type,  "warrior") && !Objects.equals(type,  "ranger")){
					System.out.println("Oops, I didn't catch that. Please enter 'wizard', 'warrior', or 'ranger'.");
					type = user_input.next();
				}
				
				//get character race.
				System.out.println("What would you like your character to be a lizard, a human, or an elf?");
				String race = user_input.next();
				while (!Objects.equals(race, "lizard") && !Objects.equals(race, "human") && !Objects.equals(race, "elf")){
					System.out.println("Oops, I didn't catch that. Please enter 'lizard', 'human', or 'elf'.");
					race = user_input.next();
				}
				
				//get character name
				System.out.println("What would you like to name your character?");
				String name = user_input.next();
				
				//initialize character
				chars[i] = new CreateChar(name, race, type, 20, 15, 12, 20);
				chars[i].printchar();
			}
			
			//Battle simulation
			System.out.println("Let's see who wins in a fight.\n");

			//set initial distance from each other
			int dist = 20;
			
			//decide who goes first
			double first = Math.random();
			int f,s,n;
			if (first <0.5) {f = 0; s = 1;}
			else {f = 1; s = 0;}
			
			System.out.println(chars[f].name+" is now fighting "+chars[s].name);
			
			while (true) {
				if (Objects.equals(chars[f].type, "warrior")) {
					//fighter closes the distance
					if (dist>0) {
						System.out.println(chars[f].name + " runs up to "+chars[s].name);
						dist = 0;
					}
					//hit opponent
					System.out.println(chars[f].name+ " swings their "+chars[f].weapon+" at "+chars[s].name);
					chars[s].loseHealth(chars[f].ap);
				}//end fighter turn
				
				else if (Objects.equals(chars[f].type, "ranger")) {
					//ranger backs up
					if (dist==0) {
						System.out.println(chars[f].name + " backs away from "+chars[s].name);
						dist = 20;
					}
					//hit opponent
					System.out.println(chars[f].name+ " shoots their "+chars[f].weapon+" at "+chars[s].name);
					chars[s].loseHealth(chars[f].ap);
				}//end ranger turn
				
				else if (Objects.equals(chars[f].type, "wizard")) {
					//sorcerer backs up
					if (dist==0) {
						System.out.println(chars[f].name + " backs away from "+chars[s].name);
						dist = 20;
					}
					//hit opponent
					System.out.println(chars[f].name+ " uses their "+chars[f].weapon+" to cast a spell on "+chars[s].name);
					chars[s].loseHealth(chars[f].ap);
				}//end sorcerer turn
				
				
				if (chars[s].currenthp==0) {
					System.out.println(chars[f].name+" has defeated "+chars[s].name);
					break;
				}//end if chars[s] dies
				
				else if (chars[f].currenthp==0) {
					System.out.println(chars[s].name+" has defeated "+chars[f].name);
					break;
				}//end if chars[f] dies
				
				//switch character turn
				n = s;
				s = f;
				f = n;
			}//end while
			
			//reset current health of both characters to  total health
			chars[f].currenthp = chars[f].totalhp;
			chars[s].currenthp = chars[s].totalhp;
		}//end try
		
		//close scanner
		finally {
			user_input.close();
		}//end finally
	}//end main

}//end class CharacterCreation
