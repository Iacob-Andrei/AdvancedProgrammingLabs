package elements;

import java.util.*;

public class Bag {

    private final Map<Tile, Integer> bag;

    public Bag(){
        bag = new HashMap<>();
        for( char character = 'a' ; character <= 'z' ; character++ ){
            bag.put(new Tile(character), 10);
        }
    }

    public synchronized List<Tile> extractTiles(int number){

        List<Tile> extracted = new ArrayList<>();
        Random generator = new Random();

        for( int index = 0 ; index < number ; index++ ){
            if( bag.isEmpty() )
                break;

            Object[] tiles = bag.keySet().toArray();
            Tile tile = (Tile)tiles[generator.nextInt(tiles.length)];
            System.out.println( tile );

            extracted.add(tile);
            int nrOfTiles = bag.get(tile) - 1;
            if( nrOfTiles == 0 ){
                bag.remove(tile);
            }
            else{
                bag.put(tile, nrOfTiles);
            }
        }

        return extracted;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ")
                .add("bag=" + bag)
                .toString();
    }
}
