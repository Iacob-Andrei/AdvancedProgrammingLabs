public class Main {

    public static void main(String[] args) {


        Problem myProblem = new Problem();
        Solution solution = new Solution(myProblem);
        DSatur bonus = new DSatur(myProblem);

        long startTime = System.nanoTime();

        solution.assignRoomToEvent();

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Total time for greedy algorithm: " + totalTime + " nanoseconds.\n");

        startTime = System.nanoTime();

        bonus.degreeOfSaturation();

        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("Total time for DSatur algrotihm: " + totalTime + " nanoseconds.");
    }
}
