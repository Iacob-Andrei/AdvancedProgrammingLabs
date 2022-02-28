import java.util.ArrayList;

public class Bonus extends Homework{

    protected ArrayList<String> arrayOfCycle;

    Bonus(ArrayList<String> words){
        // constructor
        this.words = new ArrayList<>(words);
        createMatrix();
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Lungime: ").append(arrayOfCycle.size()).append(", cuvinte: ");
        for(String word : arrayOfCycle ){
            stringBuilder.append(word).append(" ");
        }

        return stringBuilder.toString();
    }

    public void bonus(){

        arrayOfCycle = new ArrayList<String>();

        // starting an DFS traversal for every word ( words can be associated with nodes )
        for( String word : words ) {

            ArrayList<String> visited = new ArrayList<String>();
            visited.add(word);

            visited = DFS( matrix, words, visited, words.indexOf(word) );

            // checking if the result is better
            if( arrayOfCycle.size() < visited.size() )
                arrayOfCycle = visited;
        }
    }

    public ArrayList<String> DFS( boolean[][] matrix, ArrayList<String> words, ArrayList<String> visited, int actualPos ){

        /*
        checking only if we visited more than one word
        if the last visited word is the same as the first one, we have a cycle -> check for length
        if the last visited word appears in another position, diff the first, we have a cycle that do not contain all the words
         */
        if( visited.size() != 1 ){
            if( visited.indexOf( words.get(actualPos) ) == 0 && visited.size() > 4 ){
                return visited;
            }
            else if( visited.indexOf( words.get(actualPos) ) != (visited.size() - 1) ){
                return new ArrayList<String>();
            }
        }

        ArrayList<String> best = new ArrayList<>(visited);

        // for the neighbors of last visited word, call another DFS method
        // check if the returned array is better
        for( int column = 0 ; column < words.size() ; column++ ){

            if( !( column == actualPos ) )
                if( matrix[actualPos][column] ){

                    ArrayList<String> tempVisited = new ArrayList<>(visited);
                    tempVisited.add(words.get(column));

                    tempVisited = DFS(matrix, words, tempVisited, column);

                    if( best.size() < tempVisited.size() )
                        best = tempVisited;
                }
        }

        // checking if the final array is a cycle
        if( best.get(0).equals(best.get( best.size() - 1 )) )
            return best;
        else
            return new ArrayList<String>();
    }
}
