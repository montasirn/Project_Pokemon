import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
/**
 * The MovesTest class manages Pokémon moves within the game.
 * It provides methods to define move powers and assign specific moves
 * to Pokémon based on their names.
 */
public class MovesTest {
    /**
     * Enumeration of possible moves available in the game.
     */
    public enum movesList{
        Tackle,
        Vine_Whip,
        Poison_Powder,
        Leech_Seed,
        Scratch,
        Ember,
        Slash,
        Bubble,
        Water_Gun,
        Bite,
        Razor_Leaf,
        Seed_Bomb,
        Take_Down,
        Solar_Beam,
        Fire_Fang,
        Flamethrower,
        Fire_Spin,
        Dragon_Breath,
        Rapid_Spin,
        Water_Pulse,
        Aqua_Tail,
        Hydro_Pump,
        Bug_Bite,
        Gust,
        Confusion,
        Psybeam,
        Air_Slash,
        Poison_Sting,
        Pursuit,
        Poison_Jab,
        Twister,
        Wing_Attack,
        Aerial_Ace,
        Crunch;

    }

    static EnumMap<movesList,String> moves = new EnumMap<movesList,String>(movesList.class);
    /**
     * Default constructor for MovesTest class.
     */
    public MovesTest() {

    }
    /**
     * Initializes the power values for each move in the movesList enumeration.
     * This method populates an EnumMap with move powers.
     */
    public static void setMoves(){
        moves.put(movesList.Tackle, "35");
        moves.put(movesList.Vine_Whip, "35");
        moves.put(movesList.Poison_Powder, "15");
        moves.put(movesList.Leech_Seed, "20");
        moves.put(movesList.Scratch, "40");
        moves.put(movesList.Ember, "40");
        moves.put(movesList.Slash, "70");
        moves.put(movesList.Bubble, "20");
        moves.put(movesList.Water_Gun, "40");
        moves.put(movesList.Bite, "60");
        moves.put(movesList.Razor_Leaf, "55");
        moves.put(movesList.Seed_Bomb, "80");
        moves.put(movesList.Take_Down, "90");
        moves.put(movesList.Solar_Beam, "120");
        moves.put(movesList.Fire_Fang, "65");
        moves.put(movesList.Flamethrower, "90");
        moves.put(movesList.Fire_Spin, "35");
        moves.put(movesList.Dragon_Breath, "60");
        moves.put(movesList.Rapid_Spin, "50");
        moves.put(movesList.Water_Pulse, "60");
        moves.put(movesList.Aqua_Tail, "90");
        moves.put(movesList.Hydro_Pump, "110");
        moves.put(movesList.Bug_Bite, "60");
        moves.put(movesList.Gust, "40");
        moves.put(movesList.Confusion, "50");
        moves.put(movesList.Psybeam, "65");
        moves.put(movesList.Air_Slash, "75");
        moves.put(movesList.Poison_Sting, "15");
        moves.put(movesList.Pursuit, "40");
        moves.put(movesList.Poison_Jab, "80");
        moves.put(movesList.Twister, "40");
        moves.put(movesList.Wing_Attack, "60");
        moves.put(movesList.Aerial_Ace, "60");
        moves.put(movesList.Crunch, "80");
    }
    /**
     * Retrieves the power associated with a specified move.
     *
     * @param move The move for which to retrieve power information.
     * @return The power of the specified move as a string or null if not found.
     */
    public static String getMovesPower(movesList move) {
        return moves.get(move);
    }
    /**
     * Assigns specific moves to Pokémon based on their names.
     * This method loads available Pokémon from a CSV file and assigns
     * appropriate moves using a switch-case statement based on
     * each Pokémon's name.
     */
    public static void instanciateMoves() {
        List<Pokemon> availablePokemon = PokemonLoader.loadPokemonFromCSV("src/pokemon.csv");

        for (Pokemon p : availablePokemon) {
            switch (p.getName()) {
                case "Bulbasaur":
                    p.setMoves(movesList.Tackle, movesList.Vine_Whip, movesList.Poison_Powder, movesList.Leech_Seed);
                    break;
                case "Ivysaur":
                    p.setMoves(movesList.Tackle, movesList.Razor_Leaf, movesList.Poison_Powder, movesList.Seed_Bomb);
                    break;
                case "Venusaur":
                    p.setMoves(movesList.Tackle, movesList.Razor_Leaf, movesList.Seed_Bomb, movesList.Solar_Beam);
                    break;
                case "Charmander":
                    p.setMoves(movesList.Scratch, movesList.Ember, movesList.Tackle, movesList.Fire_Spin);
                    break;
                case "Charmeleon":
                    p.setMoves(movesList.Slash, movesList.Take_Down, movesList.Fire_Fang, movesList.Flamethrower);
                    break;
                case "Charizard":
                    p.setMoves(movesList.Slash, movesList.Flamethrower, movesList.Dragon_Breath, movesList.Aerial_Ace);
                    break;
                case "Squirtle":
                    p.setMoves(movesList.Tackle, movesList.Water_Gun, movesList.Bite, movesList.Rapid_Spin);
                    break;
                case "Wartortle":
                    p.setMoves(movesList.Bite, movesList.Water_Pulse, movesList.Aqua_Tail, movesList.Take_Down);
                    break;
                case "Blastoise":
                    p.setMoves(movesList.Bite, movesList.Hydro_Pump, movesList.Aqua_Tail, movesList.Rapid_Spin);
                    break;
                case "Caterpie":
                    p.setMoves(movesList.Tackle, movesList.Bug_Bite, null, null);
                    break;
                case "Metapod":
                    p.setMoves(movesList.Tackle, null, null, null);
                    break;
                case "Butterfree":
                    p.setMoves(movesList.Confusion, movesList.Gust, movesList.Psybeam, movesList.Air_Slash);
                    break;
                case "Weedle":
                    p.setMoves(movesList.Poison_Sting, movesList.Bug_Bite, null, null);
                    break;
                case "Kakuna":
                    p.setMoves(movesList.Tackle, null, null, null);
                    break;
                case "Beedrill":
                    p.setMoves(movesList.Bug_Bite, movesList.Poison_Sting, movesList.Pursuit, movesList.Poison_Jab);
                    break;
                case "Pidgey":
                    p.setMoves(movesList.Tackle, movesList.Gust, movesList.Wing_Attack, movesList.Twister);
                    break;
                case "Pidgeotto":
                    p.setMoves(movesList.Twister, movesList.Gust, movesList.Wing_Attack, movesList.Aerial_Ace);
                    break;
                case "Pidgeot":
                    p.setMoves(movesList.Gust, movesList.Aerial_Ace, movesList.Air_Slash, movesList.Crunch);
                    break;
                case "Rattata":
                    p.setMoves(movesList.Tackle, movesList.Bite, movesList.Fire_Fang, movesList.Crunch);
                    break;
                case "Raticate":
                    p.setMoves(movesList.Crunch, movesList.Fire_Fang, movesList.Slash, movesList.Poison_Jab);
                    break;
            }
        }
    }

