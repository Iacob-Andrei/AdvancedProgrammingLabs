package game;

import elements.*;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Bag bag = new Bag(this);
    private final Board board = new Board(this);
    private final Dictionary dictionary = new Dictionary("E:\\Codes\\AdvancedProgrammingLabs\\Lab7 - Homework\\src\\main\\resources\\dictionary.txt");
    private final List<Player> players = new ArrayList<>();
    private boolean gameIsRunning = false;
    private int currentTurn = 0;

    public void addPlayer(Player newPlayer){

        try {
            if( newPlayer == null )
                throw new Exception("new player null!");
            players.add(newPlayer);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean gameIsRunning() {
        return gameIsRunning;
    }

    public void setGameIsRunning(boolean gameIsRunning) {
        this.gameIsRunning = gameIsRunning;
    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    public Dictionary getDictionary(){ return dictionary; }

    public List<Player> getPlayers() {
        return players;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = currentTurn;
    }

    public void play(){

        gameIsRunning = true;
        for( Player player : players ){
            new Thread(player).start();
        }
    }
}
