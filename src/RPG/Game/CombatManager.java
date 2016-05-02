package RPG.Game;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
/*
 * @author Ian Gompers, Catherine Grillo
 * @date created Fri, Apr 15, 2016  2:36:34 AM
 * @last modified Fri, Apr 30, 2016
 * @description This class facilitates combat.
 */
public class CombatManager {
	
	//set battle attributes before combat begins
	static void setStates(Character player) {
		//warriors have high defense, medium attack, and low accuracy
		if (Objects.equals(player.getType(), "warrior")) {
			player.setDefense(0.25+player.getConstitution()/100.0);
			player.setAttack(0.4+player.getWeaponBonus()+player.getStrength()/100.0);			
			player.setAccuracy(0.75);
		}
		//wizards have have low defense, high attack, and medium accuracy
		else if (Objects.equals(player.getType(), "wizard")) {
			player.setDefense(player.getConstitution()/100.0);
			player.setAttack(0.6+player.getWeaponBonus()+player.getWisdom()/100.0);
			player.setAccuracy(0.80);
		}
		//rangers have medium defense, low attack, and high accuracy
		else {
			player.setDefense(0.05+player.getConstitution()/100.0);
			player.setAttack(0.5+player.getWeaponBonus()+player.getDexterity()/100.0);
			player.setAccuracy(0.85);
		}
		
		//humans get a racial bonus to defense
		if (Objects.equals(player.getRace(), "human")) {
			player.setDefense(player.getDefense()+player.getRaceBonus());
		}
		//lizards get a racial bonus to attack power
		else if (Objects.equals(player.getRace(), "lizard")) {
			player.setAttack(player.getAttack()+player.getRaceBonus());
		}
		//elves get a racial bonus to accuracy
		else {
			player.setAccuracy(player.getAccuracy()+player.getRaceBonus());
		}
		
	}
	
	//reduce character health
	static void loseHealth(Character player, double damage) throws InterruptedException{
		//reduce damage with defense
		damage = damage*(1-player.getDefense());
		//reduce health
		player.setCurrentHealth(player.getCurrentHealth()-damage);
		//print damage taken
        	System.out.println(player.getName()+" Took "+(int)damage+" damage.");
		Thread.sleep(2000);
		
		//if character's health is reduced to 0 or below
		if (player.getCurrentHealth() <=0) {
			//print that the character has died
			System.out.println(player.getName()+" has died");
			Thread.sleep(1600);
			//set character health to 0 (in case it was negative)
			player.setCurrentHealth(0);
		}
		//else print remaining health
		else {
			System.out.println(player.getName()+ " has "+(int)player.getCurrentHealth()+" health left.\n");
			Thread.sleep(2000);
		}
	}
	
	//determine whether the character hits depending on accuracy, random chance, and type of attack
	static boolean hit(Character player, double mod) {
		boolean hits;
		//set chance to a random double between 0 and 1
		double chance = Math.random();
		//if chance is within range of character accuracy (with attack type modifier), character hits
		if (chance<(player.getAccuracy()+mod)) {hits = true;}
		//else character misses
		else {hits = false;}
		return hits;
	}
	
	//reduce defense counter
	static void reduceCounter(Character player) throws InterruptedException{
		//if character is defending
		if (player.getDefending()) {
			//reduce counter by 1
			player.setCounter(player.getCounter()-1);
			//if this reduces counter to 0
			if (player.getCounter()==0) {
				//player is no longer defending
				player.setDefending(false);
				//player loses defense bonus
				player.setDefense(player.getDefense()-0.05);
				System.out.println(player.getName()+" has lost their defense bonus.");
				Thread.sleep(1600);
			}
		}
	}
	
