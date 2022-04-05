package game;

import elements.Tile;
import java.util.List;
import java.util.Scanner;

public class Player implements Runnable{

    private List<Tile> availableTiles;
    private String name;
    private Game game;
    private boolean running;

    public Player(String name, Game game){
        this.name = name;
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String readWord(){

        System.out.print("Insert word: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public boolean submitWord(){

        System.out.println("[" + getName() + "]" + " Tiles available " + availableTiles );
        String word = readWord();

        while( word.equals(" ") || word.equals("") ){
            availableTiles = game.getBag().extractTiles(7);

            if (availableTiles.isEmpty()) {
                game.setGameIsRunning(false);
                return false;
            }
        }

        //TO DO - CHECK IF LETTERS EXISTS

        game.getBoard().addWord(this, word);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void run(){

        availableTiles = game.getBag().extractTiles(7);
        synchronized (game){
            submitWord();
        }

    }
}
