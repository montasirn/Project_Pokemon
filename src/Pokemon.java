import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class Pokemon {
    private String name;
    private HashMap<String, Integer> strength = new HashMap<>();
    private HashMap<String, Integer> speed = new HashMap<>();
    private HashMap<String, Integer> defense = new HashMap<>();
    private HashMap<String, Integer> level = new HashMap<>();
    private HashMap<String, Integer> health = new HashMap<>();
    private HashMap<String, String> type = new HashMap<>();
    private int exp, expMax;

    public enum stat{
        Strength,
        Speed,
        Defense,
        Health;
    }

    EnumMap<stat, String> statMap = new EnumMap<stat, String>(stat.class);

    public void intializeEnum(String str, String spd, String def, String hp){
        statMap.put(stat.Strength, str);
        statMap.put(stat.Speed, spd);
        statMap.put(stat.Defense, def);
        statMap.put(stat.Health, hp);

    }



    public Pokemon(String name){
        exp = 0;
            if (name.equalsIgnoreCase("Charmander")){
                strength.put("Strength", 12 + (int) (Math.random()*3));
                speed.put("Speed", 9 + (int) (Math.random()*3));
                defense.put("Defense", 8 + (int) (Math.random()*3));
                health.put("Health", 20 + (int) (Math.random()*3));
                type.put("Type", "Fire");
                level.put("Level", 5);
            }else if (name.equalsIgnoreCase("Squirtle")) {
                strength.put("Strength", 9 + (int) (Math.random() * 3));
                speed.put("Speed", 7 + (int) (Math.random() * 3));
                defense.put("Defense", 13 + (int) (Math.random() * 3));
                health.put("Health", 20 + (int) (Math.random()*3));
                type.put("Type", "Water");
                level.put("Level", 5);
            }else if (name.equalsIgnoreCase("Bulbasaur")) {
                strength.put("Strength", 11 + (int) (Math.random() * 3));
                speed.put("Speed", 9 + (int) (Math.random() * 3));
                defense.put("Defense", 9 + (int) (Math.random() * 3));
                health.put("Health", 20 + (int) (Math.random()*3));
                type.put("Type", "Grass");
                level.put("Level", 5);
            }
    }

    public void levelUp(){
        if(exp > expMax){
            exp = 0;
            level.put("Level", level.get("Level") + 1);
            strength.put("Strength", strength.get("Strength") + 1 + (int)(Math.random()*3));
            speed.put("Speed", speed.get("Speed") + 1 + (int)(Math.random()*3));
            defense.put("Defense", defense.get("Defense") + 1 + (int)(Math.random()*3));
            health.put("Health", health.get("Health") + 3 + (int)(Math.random()*3));
            expMax += 20;
        }
    }
    public void evolution(){
        if(level.get("Level") == 16){
            if (name.equalsIgnoreCase("Charmander")){
                name = "Charmeleon";
                strength.put("Strength", strength.get("Strength") + 7 + (int)(Math.random()*3));
                speed.put("Speed", speed.get("Speed") + 3 + (int)(Math.random()*3));
                defense.put("Defense", defense.get("Defense") + 4 + (int)(Math.random()*3));
                health.put("Health", health.get("Health") + 7 + (int)(Math.random()*3));
                expMax += 50;
            } else if (name.equalsIgnoreCase("Squirtle")) {
                name = "Wartortle";
                strength.put("Strength", strength.get("Strength") + 5 + (int)(Math.random()*3));
                speed.put("Speed", speed.get("Speed") + 3 + (int)(Math.random()*3));
                defense.put("Defense", defense.get("Defense") + 7 + (int)(Math.random()*3));
                health.put("Health", health.get("Health") + 7 + (int)(Math.random()*3));
                expMax += 50;
            } else if (name.equalsIgnoreCase("Bulbasaur")){
                name = "Ivysaur";
                strength.put("Strength", strength.get("Strength") + 6 + (int)(Math.random()*3));
                speed.put("Speed", speed.get("Speed") + 4 + (int)(Math.random()*3));
                defense.put("Defense", defense.get("Defense") + 5 + (int)(Math.random()*3));
                health.put("Health", health.get("Health") + 7 + (int)(Math.random()*3));
                expMax += 50;
            }
        }
    }
}
