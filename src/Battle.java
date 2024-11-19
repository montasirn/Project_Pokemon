import java.util.Random;
import java.util.Scanner;

public class Battle {
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Random random;
    private Scanner scanner;

    public Battle(Pokemon pokemon1, Pokemon pokemon2) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Battle starts between " + pokemon1.getName() + " and " + pokemon2.getName() + "!");

        while (pokemon1.getStat(Pokemon.stat.Health) > 0 && pokemon2.getStat(Pokemon.stat.Health) > 0) {
            turn(pokemon1, pokemon2);
            if (pokemon2.getStat(Pokemon.stat.Health) <= 0) break;
            turn(pokemon2, pokemon1);
        }

        Pokemon winner = pokemon1.getStat(Pokemon.stat.Health) > 0 ? pokemon1 : pokemon2;
        System.out.println(winner.getName() + " wins the battle!");
    }

    private void turn(Pokemon attacker, Pokemon defender) {
        System.out.println("\n" + attacker.getName() + "'s turn:");
        System.out.println("Choose a move:");
        for (int i = 0; i < 4; i++) {
            System.out.println((i+1) + ". " + attacker.getMove(i));
        }

        int moveChoice = scanner.nextInt() - 1;
        MovesTest.movesList chosenMove = attacker.getMove(moveChoice);

        int damage = calculateDamage(attacker, defender, chosenMove);
        defender.takeDamage(damage);

        System.out.println(attacker.getName() + " used " + chosenMove + "!");
        System.out.println(defender.getName() + " took " + damage + " damage!");
        System.out.println(defender.getName() + " HP: " + defender.getStat(Pokemon.stat.Health));
    }

    private int calculateDamage(Pokemon attacker, Pokemon defender, MovesTest.movesList move) {
        int baseDamage = Integer.parseInt(attacker.getMovesPower(move));
        int attack = attacker.getStat(Pokemon.stat.Strength);
        int defense = defender.getStat(Pokemon.stat.Defense);

        double damageMultiplier = (random.nextDouble() * 0.2 + 0.9); // Random between 0.9 and 1.1
        return (int) ((((2 * 50 / 5 + 2) * attack * baseDamage / defense) / 50 + 2) * damageMultiplier);
    }
}