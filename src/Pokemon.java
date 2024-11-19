import java.util.ArrayList;
import java.util.EnumMap;

public class Pokemon {
    private String name;
    public enum stat {
        Strength,
        Speed,
        Defense,
        Health;
    }

    EnumMap<stat, Integer> statMap = new EnumMap<>(stat.class);
    private ArrayList<MovesTest.movesList> movesList;

    public Pokemon(String name) {
        this.name = name;
        this.movesList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void createPokemon(int str, int spd, int def, int hp) {
        statMap.put(stat.Strength, str);
        statMap.put(stat.Speed, spd);
        statMap.put(stat.Defense, def);
        statMap.put(stat.Health, hp);
    }

    public int getStat(stat statType) {
        return statMap.get(statType);
    }

    public void setMoves(MovesTest.movesList move1, MovesTest.movesList move2, MovesTest.movesList move3, MovesTest.movesList move4) {
        movesList.add(move1);
        movesList.add(move2);
        movesList.add(move3);
        movesList.add(move4);
    }

    public MovesTest.movesList getMove(int index) {
        if (index >= 0 && index < movesList.size()) {
            return movesList.get(index);
        }
        throw new IndexOutOfBoundsException("Invalid move index");
    }

    public String getMovesPower(MovesTest.movesList move) {
        MovesTest movesTest = new MovesTest();
        movesTest.setMoves();
        return movesTest.getMovesPower(move);
    }

    public void takeDamage(int damage) {
        statMap.compute(stat.Health, (k, currentHP) -> Math.max(0, currentHP - damage));
    }
}