package RPG.Game;
/**
 *
 *@author Catherine Grillo
 *@date created 03/17/2016
 *@date updated 04/17/2016
 *Originally CSC 218.01 Midterm. Now just test program
 *Allow user to create 2 characters and have them battle
 *
 *Current battle simulation works but does not incorporate all aspects of the character. This is simply a leftover
 *program that,with a little tweaking, allowed me to test out many changes I made to the Attributes class and the 
 *CreateChar class
 */

//import scanner for user input
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class BattleSimulation {


	public BattleSimulation() {
		try {
			Battle();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void Battle() throws IOException{
		Character chars[] = new Character[2];
		//create new scanner instance user_input
		Scanner user_input = new Scanner(System.in);
		try {
			//loop until user has made 2 characters
			for (int i = 0; i<2; i++) {

				//get character type
				System.out.print("Would you like your character to be a wizard, a warrior, or a ranger?");
				String type = user_input.next();
				//make sure it it is a valid type
				while (!Objects.equals(type, "wizard") && !Objects.equals(type,  "warrior") && !Objects.equals(type,  "ranger")){
					System.out.print("Oops, I didn't catch that. Please enter 'wizard', 'warrior', or 'ranger'.");
					type = user_input.next();
				}

				//get character race.
				System.out.print("Would you like your character to be a lizard, a human, or an elf?");
				String race = user_input.next();
				while (!Objects.equals(race, "lizard") && !Objects.equals(race, "human") && !Objects.equals(race, "elf")){
					System.out.print("Oops, I didn't catch that. Please enter 'lizard', 'human', or 'elf'.");
					race = user_input.next();
				}

				//get character name
				System.out.println("What would you like to name your character?");
				String name = user_input.next();

				//get character stats
				System.out.println("Distribute 60 points among four attributes.\n\tConstitution determines your health."
						+ "\n\tStrength determines your melee attack power.\n\tDexterity determines your ranged attack power."
						+ "\n\tWisdom determines your magical attack power.");

				System.out.print("Set your constitution: ");
				int con = Integer.parseInt(user_input.next());
				System.out.print("Set your strength: ");
				int str = Integer.parseInt(user_input.next());
				System.out.print("Set your dexterity: ");
				int dex = Integer.parseInt(user_input.next());
				System.out.print("Set your wisdom: ");
				int wis = Integer.parseInt(user_input.next());

				while ((con+str+dex+wis) != 60){
					System.out.println("Oops, your attributes did not add up to 60. Please try again.");
					con = Integer.parseInt(user_input.next());
					System.out.print("Set your strength: ");
					str = Integer.parseInt(user_input.next());
					System.out.print("Set your dexterity: ");
					dex = Integer.parseInt(user_input.next());
					System.out.print("Set your wisdom: ");
					wis = Integer.parseInt(user_input.next());

				}

				//initialize character
				chars[i] = new Character(name, race, type, con, str, dex, wis);
				chars[i].printchar();
			}

			//run simulation many times
			String ans = "y";
			while (Objects.equals(ans, "y")) {

				//Battle simulation
				System.out.println("Let's see who wins in a fight.\n");

				//set initial distance from each other
				int dist = 20;

				//decide who goes first
				double first = Math.random();
				int f,s,n;
				if (first <0.5) {f = 0; s = 1;}
				else {f = 1; s = 0;}

				System.out.println(chars[f].getName()+" is now fighting "+chars[s].getName());

				while (true) {
					if (Objects.equals(chars[f].getType(), "warrior")) {
						//fighter closes the distance
						if (dist>0) {
							System.out.println(chars[f].getName() + " runs up to "+ chars[s].getName());
							dist = 0;
						}
						//hit opponent
						System.out.println(chars[f].getName() + " swings their "+ chars[f].getWeapon() +" at "+ chars[s].getName());
						// todo chars[s].loseHealth(chars[f].ap);
					}//end fighter turn

					else if (Objects.equals(chars[f].getType(), "ranger")) {
						//ranger backs up
						if (dist==0) {
							System.out.println(chars[f].getName() + " backs away from "+ chars[s].getName());
							dist = 20;
						}
						//hit opponent
						System.out.println(chars[f].getName() + " shoots their "+ chars[f].getWeapon() +" at "+ chars[s].getName());
						// todo chars[s].loseHealth(chars[f].ap);
					}//end ranger turn

					else if (Objects.equals(chars[f].getType(), "wizard")) {
						//sorcerer backs up
						if (dist==0) {
							System.out.println(chars[f].getName() + " backs away from "+ chars[s].getName());
							dist = 20;
						}
						//hit opponent
						System.out.println(chars[f].getName() + " uses their "+ chars[f].getWeapon() +" to cast a spell on "+ chars[s].getName());
						// todo chars[s].loseHealth(chars[f].ap);
					}//end sorcerer turn


					if (chars[s].getCurrentHealth()==0) {
						System.out.println(chars[f].getName() +" has defeated "+ chars[s].getName());
						break;
					}//end if chars[s] dies

					else if (chars[f].getCurrentHealth()==0) {
						System.out.println(chars[s].getName() +" has defeated "+ chars[f].getName());
						break;
					}//end if chars[f] dies

					//switch character turn
					n = s;
					s = f;
					f = n;
				}//end while for battle

				//reset current health of both characters to  total health
				chars[f].setCurrentHealth(chars[f].getMaxHP());
				chars[f].setCurrentHealth(chars[s].getMaxHP());

				System.out.println("Would you like them to fight again? Type 'y' or 'n'.");
				ans = user_input.next();
			}//end while for repeating battle
		}//end try

		//close scanner
		finally {
			user_input.close();
		}//end finally
	}//end main

}//end class CharacterCreation