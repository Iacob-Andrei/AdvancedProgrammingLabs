public abstract class Node implements Comparable<Node>{

    protected String name;

    abstract public String getName();

    abstract public void setName(String name);

    abstract public String toString();

    abstract public int compareTo(Node node);
}
