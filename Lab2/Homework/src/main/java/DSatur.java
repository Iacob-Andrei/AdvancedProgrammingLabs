import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DSatur {

    private ArrayList<Event> vertexes;
    private ArrayList<Room> colors;
    private boolean[][] matrixOfAdjacency;
    private HashMap<Integer, String> vertexColor;


    /**
     * Events can be seen as vertexes
     * Rooms can be seen as colors
     * @param myProblem the instance for DSatur algorithm
     */
    DSatur(Problem myProblem){

        vertexes = new ArrayList<Event>(myProblem.events);
        colors = new ArrayList<Room>(myProblem.rooms);
        Collections.sort(colors, new CustomComparatorRoom());
        createMatrixOfAdjacency();
    }

    /**
     * complete the adjacency matrix as follows:
     * two events are adjacent if they intersect
     * if they do, we consider an edge between them
     * if not, there isn't an edge
     */
    private void createMatrixOfAdjacency(){

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
     * @param event1 first event
     * @param event2 second event
     */
    private boolean checkIfIntersect( Event event1, Event event2 ){

        int ev1Start = event1.getStart();
        int ev1End = event1.getEnd();
        int ev2Start = event2.getStart();
        int ev2End = event2.getEnd();

        if( ev1Start >= ev2Start && ev1Start < ev2End )
            return true;

        if(  ev2Start >= ev1Start && ev2Start < ev1End )
            return true;

        return false;
    }

    /**
     * construct the hashmap "vertexColor", to store the index of the vertexes, along with their assigned color
     *
     * first call the "getMaxDegreeUncolored" to assign the first color to the vertex with the highest degree
     *
     * then, for the rest of the index, it's called the method "getMaxDegreeInColored"
     * the method indicate the vertex that needs to be colored
     * for every vertex returned, we check if the colors met the requirements
     *
     * if it does, check if the color is used for any of the neighbor of the vertex
     * if not, assign the color to the vertex
     *
     * repeat for every vertex
     */
    public void degreeOfSaturation(){

        vertexColor = new HashMap<Integer, String>();
        int firstVertexColored = getMaxDegreeUncolored();

        for( Room color : colors ){

            if( color.getType().charAt(0) == vertexes.get(firstVertexColored).getName().charAt(0) )
                if( color.capacity >= vertexes.get(firstVertexColored).getNumberOfParticipants() ) {

                    vertexColor.put(firstVertexColored, color.getName());
                    System.out.println(vertexes.get(firstVertexColored).getName() + " -> " + color.getName());
                    break;
                }
        }

        int count = 1;
        while( count != vertexes.size() ){

            int indexVertexToColor = getMaxDegreeInColored(vertexColor);

            for( Room color : colors ){

                if( color.getType().charAt(0) == vertexes.get(indexVertexToColor).getName().charAt(0) ){

                   boolean colorUsedByNeighbor = false;
                   for( int column = 0 ; column < vertexes.size(); column++ ){
                       if( matrixOfAdjacency[indexVertexToColor][column] )
                           if( !(vertexColor.get(column) == null) )                         // if the node was colored
                               if( vertexColor.get(column).equals(color.getName()) ) {      // if the color was used
                                   colorUsedByNeighbor = true;
                                   break;
                               }
                   }

                   if( !colorUsedByNeighbor ){
                       vertexColor.put(indexVertexToColor, color.getName());
                       System.out.println(vertexes.get(indexVertexToColor).getName() + " -> " + color.getName());
                       break;
                   }
                }
            }
            count++;
        }
    }

    /**
     * the method parse the vertexes arrays
     * in order to get the vertex with the maximum degree, it goes through all the vertex that are not current colored
     * to get the degree of a vertex, the "getDegreeColored" is called
     *
     * @param vertexColor the assignated events with their rooms
     * @return the index of the vertex that is adjacent with the most colored vertexes
     */
    private int getMaxDegreeInColored(HashMap<Integer, String> vertexColor){

        int position = 0;
        int degreeMax = -1;
        int pozMax = -1;
        int degreeMaxUncolored = -1;

        for( Event event : vertexes ){

            if( !vertexColor.containsKey(position) ){

                int degree = getDegreeColored(position, vertexColor);
                int degreeUncolored = getDegreeUncolored(position);

                if( degree > degreeMax ){

                    degreeMax = degree;
                    pozMax = position;
                    degreeMaxUncolored = degreeUncolored;
                }
                else if( degree == degreeMax && degreeUncolored > degreeMaxUncolored){

                        pozMax = position;
                        degreeMaxUncolored = degreeUncolored;
                }
            }
            position++;
        }

        return pozMax;
    }

    /**
     * @param position position of vertex in the array, vertex that needs to be computed
     * @param vertexColor contains the assignations of events to rooms
     * @return the degree of adjacent colors events
     */
    private int getDegreeColored(int position, HashMap<Integer, String> vertexColor) {

        int degree = 0;
        for( int column = 0 ; column < vertexes.size() ; column++ ){

            if( column != position )
                if( matrixOfAdjacency[position][column] )
                    if( vertexColor.containsKey( column ) )
                        degree++;
        }

        return degree;
    }

    /**
     * @return the index of the vertex that has the maximum degree in the uncolored graph
     */
    private int getMaxDegreeUncolored(){

        int positionMax = 0;
        int maxDegree = 0;
        int size = vertexes.size();

        for( int line = 0 ; line < size; line++ ){

            int degree = getDegreeUncolored(line);

            if( degree > maxDegree ){
                maxDegree = degree;
                positionMax = line;
            }
        }

        return positionMax;
    }

    /**
     * @param index of vertex in the array
     * @return the degree of the vertex
     */
    private int getDegreeUncolored(int index){

        int degree = 0;
        int size = vertexes.size();

        for(int column = 0 ; column < size; column++){

            if( index != column && matrixOfAdjacency[index][column] )
                degree++;
        }

        return degree;
    }
}
