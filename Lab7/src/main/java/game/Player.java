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

        try{
            if( name == null )
                throw new Exception("name is null!");
            if( game == null )
                throw new Exception("game is null!");

            this.name = name;
            this.game = game;

        }
        catch(Exception e){
            e.printStackTrace();
        }
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

        while( !game.getDictionary().containsTiles(word, availableTiles) ){

            System.out.println("[GAME] Retype another word!");
            word = readWord();

            if( word.trim().equals("") ){
                availableTiles = game.getBag().extractTiles(7);
                System.out.println("[" + getName() + "]" + " gets new tiles! " + availableTiles + "\n");

                if (availableTiles.isEmpty()) {
                    game.setGameIsRunning(false);
                    return false;
                }

                return true;
            }
        }

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
