package RPG.Game;

import java.lang.*;

/**
 *
 * @author CatherineGrillo
 * @dateCreated 4/24/2016
 * @dateUpdated 4/24/2016
 * Just a short test program I used to run the combatManager to work out the kinks.

public class TestCombatManager extends CombatManager{

	public static void main(String[] args) {
		Character player = new Character("warrior", "John", "human", 20, 20, 10, 10);
		Character npc = new Character("wizard", "NPC", "lizard", 15, 12, 13, 20);

		setStates(player);
		setStates(npc);

		//player.printchar();
		//npc.printchar();

		initiateCombatSession(player, npc);
	}

} */