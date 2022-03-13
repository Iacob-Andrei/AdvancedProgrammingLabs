package lab3.instance;

import lab3.nodes.Computer;
import lab3.nodes.Node;
import lab3.nodes.Router;
import lab3.nodes.Switch;

public class Main {

    static void addNodesToNetwork(Network network){

        Node node1 = new Computer("23.43.254.12", 20, "v1");
        Node node2 = new Router("423.42.645.32", "v2");
        Node node3 = new Switch("v3");
        Node node4 = new Switch("v4");
        Node node5 = new Router("51.321.36.8", "v5");
        Node node6 = new Computer("43.2.98.0", 50, "v6");

        node1.setCost(node2, 10);
        node2.setCost(node1, 10);
        node1.setCost(node3, 50);
        node3.setCost(node1, 50);
        node2.setCost(node3, 20);
        node3.setCost(node2, 20);
        node2.setCost(node4, 20);
        node4.setCost(node2, 20);
        node2.setCost(node5, 10);
        node5.setCost(node2, 10);
        node3.setCost(node4, 20);
        node4.setCost(node3, 20);
        node4.setCost(node5, 30);
        node5.setCost(node4, 30);
        node4.setCost(node6, 10);
        node6.setCost(node4, 10);
        node5.setCost(node6, 20);
        node6.setCost(node5, 20);

        network.addNode(node5);
        network.addNode(node2);
        network.addNode(node4);
        network.addNode(node6);
        network.addNode(node1);
        network.addNode(node3);
    }

    public static void main(String[] args) {

        Network network = new Network();
        addNodesToNetwork(network);
        network.sort();

        //System.out.println(network);
        //System.out.println(network.getCosts());
        //network.identifiableNodes();

        //lab3.solution.ShortestPath sp = new lab3.solution.ShortestPath(network.getNodes());
    }
}
