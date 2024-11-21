import java.util.ArrayList;
import java.util.EnumMap;

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


    public enum stat {
        Strength,
        Speed,
        Defense,
        Health;
    }

    public Pokemon(String name, String type1, String type2, int hp, int attack, int defense,
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


