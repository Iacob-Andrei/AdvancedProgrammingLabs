package elements;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    public boolean isWord(String word) {
        return true;
    }

    public boolean containsTiles(String word, List<Tile> tilesInput){

        List<Tile> tiles = new ArrayList<>(tilesInput);

        if( word.length() > tiles.size() )
            return false;

        while( word.length() != 0 ){

            boolean found = false;
            char letter = word.charAt(0);

            for( Tile tile : tiles ){
                if( letter == tile.getLetter() ){
                    found = true;
                    word = word.substring(1);
                    tiles.remove(tile);
                    break;
                }
            }

            if(!found)
                return false;
        }

        return true;
    }
}
