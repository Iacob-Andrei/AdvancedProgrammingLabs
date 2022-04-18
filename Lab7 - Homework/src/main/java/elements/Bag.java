package elements;

import game.Game;

import java.util.*;

public class Bag {

    private Map<Tile, Integer> bag;
    private Game game;

    public Bag(Game game){

        this.game = game;
        bag = new HashMap<>();
        for (char character = 'A'; character <= 'Z'; character++) {
            if( character == 'A' )
                bag.put(new Tile('A', 1), 9);
            else if( character == 'B' )
                bag.put(new Tile('B', 3), 2);
            else if( character == 'C' )
                bag.put(new Tile('C', 3), 2);
            else if( character == 'D' )
                bag.put(new Tile('D', 2), 4);
            else if( character == 'E' )
                bag.put(new Tile('E', 1), 12);
            else if( character == 'F' )
                bag.put(new Tile('F', 4), 2);
            else if( character == 'G' )
                bag.put(new Tile('G', 2), 3);
            else if( character == 'H' )
                bag.put(new Tile('H', 4), 2);
            else if( character == 'I' )
                bag.put(new Tile('I', 1), 9);
            else if( character == 'J' )
                bag.put(new Tile('J', 8), 1);
            else if( character == 'K' )
                bag.put(new Tile('K', 5), 1);
            else if( character == 'L' )
                bag.put(new Tile('L', 1), 4);
            else if( character == 'M' )
                bag.put(new Tile('M', 3), 2);
            else if( character == 'N' )
                bag.put(new Tile('N', 1), 6);
            else if( character == 'O' )
                bag.put(new Tile('O', 1), 8);
            else if( character == 'P' )
                bag.put(new Tile('P', 3), 2);
            else if( character == 'Q' )
                bag.put(new Tile('Q', 10), 1);
            else if( character == 'R' )
                bag.put(new Tile('R', 1), 6);
            else if( character == 'S' )
                bag.put(new Tile('S', 1), 4);
            else if( character == 'T' )
                bag.put(new Tile('T', 1), 6);
            else if( character == 'U' )
                bag.put(new Tile('U', 1), 4);
            else if( character == 'V' )
                bag.put(new Tile('V', 4), 2);
            else if( character == 'W' )
                bag.put(new Tile('W', 4), 2);
            else if( character == 'X' )
                bag.put(new Tile('X', 8), 1);
            else if( character == 'Y' )
                bag.put(new Tile('Y', 4), 2);
            else if( character == 'Z' )
                bag.put(new Tile('Z', 10), 1);

        }
    }

    public synchronized List<Tile> extractTiles(int number){

        List<Tile> extracted = new ArrayList<>();
        Random generator = new Random();

        for( int index = 0 ; index < number ; index++ ){
            if( bag.isEmpty() ) {
                
                extracted = null;
                game.setGameIsRunning(false);
                break;
            }

            Object[] tiles = bag.keySet().toArray();
            Tile tile = (Tile)tiles[generator.nextInt(tiles.length)];

            extracted.add(tile);
            int nrOfTiles = bag.get(tile) - 1;
            bag.put(tile, nrOfTiles);
        }

        return extracted;
    }

    public void discardTiles(List<Tile> discardedTiles){

        for( Tile tile : discardedTiles ){
            bag.put(tile, bag.get(tile) + 1);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ")
                .add("bag=" + bag)
                .toString();
    }

    public Map<Tile, Integer> getBag() {
        return bag;
    }
}
