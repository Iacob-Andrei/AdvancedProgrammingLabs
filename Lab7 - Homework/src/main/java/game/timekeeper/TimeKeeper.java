package game.timekeeper;

import game.Game;
import game.Player;

import java.util.Comparator;

public class TimeKeeper implements Runnable {

    private Game game;

    public TimeKeeper(Game game){
        this.game = game;
    }

    @Override
    public void run(){

        long start = System.nanoTime();
        while(true){
            long end = System.nanoTime();

            long timePassed = (end - start) / 1_000_000_000;

            if( !game.gameIsRunning() ) {
                System.out.println("Game duration: " + timePassed + " seconds");
                return;
            }

            if( timePassed > 20 ){
                System.out.println("\nTime Limit Exceeded - 20 seconds. Game will end!");
                break;
            }
        }

        System.out.println("\nFinal points:");

        game.getPlayers().sort(Comparator.comparingInt(Player::getScore).reversed());

        for(Player player : game.getPlayers()){
            System.out.println(player.getName() + " has " + player.getScore() + " points.");
        }
        System.exit(0);
    }
}
