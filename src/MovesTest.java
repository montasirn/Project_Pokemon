import java.util.ArrayList;
import java.util.EnumMap;

public class MovesTest {
    public enum movesList{
        Tackle,
        Vine_Whip,
        Poison_Powder,
        Leech_Seed,
        Scratch,
        Ember,
        Slash,
        Bubble,
        Water_Gun,
        Bite;
    }

    EnumMap<movesList,String> moves = new EnumMap<movesList,String>(movesList.class);

    public MovesTest() {

    }

    public void setMoves(){
        moves.put(movesList.Tackle, "35");
        moves.put(movesList.Vine_Whip, "35");
        moves.put(movesList.Poison_Powder, "15");
        moves.put(movesList.Leech_Seed, "20");
        moves.put(movesList.Scratch, "40");
        moves.put(movesList.Ember, "40");
        moves.put(movesList.Slash, "70");
        moves.put(movesList.Bubble, "20");
        moves.put(movesList.Water_Gun, "40");
        moves.put(movesList.Bite, "60");
    }

    public ArrayList<movesList> getAllMoves() {
        return pokemonMoves;
    }
    public ArrayList<movesList> pokemonMoves;

    public void setMoves(movesList move1, movesList move2, movesList move3, movesList move4) {
        pokemonMoves = new ArrayList<>();
        pokemonMoves.add(move1);
        pokemonMoves.add(move2);
        pokemonMoves.add(move3);
        pokemonMoves.add(move4);
    }

    public String getMovesPower(MovesTest.movesList move) {
        MovesTest movesTest = new MovesTest();
        movesTest.setMoves();
        return movesTest.getMovesPower(move);
    }



}
