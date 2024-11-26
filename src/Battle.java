import java.util.Random;
import java.util.Scanner;
/**
 * Represents a battle between two Pokémon.
 * This class manages the battle flow, turn-taking, and damage calculations.
 */
public class Battle {
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Random random;
    private Scanner scanner;
    /**
     * Constructs a new Battle with a player's Pokémon and a randomly encountered opponent.
     *
     * @param pokemon1 The player's Pokémon
     */
    public Battle(Pokemon pokemon1) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = Pokemon.randomEncounter(pokemon1.getLevel());
        MovesTest.setMovesForPokemon(pokemon2); // Ensure moves are set for the encountered Pokémon
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }
    /**
     * Starts and manages the battle sequence.
     * This method handles the main battle loop, turn-taking, and determines the winner.
     * It also awards experience points to the player's Pokémon if victorious.
     */
    public void start() {
        System.out.println("Battle starts between " + pokemon1.getName() + " (Level " + pokemon1.getLevel() + ") and "
                + pokemon2.getName() + " (Level " + pokemon2.getLevel() + ")!");
        System.out.println(pokemon1.getName() + " HP: " + pokemon1.getStat("hp") + "/" + pokemon1.getMaxHp());
        System.out.println(pokemon2.getName() + " HP: " + pokemon2.getStat("hp") + "/" + pokemon2.getMaxHp());

        while (pokemon1.getStat("hp") > 0 && pokemon2.getStat("hp") > 0) {
            turn(pokemon1, pokemon2);
            if (pokemon2.getStat("hp") <= 0) break;
            turn(pokemon2, pokemon1);
        }

        Pokemon winner = pokemon1.getStat("hp") > 0 ? pokemon1 : pokemon2;
        Pokemon loser = winner == pokemon1 ? pokemon2 : pokemon1;
        System.out.println(winner.getName() + " wins the battle!");

        if (winner == pokemon1) {
            int expGained = loser.getLevel() * 10; // Simple experience calculation
            pokemon1.gainExperience(expGained);
            System.out.println(pokemon1.getName() + " gained " + expGained + " experience points!");
        }
    }
    /**
     * Executes a single turn for the attacking Pokémon.
     * Prompts for move selection, validates the choice, and applies damage.
     *
     * @param attacker The Pokémon taking its turn
     * @param defender The opposing Pokémon
     */
    private void turn(Pokemon attacker, Pokemon defender) {
        System.out.println("\n" + attacker.getName() + "'s turn:");
        System.out.println("Choose a move:");
        for (int i = 0; i < 4; i++) {
            MovesTest.movesList move = attacker.getMove(i);
            if (move != null) {
                System.out.println((i+1) + ". " + move);
            }
        }

        int moveChoice = scanner.nextInt() - 1;

        // Validate move choice
        if (moveChoice < 0 || moveChoice >= 4 || attacker.getMove(moveChoice) == null) {
            System.out.println("Invalid choice. Skipping turn.");
            return;
        }

        MovesTest.movesList chosenMove = attacker.getMove(moveChoice);

        int damage = calculateDamage(attacker, defender, chosenMove);
        defender.takeDamage(damage);

        System.out.println(attacker.getName() + " used " + chosenMove + "!");
        System.out.println(defender.getName() + " took " + damage + " damage!");
        System.out.println(defender.getName() + " HP: " + defender.getStat("hp"));
    }
    /**
     * Calculates the damage dealt by an attack.
     *
     * @param attacker The attacking Pokémon
     * @param defender The defending Pokémon
     * @param move The move being used
     * @return The calculated damage as an integer
     */
    private int calculateDamage(Pokemon attacker, Pokemon defender, MovesTest.movesList move) {
        String powerStr = attacker.getMovesPower(move);

        // Handle case where powerStr might be null
        if (powerStr == null) {
            System.out.println("Move power not found for " + move);
            return 0; // Or some default damage value
        }

        int baseDamage = Integer.parseInt(powerStr);
        int attack = attacker.getStat("attack");
        int defense = defender.getStat("defense");

        double damageMultiplier = (random.nextDouble() * 0.2 + 0.9); // Random between 0.9 and 1.1
        return (int) (((double) ((2 * attacker.getLevel() + 2) * baseDamage * (attack / defense)) / 50 + 2) * damageMultiplier);
    }
}
