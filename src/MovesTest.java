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
    public void setMoves(String move1, String move2, String move3, String move4){
        String[] move = new String[]{};
        move = {movesList.move1};
    }
}
