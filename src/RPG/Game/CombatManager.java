package RPG.Game;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
/*
 * @author Ian Gompers, Catherine Grillo
 * @date created Fri, Apr 15, 2016  2:36:34 AM
 * @last modified Fri, Apr 23, 2016
 * @description This class facilitates combat.
 */
public class CombatManager {

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
	static void loseHealth(Character player, double damage) {
		damage = damage*(1-player.getDefense());
		player.setCurrentHealth(player.getCurrentHealth()-damage);

		System.out.printf(player.getName()+" took %.2f points of damage.\n",damage);

		if (player.getCurrentHealth() <=0) {
			System.out.println(player.getName()+" has died");
			player.setCurrentHealth(0);
		}
		else {
			System.out.printf(player.getName()+" has %.2f health left.\n\n",player.getCurrentHealth());
		}
	}

	static boolean hit(Character player, double mod) {
		boolean hits;
		double chance = Math.random();
		if (chance<(player.getAccuracy()+mod)) {hits = true;}
		else {hits = false;}
		return hits;
	}

	static void reduceCounter(Character player) {
		if (player.getDefending()) {
			player.setCounter(player.getCounter()-1);
			if (player.getCounter()==0) {
				player.setDefending(false);
				player.setDefense(player.getDefense()-0.05);
				System.out.println(player.getName()+" has lost their defense bonus.");
			}
		}
	}

	static void attack(Character attacker, Character defender, int choice) {
		double damage = 0;
		if (choice==1) {
			//precision attack
			if (hit(attacker, .1)) {
				damage = 20*(1+attacker.getAttack());
				System.out.println(attacker.getName()+" hit with their Precision Attack.\n");
			}
			else {
				System.out.println(attacker.getName()+" missed with their Precision Attack.\n");
			}
		}
		else if (choice==2) {
			//strong attack
			if (hit(attacker, 0)) {
				damage = 20*(1.1+attacker.getAttack());
				System.out.println(attacker.getName()+" hit with their Strong Attack.\n");
			}
			else {
				System.out.println(attacker.getName()+" missed with their Strong Attack.\n");
			}
		}
		else {
			//defend
			attacker.setDefending(true);
			attacker.setDefense(attacker.getDefense()+0.05);
			attacker.setCounter(2);
			System.out.println(attacker.getName()+" is Defending.\n");
		}
		if (damage>0) {loseHealth(defender,damage);}
	}

	static void initiateCombatSession(Character player, Character npc) {

		Scanner user_input = new Scanner(System.in);
		try {
			System.out.println(player.getName()+" is now fighting "+npc.getName());
			while (true) {
				//player's turn
				System.out.println("It is "+player.getName()+"'s turn.");

				reduceCounter(player);

				System.out.println("Select one:\n1. Precision Attack: normal damage, high accuracy"
						+ "\n2. Strong Attack: high damage, normal accuracy"
						+ "\n3. Defend: Increase defense for 2 rounds");
				int choice = Integer.parseInt(user_input.next());
				attack(player, npc, choice);

				if (npc.getCurrentHealth()==0) {
					System.out.println("Yay! "+player.getName()+" defeated "+npc.getName()+"!");
					break;
				}


				//npc's turn
				System.out.println("It is "+npc.getName()+"'s turn.");

				reduceCounter(npc);

				choice = ThreadLocalRandom.current().nextInt(1, 4);
				attack(npc, player, choice);

				if (player.getCurrentHealth()==0) {
					System.out.println("Oh no! "+player.getName()+" lost to "+npc.getName()+"!");
					break;
				}

			}

		}//end try
		finally {
			user_input.close();
		}//end finally
	}





} // end CombatManager class