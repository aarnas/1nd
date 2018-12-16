package pkg1nd;

public class SlidePuzzle{
    public static void main(String[] args) {
        GameFactory factory = new GameFactory();
        Game game = factory.getGame();
        game.launch();
        
    }
}