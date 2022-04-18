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

    public List<String> getWords() {
        return words;
    }

    /**
     * adds to the table the word that was added and prints the player and his current score
     * @param player that submitted a word
     * @param word the word that was submitted
     */
    public synchronized void addWord(Player player, String word) {
        words.add(word);
        System.out.println("\n" + player.getName() + " submitted the word: " + word + ". Current points: " + player.getScore());
    }

    @Override
    public String toString() {
        return words.toString();
    }

}
