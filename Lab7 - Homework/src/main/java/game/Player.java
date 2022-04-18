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

    /**
     * read a word from console
     * @return the word that was submitted
     */
    public String readWord(){

        System.out.print("Insert word: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * allows a player to enter a word
     * word is valid if it can be constructed using the available tiles, and it exists
     * if the word exists, it's added to the board and the player throw the tiles and get new ones
     * if the word is empty, the player discards the available tiles, and gets other 7
     * if the word is invalid, the player loses his turn
     */
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
    }

    /**
     * this method is synchronized over the game
     * every player will wait until their turn comes
     * when a new player enters the synchronized zone, he notifies every player that wait in order to recheck the while condition
     * if they remain in the loop, they will wait for another notify
     * @param indexPlayer turn number of the player
     */
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

    /**
     * method called by the thread throw runnable interface
     * initially every player gets 7 tiles and get a order number
     * in the while loop they will call "turn(indexPlayer)" method in order to get their turn
     * when their turn comes, they can submit a word or not
     * game ends when there are not any available tiles
     */
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
