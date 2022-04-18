package game;

import elements.Tile;
import java.util.List;
import java.util.Scanner;

public class Player implements Runnable{

    private List<Tile> availableTiles;
    private String name;
    private Game game;
    private int score;

    public Player(String name, Game game){

        try{
            if( name == null )
                throw new Exception("name is null!");
            if( game == null )
                throw new Exception("game is null!");

            this.name = name;
            this.game = game;
            this.score = 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String readWord(){

        System.out.print("Insert word: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void submitWord(){

        System.out.println("[" + getName() + "]" + " Tiles available " + availableTiles );
        String word = readWord().toUpperCase();

        if( game.getDictionary().isWord(word) && game.getDictionary().containsTiles(word, availableTiles) ){

            score += game.getDictionary().computePoints(word);
            game.getBoard().addWord(this, word);

            game.getDictionary().throwTiles(word, availableTiles);

            List<Tile> newTiles = game.getBag().extractTiles(word.length());
            if( newTiles == null )
                return;
            availableTiles.addAll( newTiles );
        }

        if( word.equals(" ") || word.equals("") ){
            game.getBag().discardTiles(availableTiles);
            availableTiles = game.getBag().extractTiles(7);
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void turn(int indexPlayer){

        synchronized (game){
            game.notifyAll();

            while( game.getCurrentTurn() != indexPlayer ){
                try{
                    game.wait();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void run(){

        availableTiles = game.getBag().extractTiles(7);
        int indexPlayer = game.getPlayers().indexOf(this);

        while( true ){

            turn(indexPlayer);
            if( !game.gameIsRunning() )
                break;

            submitWord();
            int currentTurn = ( game.getCurrentTurn() + 1 ) % game.getPlayers().size();
            game.setCurrentTurn(currentTurn);
        }
    }

}
