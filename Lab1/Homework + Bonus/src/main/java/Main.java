public class Main {

    public static void main(String[] args) {

        long startTime = System.nanoTime();

        Homework myHomework = new Homework();
        if(!myHomework.validateInput(args))
            System.exit(0);

        if(!myHomework.validateLetters(args))
            System.exit(0);

        myHomework.createWords(args);
        myHomework.neighbours();

        if( Integer.parseInt(args[0]) < 20_000 ){
            myHomework.printArraysOfNeighbors();
            myHomework.printMatrix();

            Bonus myBonus = new Bonus(myHomework.getWords());
            myBonus.bonus();
            System.out.println(myBonus.toString());
        }

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}
