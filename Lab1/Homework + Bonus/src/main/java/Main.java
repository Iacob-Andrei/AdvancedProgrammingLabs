public class Main {

    public static void main(String[] args) {

        Homework myHomework = new Homework();
        if(!myHomework.validateInput(args))
            System.exit(0);

        if(!myHomework.validateLetters(args))
            System.exit(0);

        myHomework.createWords(args);
        myHomework.neighbours();
        myHomework.printArraysOfNeighbors();

        Bonus myBonus = new Bonus(myHomework.getWords());
        myBonus.bonus();
        System.out.println(myBonus.toString());

    }
}
