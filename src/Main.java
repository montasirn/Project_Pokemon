import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pokemon player1Pokemon = null;
        Pokemon player2Pokemon = null;

        List<Pokemon> availablePokemon = PokemonLoader.loadPokemonFromCSV("src/pokemon.csv");

        // Now you can use these Pokémon in your game
        for (Pokemon pokemon : availablePokemon) {
            System.out.println(pokemon.getName());
        }
    }
}