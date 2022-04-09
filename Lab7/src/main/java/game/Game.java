package game;

import elements.*;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Bag bag = new Bag(this);
    private final Board board = new Board(this);
    private final Dictionary dictionary = new Dictionary();
    private final List<Player> players = new ArrayList<>();
    private boolean gameIsRunning = false;

    public void addPlayer(Player newPlayer){
        players.add(newPlayer);
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

    public void play(){

        gameIsRunning = true;
        List<Thread> threadList = new ArrayList<>();

        for( Player player : players ){
            threadList.add(new Thread(player));
        }

        for( Thread thread : threadList )
            thread.start();
    }
}
