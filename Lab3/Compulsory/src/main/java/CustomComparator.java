import java.util.Comparator;

public class CustomComparator implements Comparator<Node> {

    /**
     * comparator used to sort arraylist of Identifiable objects( Computers & Routers )
     * @param node1 first node
     * @param node2 second node
     * @return 0 if the nodes are equal, -1 if the first node is bigger, else 1 ( comparing their addresses )
     */
    public int compare(Node node1, Node node2){

        return ((Identifiable) node1).getIPAddress().compareTo(((Identifiable) node2).getIPAddress());
    }

}