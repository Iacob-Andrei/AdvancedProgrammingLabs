package elements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Dictionary {

    private Bag bag = new Bag(null);
    private Hashtable<String, Integer> dictionary = new Hashtable<>();

    public Dictionary(String path){

        try{
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while( (line = bufferedReader.readLine()) != null ){
                dictionary.put(line.toUpperCase(), computePoints(line));
            }

            bufferedReader.close();
            fileReader.close();
        }catch( Exception e){
            e.printStackTrace();
        }
    }

    public Integer computePoints(String word){

        int points = 0;

        for( int index = 0 ; index < word.length() ; index++ ){

            char character = word.charAt(index);

            for( Tile tile : bag.getBag().keySet() ){
                if( character == tile.getLetter() ){
                    points += tile.getPoints();
                    break;
                }
            }
        }

        return points;
    }

    public boolean isWord(String word) {
        return dictionary.containsKey(word);
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

    public void throwTiles(String word, List<Tile> tiles){

        for( int index = 0 ; index < word.length() ; index++ ){
            for( Tile tile : tiles){
                if( word.charAt(index) == tile.getLetter() ){
                    tiles.remove(tile);
                    break;
                }
            }
        }
    }
}
