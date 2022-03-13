import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node>{

    protected String name;
    protected Map<Node, Integer> cost = new HashMap<>();

    abstract Map<Node, Integer> getCost();

    abstract public void setCost(Node node, int value);

    abstract public String getCosts();

    abstract public String getName();

    abstract public void setName(String name);

    abstract public String toString();

    abstract public int compareTo(Node node);
}
