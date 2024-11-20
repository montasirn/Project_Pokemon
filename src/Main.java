import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the world of Pokemon! To begin choose your choice.");
        System.out.println("Charmander (1) \nSquirtle (2)\nBulbasaur (3)");
        int choice = s.nextInt();
        Pokemon starter = null;
        if (choice == 1){
            starter = new Pokemon.Charmander();
        }else if (choice == 2){
            starter = new Pokemon.Squirtle();
        }else if (choice == 3){
            starter = new Pokemon.Bulbasaur();
        }
        assert starter != null;
        System.out.println("Name: " + starter.getName());
        System.out.println("Health: " + starter.getStat(Pokemon.stat.Health));
        System.out.println("First move: " + starter.getMove(0));
    }
}