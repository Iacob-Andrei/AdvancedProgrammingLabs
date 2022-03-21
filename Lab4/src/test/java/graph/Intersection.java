package graph;
import java.util.Objects;

public class Intersection {

    private String name;

    public Intersection(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * @param o object to be compared
     * @return -1 if the first object is grater than the second, 0 if they are equal, 1 otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Intersection that = (Intersection) o;

        return this.getName().equals(that.getName());
    }

    /**
     * @return the hashcode of object "graph.Intersection", computed on "name"
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
