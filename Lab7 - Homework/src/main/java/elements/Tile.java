package elements;

import java.util.StringJoiner;

public class Tile {

    private final char letter;
    private final int points;

    public Tile(char letter){

        this.letter = letter;
        this.points = (int)((Math.random() * (11 - 1 )) + 1);
    }

    public char getLetter() {
        return letter;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "[", "]")
                .add("letter=" + letter)
                .add("points=" + points)
                .toString();
    }


}