    public static void setMovesForPokemon(Pokemon p) {
            switch (p.getName()) {
                case "Bulbasaur":
                    p.setMoves(movesList.Tackle, movesList.Vine_Whip, movesList.Poison_Powder, movesList.Leech_Seed);
                    break;
                case "Ivysaur":
                    p.setMoves(movesList.Tackle, movesList.Razor_Leaf, movesList.Poison_Powder, movesList.Seed_Bomb);
                    break;
                case "Venusaur":
                    p.setMoves(movesList.Tackle, movesList.Razor_Leaf, movesList.Seed_Bomb, movesList.Solar_Beam);
                    break;
                case "Charmander":
                    p.setMoves(movesList.Scratch, movesList.Ember, movesList.Tackle, movesList.Fire_Spin);
                    break;
                case "Charmeleon":
                    p.setMoves(movesList.Slash, movesList.Take_Down, movesList.Fire_Fang, movesList.Flamethrower);
                    break;
                case "Charizard":
                    p.setMoves(movesList.Slash, movesList.Flamethrower, movesList.Dragon_Breath, movesList.Aerial_Ace);
                    break;
                case "Squirtle":
                    p.setMoves(movesList.Tackle, movesList.Water_Gun, movesList.Bite, movesList.Rapid_Spin);
                    break;
                case "Wartortle":
                    p.setMoves(movesList.Bite, movesList.Water_Pulse, movesList.Aqua_Tail, movesList.Take_Down);
                    break;
                case "Blastoise":
                    p.setMoves(movesList.Bite, movesList.Hydro_Pump, movesList.Aqua_Tail, movesList.Rapid_Spin);
                    break;
                case "Caterpie":
                    p.setMoves(movesList.Tackle, movesList.Bug_Bite, null, null);
                    break;
                case "Metapod":
                    p.setMoves(movesList.Tackle, null, null, null);
                    break;
                case "Butterfree":
                    p.setMoves(movesList.Confusion, movesList.Gust, movesList.Psybeam, movesList.Air_Slash);
                    break;
                case "Weedle":
                    p.setMoves(movesList.Poison_Sting, movesList.Bug_Bite, null, null);
                    break;
                case "Kakuna":
                    p.setMoves(movesList.Tackle, null, null, null);
                    break;
                case "Beedrill":
                    p.setMoves(movesList.Bug_Bite, movesList.Poison_Sting, movesList.Pursuit, movesList.Poison_Jab);
                    break;
                case "Pidgey":
                    p.setMoves(movesList.Tackle, movesList.Gust, movesList.Wing_Attack, movesList.Twister);
                    break;
                case "Pidgeotto":
                    p.setMoves(movesList.Twister, movesList.Gust, movesList.Wing_Attack, movesList.Aerial_Ace);
                    break;
                case "Pidgeot":
                    p.setMoves(movesList.Gust, movesList.Aerial_Ace, movesList.Air_Slash, movesList.Crunch);
                    break;
                case "Rattata":
                    p.setMoves(movesList.Tackle, movesList.Bite, movesList.Fire_Fang, movesList.Crunch);
                    break;
                case "Raticate":
                    p.setMoves(movesList.Crunch, movesList.Fire_Fang, movesList.Slash, movesList.Poison_Jab);
                    break;

            }
    }


}
