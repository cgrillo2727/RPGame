package RPG.Game;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
/*
 * @author Ian Gompers, Catherine Grillo
 * @date created Fri, Apr 15, 2016  2:36:34 AM
 * @last modified Fri, Apr 25, 2016
 * @description This class facilitates combat.
 */
public class CombatManager {
	
	//
	static void setStates(Character player) {
		if (Objects.equals(player.getType(), "warrior")) {
			player.setDefense(0.1+player.getConstitution()/100.0);
			player.setAttack(0.05+player.getWeaponBonus()+player.getStrength()/100.0);			
			player.setAccuracy(0.80);
		}
		else if (Objects.equals(player.getType(), "wizard")) {
			player.setDefense(player.getConstitution()/100.0);
			player.setAttack(0.1+player.getWeaponBonus()+player.getWisdom()/100.0);
			player.setAccuracy(0.85);
		}
		else {
			player.setDefense(0.05+player.getConstitution()/100.0);
			player.setAttack(player.getWeaponBonus()+player.getDexterity()/100.0);
			player.setAccuracy(0.90);
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
		damage = damage*(1-player.getDefense());
		player.setCurrentHealth(player.getCurrentHealth()-damage);
		
        System.out.printf(player.getName()+" Took %.2f damage.\n", damage);
		Thread.sleep(2000);


		
		if (player.getCurrentHealth() <=0) {
			System.out.println(player.getName()+" has died");
			Thread.sleep(1600);
			player.setCurrentHealth(0);
		}
		else {
			System.out.printf(player.getName()+ " has %.2f health left.\n\n",player.getCurrentHealth());
			Thread.sleep(2000);
		}
	}
	
	static boolean hit(Character player, double mod) {
		boolean hits;
		double chance = Math.random();
		if (chance<(player.getAccuracy()+mod)) {hits = true;}
		else {hits = false;}
		return hits;
	}
	
	static void reduceCounter(Character player) throws InterruptedException{
		if (player.getDefending()) {
			player.setCounter(player.getCounter()-1);
			if (player.getCounter()==0) {
				player.setDefending(false);
				player.setDefense(player.getDefense()-0.05);
				System.out.println(player.getName()+" has lost their defense bonus.");
				Thread.sleep(1600);
			}
		}
	}
	
	static void attack(Character attacker, Character defender, int choice) throws InterruptedException{
		double damage = 0;
		if (choice==1) {
			//precision attack
			if (hit(attacker, .1)) {
				damage = 20*(1+attacker.getAttack());
				System.out.println(attacker.getName()+" hit with their Precision Attack.\n");
				Thread.sleep(2000);
			}
			else {
				System.out.println(attacker.getName()+" missed with their Precision Attack.\n");
				Thread.sleep(2000);
			}
		}
		else if (choice==2) {
			//strong attack
			if (hit(attacker, 0)) {
				damage = 20*(1.1+attacker.getAttack());
				System.out.println(attacker.getName()+" hit with their Strong Attack.\n");
				Thread.sleep(2000);
			}
			else {
				System.out.println(attacker.getName()+" missed with their Strong Attack.\n");
				Thread.sleep(2000);
			}
		}
		else {
			//defend
			attacker.setDefending(true);
			attacker.setDefense(attacker.getDefense()+0.1);
			attacker.setCounter(2);	
			System.out.println(attacker.getName()+" is Defending.\n");
			Thread.sleep(1600);
		}
		if (damage>0) {loseHealth(defender,damage);}
	}
	
	static void runCombat(Character player, Character npc) throws InterruptedException{

		Scanner io = go.getScanner();
			System.out.println(player.getName()+" is now fighting "+npc.getName()+".");
			Thread.sleep(1000);
			while (true) {
				//player's turn
				System.out.println("It is "+player.getName()+"'s turn.\n");
				Thread.sleep(1000);

				reduceCounter(player);
				
				int choice = 0;
				
				while(choice<1 || choice >3) {
					System.out.println("Select an action:");
					Thread.sleep(1000);
					System.out.println("1. Precision Attack: normal damage, high accuracy");
					Thread.sleep(2000);
					System.out.println("2. Strong Attack: high damage, normal accuracy");
					Thread.sleep(2000);
					System.out.println("3. Defend: Increase defense for 2 rounds");
					try {
						choice = Integer.parseInt(io.next());
					} catch (NumberFormatException e) {
						System.out.println("Oops, I didn't understand that. Please only enter a number.");
						Thread.sleep(2000);
					}
				}
				
				attack(player, npc, choice);
				
				if (npc.getCurrentHealth()==0) {
					System.out.println("Yay! "+player.getName()+" defeated "+npc.getName()+"!");
					Thread.sleep(1600);
					break;
				}
				
				
				//npc's turn
				System.out.println("It is "+npc.getName()+"'s turn.");
				Thread.sleep(1600);

				reduceCounter(npc);
				if (npc.getDefending()) {choice = ThreadLocalRandom.current().nextInt(1, 3);}
				else {choice = ThreadLocalRandom.current().nextInt(1, 4);}
				attack(npc, player, choice);
				
				if (player.getCurrentHealth()==0) {
					System.out.println("Oh no! "+player.getName()+" lost to "+npc.getName()+"!");
					Thread.sleep(1600);
					break;
				}
				
			}

	}
	
	static void initiateCombatSession(Character player, Character npc) throws InterruptedException{
		setStates(player);
		setStates(npc);
		runCombat(player,npc);
	}

	

	
} // end CombatManager class
