import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
/**
 * Represents a Pokémon with attributes such as level, stats, moves, and experience.
 * This class provides methods for managing battles, leveling up, and interacting with Pokémon.
 */
public class Pokemon {
    private int level;
    private int experience;
    private static int EXP_TO_LEVEL_UP = 100;
    private MovesTest movesTest;
    private String name;
    private String type1;
    private String type2;
    private int hp;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;
    private int number;
    private int maxHp;
    private ArrayList<MovesTest.movesList> pokemonMoves;

    /**
     * Default constructor for creating an empty Pokémon object.
     */
    public Pokemon(){

    }
    /**
     * Constructs a new Pokémon with specified attributes.
     *
     * @param num           The Pokémon's number in the Pokédex.
     * @param name          The name of the Pokémon.
     * @param type1         The primary type of the Pokémon.
     * @param type2         The secondary type of the Pokémon (can be null).
     * @param hp            The base HP of the Pokémon.
     * @param attack        The base attack stat of the Pokémon.
     * @param defense       The base defense stat of the Pokémon.
     * @param specialAttack The base special attack stat of the Pokémon.
     * @param specialDefense The base special defense stat of the Pokémon.
     * @param speed         The base speed stat of the Pokémon.
     */
    public Pokemon(int num, String name, String type1, String type2, int hp, int attack, int defense,
                   int specialAttack, int specialDefense, int speed) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.maxHp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.number = num;
        this.pokemonMoves = new ArrayList<>();
        this.level = 5;

    }
    /**
     * Increases the Pokémon's experience by a specified amount and handles leveling up if necessary.
     *
     * @param exp The amount of experience to gain.
     */
    public void gainExperience(int exp) {
        this.experience += exp;
        while (this.experience >= 100) {
            levelUp();
            this.experience -= 100;
        }
    }
    /**
     * Checks if the Pokémon can level up and performs leveling up if applicable.
     */
    private void checkLevelUp() {
        while (this.experience >= EXP_TO_LEVEL_UP) {
            levelUp();
            this.experience -= EXP_TO_LEVEL_UP;
            EXP_TO_LEVEL_UP += 20;
        }
    }

    /**
     * Levels up the Pokémon, increasing its level and stats.
     */
    private void levelUp() {
        this.level++;
        increaseStats();
        System.out.println(this.name + " leveled up to level " + this.level + "!");
    }
    /**
     * Returns the maximum HP of the Pokémon.
     *
     * @return The maximum HP as an integer.
     */
    public int getMaxHp(){
        return maxHp;
    }

    /**
     * Increases various stats of the Pokémon upon leveling up.
     */
    private void increaseStats() {
        maxHp += 5 + (int) (Math.random() * 3);
        attack += 5 + (int) (Math.random() * 3);
        defense += 5 + (int) (Math.random() * 3);
        speed += 5 + (int) (Math.random() * 3);
        specialAttack += 5 + (int) (Math.random() * 3);
        specialDefense += 5 + (int) (Math.random() * 3);
    }
    /**
     * Returns the current level of the Pokémon.
     *
     * @return The current level as an integer.
     */

    public int getLevel() {
        return this.level;
    }
    /**
     * Returns the current experience points of the Pokémon.
     *
     * @return The current experience points as an integer.
     */
    public int getExperience() {
        return this.experience;
    }
    /**
     * Creates a new Pokémon based on its name by loading available Pokémon from a CSV file.
     *
     * @param name The name of the desired Pokémon.
     * @return A new Pokémon object or null if not found.
     */

    private ArrayList<MovesTest.movesList> movesList;

    public static Pokemon createPokemon(String name) {
        List<Pokemon> availablePokemon = PokemonLoader.loadPokemonFromCSV("src/pokemon.csv");
        for (Pokemon p : availablePokemon) {
            if(p.getName().equals(name)) {
                MovesTest.setMovesForPokemon(p); // New method to set moves for a single Pokemon
                return p;
            }
        }
        return null;
    }

    /**
     * Retrieves a specific stat value based on its name.
     *
     * @param var The name of the stat (e.g., "hp", "attack").
     * @return The value of the specified stat as an integer. Returns 0 if invalid var is provided.
     */
    public int getStat(String var) {
        switch (var){
            case "hp":
                return hp;
            case "attack":
                return attack;
            case "defense":
                return defense;
            case "specialAttack":
                return specialAttack;
            case "specialDefense":
                return specialDefense;
            case "speed":
                return speed;
        }
        return 0;
    }
    /**
     * Returns the name of the Pokémon.
     *
     * @return The name as a string.
     */
    public String getName() {
        return name;
    }
    /**
     * Checks if the Pokémon has fainted (HP <= 0).
     *
     * @return True if fainted; otherwise false.
     */
    public boolean hasFainted() {
        return this.hp <= 0;
    }
    /**
     * Heals the Pokémon by a specified amount without exceeding its maximum HP.
     *
     * @param amount The amount to heal (can be negative to apply damage).
     */
    public void heal(int amount) {
        this.hp = Math.min(this.hp + amount, this.maxHp);
    }
    /**
     * Returns the Pokédex number of the Pokémon.
     *
     * @return The number as an integer.
     */
    public int getNumber(){return number;}
    /**
     * Generates a random encounter with a wild Pokémon based on starter level.
     *
     * @param starterlevel The level of the player's starter Pokémon used to determine wild encounter level.
     * @return A randomly encountered wild Pokémon or null if none is found.
     */
    public static Pokemon randomEncounter(int starterlevel) {
        List<Pokemon> availablePokemon = PokemonLoader.loadPokemonFromCSV("src/pokemon.csv");

        // Generate a random index for Pokémon selection
        int randomIndex = (int) (Math.random() * availablePokemon.size());
        Pokemon encountered = availablePokemon.get(randomIndex);

        // Set the level of the encountered Pokémon
        encountered.level = starterlevel + (Math.random() < 0.5 ? -1 : 1); // Level +/- 1 from starter

        // Assign moves to the encountered Pokémon if not already assigned
        if (encountered.getMoves().isEmpty()) {
            MovesTest.instanciateMoves(); // Ensure moves are instantiated
        }

        return encountered;
    }
    /**
     * Returns a list of all moves assigned to this Pokémon.
     *
     * @return A list of moves as an ArrayList of movesList.
     */
    public List<MovesTest.movesList> getMoves() {
        return new ArrayList<>(pokemonMoves); // Return a copy of the moves list
    }
    /**
     * Applies damage to the Pokémon by reducing its HP.
     *
     * @param damage The amount of damage to apply.
     */
    public void takeDamage(int damage) {
        hp = hp - damage;
    }
    /**
     * Retrieves the power associated with a specific move.
     *
     * @param move The move for which to retrieve power information.
     * @return A string representing move power or "Move not set" if move is null.
     */
    public String getMovesPower(MovesTest.movesList move) {
        if (move == null) {
            return "Move not set";
        }
        return MovesTest.getMovesPower(move);
    }

    /**
     * Sets four moves for this Pokémon.
     *
     * @param move1 First move to set.
     * @param move2 Second move to set.
     * @param move3 Third move to set.
     * @param move4 Fourth move to set.
     */
    public void setMoves(MovesTest.movesList move1, MovesTest.movesList move2, MovesTest.movesList move3, MovesTest.movesList move4) {
        if (pokemonMoves == null) {
            pokemonMoves = new ArrayList<>();
        } else {
            pokemonMoves.clear();
        }
        pokemonMoves.add(move1);
        pokemonMoves.add(move2);
        pokemonMoves.add(move3);
        pokemonMoves.add(move4);
    }
    /**
     * Retrieves a specific move by index.
     *
     * @param i Index of the desired move (0-3).
     * @return The corresponding move or null if index is out of bounds.
     */
    public MovesTest.movesList getMove(int i) {
        if (pokemonMoves != null && i >= 0 && i < pokemonMoves.size()) {
            return pokemonMoves.get(i);
        }
        return null;
    }

    /**
     * Returns current health points (HP) of this Pokémon.
     *
     * @return Current HP as an integer.
     */
    public int getHealth() {
        return hp;
    }
}


