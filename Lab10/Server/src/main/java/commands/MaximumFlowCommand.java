package commands;

import client.ClientState;
import org.jgrapht.alg.flow.EdmondsKarpMFImpl;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;
import server.Info;

import java.util.List;
import java.util.Set;

/**
 * creates an undirected graph using JGraphT
 * every user in the social network represents a vertex
 * every friendship relationship represent an edge
 * it will show the maximum flow of this graph
 */
public class MaximumFlowCommand implements ExecuteCommand{

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

    @Override
    public String executeCommand(List<String> args, ClientState clientState) {
        DefaultUndirectedGraph<String, DefaultEdge> network = createGraph();
        var flow = new EdmondsKarpMFImpl(network);
        double maxFlow = flow.calculateMaximumFlow(Info.getUsers().get(0),Info.getUsers().get(Info.getUsers().size()-1));

        return "The max flow of this social network is " + maxFlow;

    }
}
