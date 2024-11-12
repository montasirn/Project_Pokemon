import java.util.HashMap;

public class Pokemon {
    private String name;
    private HashMap<String, Integer> strength = new HashMap<>();
    private HashMap<String, Integer> speed = new HashMap<>();
    private HashMap<String, Integer> defense = new HashMap<>();
    private HashMap<String, Integer> level = new HashMap<>();
    private int exp, expMax;

    public Pokemon(String name){
        exp = 0;
            if (name.equalsIgnoreCase("Charmander")){
                strength.put("Strength", 12 + (int) (Math.random()*3));
                speed.put("Speed", 9 + (int) (Math.random()*3));
                defense.put("Defense", 8 + (int) (Math.random()*3));
                level.put("Level", 5);
            }else if (name.equalsIgnoreCase("Squirtle")) {
                strength.put("Strength", 9 + (int) (Math.random() * 3));
                speed.put("Speed", 7 + (int) (Math.random() * 3));
                defense.put("Defense", 13 + (int) (Math.random() * 3));
                level.put("Level", 5);
            }else if (name.equalsIgnoreCase("Bulbasaur")) {
                strength.put("Strength", 11 + (int) (Math.random() * 3));
                speed.put("Speed", 9 + (int) (Math.random() * 3));
                defense.put("Defense", 9 + (int) (Math.random() * 3));
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
            expMax += 20;
        }
    }
}
