package lab3.instance;

import lab3.interfaces.Identifiable;
import lab3.nodes.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Network {

    private List<Node> nodes = new ArrayList<>();

    public List<Node> getNodes() {
        return nodes;
    }

    public void addNode(Node node) {
        if( node != null)
            nodes.add(node);
    }

    public void sort(){
        Collections.sort(nodes);
    }

    /**
     * create an arraylist only for identifiable objects
     * sorts the array using custom comparator ( sorting after their address)
     */
    public void identifiableNodes(){

        List<Node> identifiableList = new ArrayList<>();

        for( Node node : nodes ){
            if( node instanceof Identifiable){
                identifiableList.add(node);
            }
        }

        identifiableList.sort(new CustomComparator());

        for( Node node : identifiableList){
            System.out.println(node);
        }
    }

    public String toString(){

        StringBuilder toString = new StringBuilder();
        for(Node node : nodes){

            toString.append(node.toString());
            toString.append("\n");
        }

        return toString.toString();
    }

    /**
     * @return every node in "nodes" list, along with their adjacent nodes and costs
     */
    public String getCosts(){

        StringBuilder sb = new StringBuilder();

        for( Node node : nodes ){
            sb.append(node.getCosts());
        }

        return sb.toString();
    }

}
