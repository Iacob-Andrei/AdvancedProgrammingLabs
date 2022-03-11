public class Main {

    static void addNodesToNetwork(Network network){

        Node node1 = new Computer("23.43.254.12", 20, "v1");
        Node node2 = new Router("423.42.645.32", "v2");
        Node node3 = new Switch("341.522.21.2", "v3");
        Node node4 = new Switch("21.134.6.2", "v4");
        Node node5 = new Router("51.321.36.8", "v5");
        Node node6 = new Computer("43.2.98.0", 50, "v6");

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
        System.out.println(network);
    }
}
