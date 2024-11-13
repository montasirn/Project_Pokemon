import java.util.HashMap;

public class MovesList {
    private final String[] moveName;
    private final Integer[] movePower;

    public MovesList(String type) {
        moveName = new String[]{"Tackle", "Vine Whip", "Poison Powder", "Leech Seed", "Scratch", "Ember", "Slash", "Bubble", "Water Gun", "Bite"};
        movePower = new Integer[]{35, 35, 15, 20, 40, 40, 70, 20, 40, 60};
    }

    public void PokemonMoves(String name){
        if(name.equalsIgnoreCase("Charmander")){
            String[] moveList = new String[]{moveName[5], moveName[6]};
        } else if (name.equalsIgnoreCase("Squirtle")){
            String[] moveList = new String[]{moveName[1], moveName[8]};
        } else if (name.equalsIgnoreCase("Bulbasaur")) {
            String[] moveList = new String[]{moveName[1], moveName[4]};
        }
    }

}


