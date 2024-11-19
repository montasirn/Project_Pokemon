import java.util.EnumMap;

public class PokemonTest {
    public String name;
    public enum stat {
        Strength,
        Speed,
        Defense,
        Health;
    }

    static EnumMap<PokemonTest.stat, Integer> statMap = new EnumMap<PokemonTest.stat, Integer>(stat.class);

    public static void createPokemon(int str, int spd, int def, int hp) {
        statMap.put(PokemonTest.stat.Strength, str);
        statMap.put(PokemonTest.stat.Speed, spd);
        statMap.put(PokemonTest.stat.Defense, def);
        statMap.put(PokemonTest.stat.Health, hp);
    }

    public int getStat(PokemonTest.stat stat){
        return statMap.get(stat);
    }

    public String getName() {
        return name;
    }

public class Charmander extends MovesTest{
        public void createCharmander() {
            PokemonTest.this.name = "Charmander";
        createPokemon(12, 9, 8, 20);
        MovesTest charmander = new MovesTest();
        charmander.setMoves(MovesTest.movesList.Scratch, MovesTest.movesList.Ember, MovesTest.movesList.Slash, MovesTest.movesList.Tackle);
        }
    }
public class Squirtle extends MovesTest{
        public void createSquirtle() {
            createPokemon(9, 8, 12, 20);
            MovesTest squirtle = new MovesTest();
            squirtle.setMoves(movesList.Bubble, movesList.Water_Gun, movesList.Bite, MovesTest.movesList.Tackle);
        }
    }
public class Bulbasaur extends MovesTest{
        public void createBulbasaur() {
            createPokemon(10, 9, 10, 20);
            MovesTest bulbasaur = new MovesTest();
            bulbasaur.setMoves(movesList.Vine_Whip, movesList.Poison_Powder, movesList.Leech_Seed, MovesTest.movesList.Tackle);
        }
    }
}


