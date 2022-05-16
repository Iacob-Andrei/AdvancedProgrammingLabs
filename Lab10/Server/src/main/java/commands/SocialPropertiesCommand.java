package commands;

import client.ClientState;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;
import server.Info;

import java.util.List;
import java.util.Set;


/**
 * creates an undirected graph using JGraphT
 * every user in the social network represents a vertex
 * every friendship relationship represent an edge
 */
public class SocialPropertiesCommand implements ExecuteCommand {

    private DefaultUndirectedGraph<String, DefaultEdge> createGraph() {

        DefaultUndirectedGraph<String, DefaultEdge> graph = new DefaultUndirectedGraph<>(DefaultEdge.class);

        for (String user : Info.getUsers())
            graph.addVertex(user);

        for (String key : Info.getFriends().keySet()) {
            Set<String> friends = Info.getFriends().get(key);

            for (String friend : friends) {
                graph.addEdge(key, friend);
            }
        }

        return graph;
    }

    /**
     * https://www.the-vital-edge.com/what-is-network-density/
     * @param args command arguments
     * @param clientState client state ( can be logged or not )
     * @return network density
     */
    @Override
    public String executeCommand(List<String> args, ClientState clientState) {

        DefaultUndirectedGraph<String, DefaultEdge> socialGraph = createGraph();

        int numberVertex = socialGraph.vertexSet().size();
        int numberEdges = socialGraph.edgeSet().size();

        double potentialConn = (double) numberVertex * ( numberVertex - 1 ) / 2 ;
        double networkDensity = (double)numberEdges / potentialConn;

        return "Network density is " + networkDensity;
    }
}
