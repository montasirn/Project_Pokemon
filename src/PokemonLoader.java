import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * The PokemonLoader class is responsible for loading Pokémon data from a CSV file.
 * This class provides a method to read Pokémon attributes and create corresponding
 * Pokémon objects.
 */
public class PokemonLoader {
    public static List<Pokemon> loadPokemonFromCSV(String fileName) {
        List<Pokemon> pokemonList = new ArrayList<>();
/**
 * Loads Pokémon data from a specified CSV file and returns a list of Pokémon objects.
 *
 * The CSV file is expected to have the following structure:
 * <pre>
 * ID, Name, Type1, Type2, ..., HP, Attack, Defense, SpecialAttack, SpecialDefense, Speed
 * </pre>
 * The first line of the file is assumed to be a header and is skipped.
 *
 * @param fileName The path to the CSV file containing Pokémon data.
 * @return A list of Pokémon objects created from the data in the CSV file.
 */
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Pokemon pokemon = new Pokemon(
                        Integer.parseInt(data[0]),
                        data[1], // Name
                        data[2], // Type1
                        data[3], // Type2
                        Integer.parseInt(data[5]), // HP
                        Integer.parseInt(data[6]), // Attack
                        Integer.parseInt(data[7]), // Defense
                        Integer.parseInt(data[8]), // SpecialAttack
                        Integer.parseInt(data[9]), // SpecialDefense
                        Integer.parseInt(data[10])  // Speed
                );
                pokemonList.add(pokemon);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pokemonList;
    }
}