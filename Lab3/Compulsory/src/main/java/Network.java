import java.util.ArrayList;
import java.util.List;

public class Network {

    private List<Node> nodes = new ArrayList<>();

    public void addNode(Node node) {
        nodes.add(node);
    }

    public String toString(){

        StringBuilder toString = new StringBuilder();
        for(Node node : nodes){

            toString.append(node.toString());
            toString.append("\n");
        }

        return toString.toString();
    }

}
