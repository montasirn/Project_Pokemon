public class Main {
    public static void main(String[] args) {
        Pokemon charmander = new Pokemon("Charmander");
        charmander.createPokemon(12, 9, 8, 20);
        charmander.setMoves(MovesTest.movesList.Scratch, MovesTest.movesList.Ember, MovesTest.movesList.Slash, MovesTest.movesList.Tackle);

        Pokemon squirtle = new Pokemon("Squirtle");
        squirtle.createPokemon(10, 8, 10, 22);
        squirtle.setMoves(MovesTest.movesList.Tackle, MovesTest.movesList.Bubble, MovesTest.movesList.Water_Gun, MovesTest.movesList.Bite);

        Battle battle = new Battle(charmander, squirtle);
        battle.start();
    }
}