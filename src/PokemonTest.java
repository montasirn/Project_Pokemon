import java.util.EnumMap;

public class PokemonTest {
    public enum stat {
        Strength,
        Speed,
        Defense,
        Health;
    }

    EnumMap<Pokemon.stat, Integer> statMap = new EnumMap<Pokemon.stat, Integer>(Pokemon.stat.class);

    public void createPokemon(int str, int spd, int def, int hp) {
        statMap.put(Pokemon.stat.Strength, str);
        statMap.put(Pokemon.stat.Speed, spd);
        statMap.put(Pokemon.stat.Defense, def);
        statMap.put(Pokemon.stat.Health, hp);
    }

    public void getStat(){

    }

public static class Charmander extends PokemonTest{
        public void createCharmander() {
        createPokemon(12, 9, 8, 20);
        MovesTest charm = new MovesTest();
        charm.setMoves("Scratch", "Ember", "Slash", "Tackle");
        }

    }
}


