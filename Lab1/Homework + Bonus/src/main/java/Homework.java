import java.util.ArrayList;

public class Homework {

    protected boolean[][] matrix;
    protected ArrayList<String> words;
    protected ArrayList<ArrayList<String>> neighborsList;

    public ArrayList<String> getWords(){
        return words;
    }

    public int isNumber(String number) {

        // checking if the arg is a number
        for(char a : number.toCharArray() ) {
            if( a < '0' || a > '9' ) {
                System.out.println("Input \"" + number + "\" incorect!" );
                return -1;
            }
        }

        int x = Integer.parseInt(number);
        return x;
    }

    public boolean checkLetters(String word) {
        // letters should have length 1, if not, input is incorrect
        if( word.length() != 1 )
            return false;

        // checking if the args are letters, not others characters
        for( char a : word.toCharArray() ) {
            if( !((a >= 'a' && a <= 'z')||(a >= 'A' && a <= 'Z')) ) {
                return false;
            }
        }

        return true;
    }

    public boolean validateInput(String[] args) {
        // checking if the first arg is number
        if( isNumber(args[0]) == -1 ) {
            System.out.println("Input \"" + args[0] + "\" incorect!" );
            return false;
        }

        // checking if the second arg is number
        if( isNumber(args[1]) == -1 ){
            System.out.println("Input \"" + args[1] + "\" incorect!" );
            return false;
        }

        return true;
    }

    public boolean validateLetters(String[] args) {

        // checking if the args from third are letters
        for( int argument = 2 ; argument < args.length ; argument++ ) {
            if( checkLetters(args[argument]) == false ) {
                System.out.println("Input " + args[argument] + " incorect!" );
                return false;
            }
        }

        return true;
    }

    public void createWords(String[] args) {

        int n = Integer.parseInt(args[0]);
        int p = Integer.parseInt(args[1]);

        // creating random words, that are stored in the Array words.
        words = new ArrayList<String>();

        for(int counter1 = 0 ; counter1 < n ; counter1++ ) {

            StringBuilder sb = new StringBuilder();
            for(int counter2 = 0 ; counter2 < p ; counter2++ ) {
                int pos = (int) (Math.random() * ( args.length - 2  )) + 2;
                // 				(Math.random() * (max - min)) + min)
                sb.append(args[pos]);
            }
            words.add(sb.toString());
        }
    }

    public boolean checkIfNeighbors( String word1, String word2 ) {

        // checking if any letter of word1 is contained in word2
        for( int counter = 0 ; counter < word1.length() ; counter++ ) {
            if( word2.indexOf( word1.charAt(counter) ) != -1 ) {
                return true;
            }
        }

        return false;
    }

    public void createMatrix() {

        int line, column;
        int n = words.size();
        matrix = new boolean[n][n];

        // declaring an adjacency  matrix of n*n
        // traversing only the superior matrix, completing it over symmetry
        for (line = 0; line < n; line++) {
            for (column = line; column < n; column++) {
                if (line == column) {
                    matrix[line][column] = true;
                } else if (checkIfNeighbors(words.get(line), words.get(column))) {
                    matrix[line][column] = true;
                    matrix[column][line] = true;
                } else {
                    matrix[line][column] = false;
                    matrix[column][line] = false;
                }
            }
        }
    }

    public void arrayOfNeighbors(){

        int counter1, counter2, n = words.size();

        neighborsList = new ArrayList<ArrayList<String>>();

        // declaring an array that stores array, each array containing the neighbors of a word
        for( counter1 = 0 ; counter1 < n ; counter1++ ) {
            ArrayList<String> wordList = new ArrayList<String>();

            for( counter2 = 0 ; counter2 < n ; counter2++ ) {
                if( counter1 != counter2 && matrix[counter1][counter2] == true ) {
                    wordList.add(words.get(counter2));
                }
            }
            neighborsList.add(wordList);
        }
    }

    public void neighbours(){

        // calling the createMatrix method to create the adjacency matrix
        createMatrix();

        // creating and printing the arrays of neighbors by calling the arrayOfNeighbors method
        arrayOfNeighbors();
    }

    public void printWords(){
        for(String word : words)
            System.out.println("Cuvant: " + word);
    }

    public void printMatrix(){
        for( boolean[] list : matrix ){
            for( boolean value : list ){
                System.out.print(value + "  ");
            }
            System.out.println();
        }
    }

    public void printArraysOfNeighbors(){

        int counter = 0;
        for( ArrayList<String> array : neighborsList ){

            System.out.print("Cuvantul: " + words.get(counter) + " are vecinii: ");
            for( String neighbor : array ){
                System.out.print(neighbor + "  ");
            }
            counter++;
            System.out.println();
        }
        System.out.println();
    }
}