package solution;

import game.Game;
import game.Player;

public class Homework {

    public static void main(String[] args) {

        Game game = new Game();
        game.addPlayer(new Player("Mihai", game));
        game.addPlayer(new Player("Bogdan", game));
        game.addPlayer(new Player("Georgeta", game));

        game.play();
    }
}
