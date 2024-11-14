import java.util.EnumMap;

public class PokemonTest {
    public enum stat{
        Strength,
        Speed,
        Defense,
        Health;
    }

    EnumMap<Pokemon.stat, String> statMap = new EnumMap<Pokemon.stat, String>(Pokemon.stat.class);

    public void intializeEnum(String str, String spd, String def, String hp){
        statMap.put(Pokemon.stat.Strength, str);
        statMap.put(Pokemon.stat.Speed, spd);
        statMap.put(Pokemon.stat.Defense, def);
        statMap.put(Pokemon.stat.Health, hp);

    }

}

 class Charmander extends PokemonTest{

 }
