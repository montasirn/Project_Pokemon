import java.util.ArrayList;
import java.util.EnumMap;

public class Pokemon {
    public String name;
    private int level;
    private int experience;
    private static  int EXP_TO_LEVEL_UP = 100;

    public enum stat {
        Strength,
        Speed,
        Defense,
        Health;
    }

    public Pokemon(String name) {
        this.name = name;
        this.movesList = new ArrayList<>();
        this.level = 1;
        this.experience = 0;
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


    EnumMap<Pokemon.stat, Integer> statMap = new EnumMap<>(Pokemon.stat.class);
    private ArrayList<MovesTest.movesList> movesList;

    public void createPokemon(int str, int spd, int def, int hp) {
        statMap.put(Pokemon.stat.Strength, str);
        statMap.put(Pokemon.stat.Speed, spd);
        statMap.put(Pokemon.stat.Defense, def);
        statMap.put(Pokemon.stat.Health, hp);
    }

    public int getStat(Pokemon.stat statType) {
        return statMap.get(statType);
    }

    public String getName() {
        return name;
    }

    public void takeDamage(int damage) {
        statMap.compute(Pokemon.stat.Health, (k, currentHP) -> Math.max(0, currentHP - damage));
    }

    public MovesTest.movesList getMove(int index) {
        if (pokemonMoves != null && index >= 0 && index < pokemonMoves.size()) {
            return pokemonMoves.get(index);
        }
        throw new IndexOutOfBoundsException("Invalid move index");
    }

    public String getMovesPower(MovesTest.movesList move) {
        MovesTest movesTest = new MovesTest();
        movesTest.setMoves();
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

    public static class Charmander extends Pokemon {
        public Charmander() {
            super("Charmander");
            createCharmander();
        }

        public void createCharmander() {
            createPokemon(12, 9, 8, 20);
            setMoves(MovesTest.movesList.Scratch, MovesTest.movesList.Ember, MovesTest.movesList.Slash, MovesTest.movesList.Tackle);
        }
    }
public static class Squirtle extends Pokemon{
    public Squirtle() {
        super("Squirtle");
        createSquirtle();
    }

    public void createSquirtle() {
            createPokemon(9, 8, 12, 20);
            MovesTest squirtle = new MovesTest();
            squirtle.setMoves(MovesTest.movesList.Bubble, MovesTest.movesList.Water_Gun, MovesTest.movesList.Bite, MovesTest.movesList.Tackle);
        }
    }
public static class Bulbasaur extends Pokemon{
    public Bulbasaur() {
        super("Bulbasaur");
        createBulbasaur();
    }

    public void createBulbasaur() {
            createPokemon(10, 9, 10, 20);
            MovesTest bulbasaur = new MovesTest();
            bulbasaur.setMoves(MovesTest.movesList.Vine_Whip, MovesTest.movesList.Poison_Powder, MovesTest.movesList.Leech_Seed, MovesTest.movesList.Tackle);
        }
    }
}


