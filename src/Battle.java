import java.util.Scanner;

public class Battle {
    private int turnNumber;
    Scanner s = new Scanner(System.in);
    public String BattleStart(int health){
        turnNumber = 1;
        while (health > 0){
            String input1 = s.nextLine();
            turnNumber ++;
        }
        return "";
    }
}
