import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Set up moves for all Pokémon
        MovesTest.setMoves();

        // Choose starter Pokémon
        Pokemon starter = chooseStarter(scanner);

        // Start continuous battle loop
        while (starter.getStat("hp") > 0) {
            // Create a new battle with a random encounter
            Battle battle = new Battle(starter);
            battle.start();

            // Optional: Heal starter partially after each battle
            int healAmount = starter.getMaxHp() / 2;
            int currentHP = starter.getStat("hp");
            starter.takeDamage(-Math.min(healAmount, starter.getMaxHp() - currentHP));
            if (currentHP <= 0){
                break;
            }
        }


        // Game over when starter faints
        System.out.println("Game Over! Your " + starter.getName() + " has fainted.");
    }

    private static Pokemon chooseStarter(Scanner scanner) {
        System.out.println("Choose your starter pokemon!\n(type name exactly)");
        System.out.println("Charmander \nBulbasaur \nSquirtle ");

        while (true) {
            String starterName = scanner.nextLine();
            Pokemon starter = Pokemon.createPokemon(starterName);

            if (starter != null) {
                System.out.println("You chose " + starter.getName() + "!");
                return starter;
            } else {
                System.out.println("Invalid pokemon. Please choose Charmander, Bulbasaur, or Squirtle.");
            }
        }
    }
}

