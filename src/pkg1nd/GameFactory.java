package pkg1nd;

public class GameFactory {
    public Game getGame(){
        return new ConsoleGame();
    }
}
