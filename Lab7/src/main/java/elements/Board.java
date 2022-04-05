package elements;

import game.Game;
import game.Player;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<String> words = new ArrayList<>();
    private final Game game;

    public Board(Game game){
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public List<String> getWords() {
        return words;
    }

    public synchronized void addWord(Player player, String word) {
        words.add(word);
        System.out.println("\n" + player.getName() + " submitted the word: " + word + "\n");
    }

    @Override
    public String toString() {
        return words.toString();
    }

}
