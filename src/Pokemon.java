import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Scanner;

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


    public enum stat {
        Strength,
        Speed,
        Defense,
        Health;
    }

    public Pokemon(){

    }

    public Pokemon(int num, String name, String type1, String type2, int hp, int attack, int defense,
                   int specialAttack, int specialDefense, int speed) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.number = num;
    }

    public void gainExperience(int exp) {
        this.experience += exp;
        checkLevelUp();
    }

    private void checkLevelUp() {
        while (this.experience >= EXP_TO_LEVEL_UP) {
            levelUp();
            this.experience -= EXP_TO_LEVEL_UP;
            EXP_TO_LEVEL_UP += 20;
        }
    }

    private void levelUp() {
        this.level++;
        increaseStats();
        System.out.println(this.name + " leveled up to level " + this.level + "!");
    }

    private void increaseStats() {
        // Increase each stat by a small amount
        for (stat statType : stat.values()) {
            int currentValue = statMap.get(statType);
            int increase = (int) (Math.random() * 3) + 1; // Random increase between 1-3
            statMap.put(statType, currentValue + increase);
        }
    }


    public int getLevel() {
        return this.level;
    }

    public int getExperience() {
        return this.experience;
    }


    EnumMap<stat, Integer> statMap = new EnumMap<>(stat.class);
    private ArrayList<MovesTest.movesList> movesList;

    public static Pokemon createPokemon(String name) {
        Scanner scanner = new Scanner(System.in);

        List<Pokemon> availablePokemon = PokemonLoader.loadPokemonFromCSV("src/pokemon.csv");

        for (Pokemon p : availablePokemon) {
            if(p.getName().equals(name)) {
                return p;
            }
        }

        return null;
    }

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

    public String getName() {
        return name;
    }

    public int getNumber(){return number;}

    public Pokemon randomEncounter(){
        Scanner scanner = new Scanner(System.in);
        Pokemon Pokemon = null;

        List<Pokemon> availablePokemon = PokemonLoader.loadPokemonFromCSV("src/pokemon.csv");

        int random = (int) (Math.random()*151);
        for (Pokemon pokemon : availablePokemon) {
            if(pokemon.getNumber() == random){
                Pokemon = pokemon;
            }
        }

        return Pokemon;
    }

    public void takeDamage(int damage) {
        statMap.compute(stat.Health, (k, currentHP) -> Math.max(0, currentHP - damage));
    }

    public MovesTest.movesList getMove(int index) {
        if (pokemonMoves != null && index >= 0 && index < pokemonMoves.size()) {
            return pokemonMoves.get(index);
        }
        throw new IndexOutOfBoundsException("Invalid move index");
    }

    public String getMovesPower(MovesTest.movesList move) {
        return movesTest.getMovesPower(move);
    }


    public ArrayList<MovesTest.movesList> pokemonMoves;

    public void setMoves(MovesTest.movesList move1, MovesTest.movesList move2, MovesTest.movesList move3, MovesTest.movesList move4) {
        pokemonMoves = new ArrayList<>();
        pokemonMoves.add(move1);
        pokemonMoves.add(move2);
        pokemonMoves.add(move3);
        pokemonMoves.add(move4);
    }

}


