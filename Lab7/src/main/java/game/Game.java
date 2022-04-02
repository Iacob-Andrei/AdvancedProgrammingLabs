package game;

import elements.*;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final Dictionary dictionary = new Dictionary();
    private final List<Player> players = new ArrayList<>();

    public void addPlayer(Player newPlayer){
        players.add(newPlayer);
    }

    // TO DO
    public void play(){

    }

    public static void main(String[] args) {

        Game game = new Game();

    }
}
