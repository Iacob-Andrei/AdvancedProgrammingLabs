import java.util.ArrayList;

public class Main {

    public static int is_number(String number) {

        for(char a : number.toCharArray() ) {
            if( a < '0' || a > '9' ) {
                System.out.println("Input \"" + number + "\" incorect!" );
                return -1;
            }
        }

        int x = Integer.parseInt(number);
        return x;
    }

    public static boolean check_word(String word) {
        if( word.length() != 1 )
            return false;

        for( char a : word.toCharArray() ) {
            if( !((a >= 'a' && a <= 'z')||(a >= 'A' && a <= 'Z')) ) {
                return false;
            }
        }

        return true;
    }

    public static boolean validateInput(String[] args) {

        if( is_number(args[0]) == -1 ) {
            System.out.println("Input \"" + args[0] + "\" incorect!" );
            return false;
        }

        if( is_number(args[1]) == -1 ){
            System.out.println("Input \"" + args[1] + "\" incorect!" );
            return false;
        }

        return true;
    }

    public static boolean validateLetters(String[] args) {

        for( int i = 2 ; i < args.length ; i++ ) {
            if( check_word(args[i]) == false ) {
                System.out.println("Input " + args[i] + " incorect!" );
                return false;
            }
        }

        return true;
    }

    public static ArrayList<String> createWords(String[] args) {

        int n = Integer.parseInt(args[0]);
        int p = Integer.parseInt(args[1]);

        ArrayList<String> words = new ArrayList<String>();
        for(int i = 0 ; i < n ; i++ ) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < p ; j++ ) {
                int pos = (int) (Math.random() * ( args.length - 2  )) + 2;
                // 				(Math.random() * (max - min)) + min)
                sb.append(args[pos]);
            }
            System.out.println("Cuvantul " + (i + 1) + " este: " + sb );
            words.add(sb.toString());
        }

        return words;
    }

    public static boolean checkIfNeighbors( String word1, String word2 ) {

        for( int i = 0 ; i < word1.length() ; i++ ) {
            if( word2.indexOf( word1.charAt(i) ) != -1 ) {
                return true;
            }
        }

        return false;
    }

    public static boolean[][] createMatrix(ArrayList<String> words) {

        int i, j;
        int n = words.size();
        boolean[][] matrix = new boolean[n][n];

        for (i = 0; i < n; i++) {
            for (j = i; j < n; j++) {
                if (i == j) {
                    matrix[i][j] = true;
                } else if (checkIfNeighbors(words.get(i), words.get(j))) {
                    matrix[i][j] = true;
                    matrix[j][i] = true;
                } else {
                    matrix[i][j] = false;
                    matrix[j][i] = false;
                }
            }
        }

        return matrix;
    }

    public static void arrayOfNeighbors(boolean[][] matrix, ArrayList<String> words){

        int i, j, n = words.size();

        ArrayList<ArrayList<String>> neighborsList = new ArrayList<ArrayList<String>>();

        for( i = 0 ; i < n ; i++ ) {
            ArrayList<String> wordList = new ArrayList<String>();

            for( j = 0 ; j < n ; j++ ) {
                if( i != j && matrix[i][j] == true ) {
                    wordList.add(words.get(j));
                }
            }
            neighborsList.add(wordList);
        }

        i = 0;
        System.out.println("\n");
        for( ArrayList<String> x : neighborsList) {

            //System.out.print("Cuvantul " + words.get(i) + " are vecinii: ");
            for(String y : x ) {
                //System.out.print(y + " ");
            }

            //System.out.println();
            i++;
        }

    }

    public static void neighbours(ArrayList<String> words){

        boolean[][] matrix = createMatrix(words);

        arrayOfNeighbors(matrix, words);
    }

    public static void bonus(ArrayList<String> words){

        ArrayList<String> noDupWords = new ArrayList<String>();

        for(String word : words ){
            if( noDupWords.contains(word) == false ){
                noDupWords.add(word);
            }
        }

        boolean[][] matrix = createMatrix(noDupWords);

        ArrayList<String> best = new ArrayList<String>();

        for( String word : noDupWords ) {

            ArrayList<String> visited = new ArrayList<String>();
            visited.add(word);

            visited = DFS( matrix, words, visited, words.indexOf(word) );

            if( best.size() < visited.size() )
                best = visited;
        }

        System.out.print("Avem lungimea " + best.size() + " si cuvintele: " + best);
    }

    public static ArrayList<String> DFS( boolean[][] matrix, ArrayList<String> words, ArrayList<String> visited, int actualPos ){

        if( visited.size() != 1 ){
            if( visited.indexOf( words.get(actualPos) ) == 0 ){
                return visited;
            }
            else if( visited.indexOf( words.get(actualPos) ) != (visited.size() - 1) ){
                return new ArrayList<String>();
            }
        }

        ArrayList<String> best = new ArrayList<>(visited);

        for( int i = 0 ; i < words.size() ; i++ ){

            if( !( i == actualPos ) )
                if( matrix[actualPos][i] ){

                    ArrayList<String> tempVisited = new ArrayList<>(visited);
                    tempVisited.add(words.get(i));

                    tempVisited = DFS(matrix, words, tempVisited, i);

                    if( best.size() < tempVisited.size() )
                        best = tempVisited;
                }
        }

        if( best.get(0) == best.get( best.size() - 1 ) )
            return best;
        else
            return new ArrayList<String>();
    }

    public static void main(String[] args) {

        if(!validateInput(args))
            System.exit(0);

        if(!validateLetters(args))
            System.exit(0);

        ArrayList<String> words = createWords(args);

        neighbours(words);
        bonus(words);
    }

}
