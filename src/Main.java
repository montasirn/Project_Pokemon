import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Choose your starter pokemon!\n(type name exactly)\n");
        System.out.println("Charmander \nBulbasaur \nSquirtle ");
        String starter = s.nextLine();
        Pokemon p = Pokemon.createPokemon(starter);
        System.out.println(p.getStat("attack"));
        System.out.println(p.getStat("hp"));
    }
}