	//attack/defend based on character choice
	static void attack(Character attacker, Character defender, int choice) throws InterruptedException{
		double damage = 0;
		//precision attack
		if (choice==1) {
			//if character hits with precision bonus
			if (hit(attacker, .1)) {
				//set damage based on attack (no damage bonus)
				damage = 20*(1+attacker.getAttack());
				System.out.println(attacker.getName()+" hit with their Precision Attack.\n");
				Thread.sleep(2000);
			}
			//else damage remains 0
			else {
				System.out.println(attacker.getName()+" missed with their Precision Attack.\n");
				Thread.sleep(2000);
			}
		}
		//strong attack
		else if (choice==2) {
			//if character hits (no precision bonus)
			if (hit(attacker, 0)) {
				//set damage based on attack and damage bonus
				damage = 20*(1.1+attacker.getAttack());
				System.out.println(attacker.getName()+" hit with their Strong Attack.\n");
				Thread.sleep(2000);
			}
			//else damage remains 0
			else {
				System.out.println(attacker.getName()+" missed with their Strong Attack.\n");
				Thread.sleep(2000);
			}
		}
		//defend
		else {
			//character gets a defense bonus for 2 rounds (tracked by the counter)
			attacker.setDefending(true);
			attacker.setDefense(attacker.getDefense()+0.1);
			attacker.setCounter(2);	
			System.out.println(attacker.getName()+" is Defending.\n");
			Thread.sleep(1600);
		}
		//if character hit, take health from opponent
		if (damage>0) {loseHealth(defender,damage);}
	}
	
	//method runs combat
	static boolean runCombat(Character player, Character npc) throws InterruptedException{
		boolean won;
		Scanner io = go.getScanner();
		System.out.println(player.getName()+" is now fighting "+npc.getName()+".\n");
		Thread.sleep(1000);
		player.printchar();
		System.out.println("\n");
		Thread.sleep(2000);
		npc.printchar();
		Thread.sleep(2000);
		//until someone dies, battle continues
		while (true) {
			//player's turn
			System.out.println("It is "+player.getName()+"'s turn.\n");
			Thread.sleep(1000);
			
			//reduce counter if defending
			reduceCounter(player);
			
			int choice = 0;
			
			//get choice of attack/defense from user. loop until they give a valid response
			while(true) {
				System.out.println("Select an action:");
				System.out.println("1. Precision Attack: normal damage, high accuracy");
				System.out.println("2. Strong Attack: high damage, normal accuracy");
				System.out.println("3. Defend: Increase defense for 2 rounds");
            			System.out.print("> ");
				//try to convert input from user to an integer
				try {
					choice = Integer.parseInt(io.next());
				//if the input is not able to be converted, tell user and loop again
				} catch (NumberFormatException e) {
					System.out.println("Oops, I didn't understand that. Please only enter a number.");
					Thread.sleep(2000);
				}
				//if input is too high or low, tell user and loop again
				if (choice<1 || choice >3) {
					System.out.println("Oops, that number was too high or too low. Please enter 1, 2, or 3.");
					Thread.sleep(2000);
				}
				//if input is acceptable, break out of loop
				else {break;}
			}
			
			//determine if the player hits or not, then deal damage accordingly (or set defense bonus)
			attack(player, npc, choice);
			
			//if npc's health is 0
			if (npc.getCurrentHealth()==0) {
				won = true;
				//print victory message
				System.out.println("Yay! "+player.getName()+" defeated "+npc.getName()+"!");
				Thread.sleep(1600);
				//break out of combat
				break;
			}
			
			
			//npc's turn
			System.out.println("It is "+npc.getName()+"'s turn.");
			Thread.sleep(1600);

			//reduce counter if defending
			reduceCounter(npc);
			
			//if npc is defending, randomly select either attack choice (1 or 2). Exclude defend choice (3)
			if (npc.getDefending()) {choice = ThreadLocalRandom.current().nextInt(1, 3);}
			//else choose any of the 3 options at random
			else {choice = ThreadLocalRandom.current().nextInt(1, 4);}
			//determine if the npc hits and deal damage accordingly (or set defense bonus)
			attack(npc, player, choice);
			
			//if player dies
			if (player.getCurrentHealth()==0) {
				won = false;
				//print defeat message
				System.out.println("Oh no! "+player.getName()+" lost to "+npc.getName()+"!");
				Thread.sleep(1600);
				//break out of combat
				break;
			}
			
		}
		return won;
	}
	
	//Constructor that calls all necessary combat methods.
	public static boolean combatManager(Character player, Character npc) throws InterruptedException{
		setStates(player);
		setStates(npc);
		
		return runCombat(player,npc);
	}
	

	
} // end CombatManager class
