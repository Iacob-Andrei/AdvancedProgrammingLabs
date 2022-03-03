import java.util.ArrayList;

public class DSatur {

    public ArrayList<Event> vertexes;
    public ArrayList<Room> colors;
    public boolean[][] matrixOfAdjacency;

    /**
     * Events can be seen as vertexes
     * Rooms can be seen as colors
     * @param myProblem - the instance for DSatur algorithm
     */
    DSatur(Problem myProblem){

        vertexes = new ArrayList<Event>(myProblem.events);
        colors = new ArrayList<Room>(myProblem.rooms);
        createMatrixOfAdjacency();
    }


    /**
     * complete the adjacency matrix as follows:
     * two events are adjacent if they intersect
     * if they do, we consider an edge between them
     * if not, there isn't an edge
     */
    public void createMatrixOfAdjacency(){

        int size = vertexes.size();
        matrixOfAdjacency = new boolean[size][size];

        for( int line = 0 ; line < size ; line++ ){
            for(int column = line ; column < size ; column++ )
                if( line == column )
                    matrixOfAdjacency[line][column] = true;
                else if( checkIfIntersect(vertexes.get(line), vertexes.get(column)) ){

                    matrixOfAdjacency[line][column] = true;
                    matrixOfAdjacency[column][line] = true;
                }
                else{

                    matrixOfAdjacency[line][column] = false;
                    matrixOfAdjacency[column][line] = false;
                }
        }
    }

    /**
     * Method check is two events intersect
     * first check if the first event start between the conduct of the second event
     * if it does, @return true
     *
     * check if the second event start between the conduct of the first event
     * if it does, @return true
     *
     * if both tests are false, @return false
     * @param event1 - first event
     * @param event2 - second event
     */
    public boolean checkIfIntersect( Event event1, Event event2 ){

        int ev1Start = event1.getStart();
        int ev1End = event1.getEnd();
        int ev2Start = event1.getStart();
        int ev2End = event2.getEnd();

        if( ev1Start > ev2Start && ev1Start < ev2End )
            return true;

        if(  ev2Start > ev1Start && ev2Start < ev1End )
            return true;

        return false;
    }

    /**
     *
     */
    public void degreeOfSaturation(){

    }
}
