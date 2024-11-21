import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PokemonLoader {
    public static List<Pokemon> loadPokemonFromCSV(String fileName) {
        List<Pokemon> pokemonList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Pokemon pokemon = new Pokemon(
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