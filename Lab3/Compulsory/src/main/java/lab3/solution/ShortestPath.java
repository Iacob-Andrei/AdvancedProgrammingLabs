package lab3.solution;

import lab3.interfaces.Identifiable;
import lab3.nodes.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestPath {

    /**
     * constructor, also call for dijkstra algorithm
     * in order to compute the shortest path, for every node as starting point
     * @param nodes list of nodes
     */
    ShortestPath(List<Node> nodes){

        for( Node node : nodes )
            if( node instanceof Identifiable)
                dijkstra(nodes, node);
    }

    /**
     * create a map to store the costs to go from starting point to a specified node
     *
     * create two lists, "visited" and "toVisit"
     * adds the starting node to "toVisit" list and start iterating
     *
     * while there are accessible nodes, it picks the one with the lowest cost
     * removes it from toVisit ( it's visited in the iteration )
     *
     * for every adjacent node with the selected one
     * it updates the costs to go to the specific node and add it to "toVisit"
     *
     * in the end, add the current one ( the one that was iterated ) to the "visited" list
     *
     * @param nodes list of every node
     * @param startNode the starting point
     */
    public void dijkstra(List<Node> nodes, Node startNode){

        Map<Node, Integer> costs = new HashMap<>();
        for( Node node : nodes )
            costs.put( node, 9999999 );
        costs.put(startNode, 0);

        List<Node> visited = new ArrayList<>();
        List<Node> toVisit = new ArrayList<>();

        toVisit.add( startNode );

        while( toVisit.size() != 0 ){

            Node currentNode = getLowestDistance(toVisit, costs);
            toVisit.remove(currentNode);

            Map<Node, Integer> currentNodeAdjacency = currentNode.getCost();

            for( Node node : currentNodeAdjacency.keySet() ){

                int value = currentNodeAdjacency.get(node);

                if( !visited.contains(node) ){
                    costs = updateMinimumDistance( node, value, currentNode, costs );
                    toVisit.add(node);
                }
            }
            visited.add(currentNode);
        }


        System.out.println("Starting from " + startNode.getName() + " we have costs:");
        for( Node node : costs.keySet() ){
            if( !node.equals(startNode) )
                if( node instanceof Identifiable)
                    System.out.println( "\t" + node.getName() + " with cost: " + costs.get(node));
        }
    }


    /**
     * check every node from "unvisited" list
     * and select the one that has the lowest cost
     *
     * @param unvisited list of the nodes that were not visited
     * @param costs costs between the original starting node and every node
     * @return the next node that needs to be verified
     */
    private Node getLowestDistance( List<Node> unvisited, Map<Node, Integer> costs ){

        Node lowestDistanceNode = null;
        int lowestDistance = 9999999;

        for( Node node : unvisited ){

            int distance = costs.get(node);
            if( distance < lowestDistance ){
                lowestDistance = distance;
                lowestDistanceNode = node;
            }
        }

        return lowestDistanceNode;
    }

    /**
     * update the distance between two nodes
     * @param node first node
     * @param value the cost between the two nodes
     * @param sourceNode second node
     * @param costs the map containing all costs between the original starting point and every node
     * @return the updated "costs" map
     */
    private Map<Node, Integer> updateMinimumDistance(Node node, int value, Node sourceNode,  Map<Node, Integer> costs){

        int sourceDistance = costs.get(sourceNode);
        if( sourceDistance + value < costs.get(node) ){
            costs.put(node, sourceDistance + value);
        }

        return costs;
    }

}
