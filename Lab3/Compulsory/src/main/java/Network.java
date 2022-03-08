import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Network {

    private List<Node> nodes;

    Network(){
        nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        if( node != null)
            nodes.add(node);
    }

    public void sort(){
        Collections.sort(nodes);
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
