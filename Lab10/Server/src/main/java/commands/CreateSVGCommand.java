package commands;

import client.ClientState;
import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.util.mxCellRenderer;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import server.Info;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;

public class CreateSVGCommand implements ExecuteCommand {


    /**
     * creates an undirected graph using JGraphT
     * every user in the social network represents a vertex
     * every friendship relationship represent an edge
     */
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
     * creates a PNG representation of the social network
     * JGraphXAdapter is used to graphically generate the graph
     */
    private void createImagePNG() {

        try {
            File imgFile = new File("src/main/resources/social.png");

            JGraphXAdapter<String, DefaultEdge> graphAdapter = new JGraphXAdapter<>(createGraph());
            mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
            layout.execute(graphAdapter.getDefaultParent());

            BufferedImage image = mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);
            ImageIO.write(image, "PNG", imgFile);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * creates an SVG representation of the social network
     * based on the previous created PNG
     * DOMImplementation object to generate the XML proprieties of the SVG
     * SVGGraphics2D ( Apache Batik ) convert PNG to SVG
     */
    private void createSvg() {

        try {
            createImagePNG();

            DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();

            String svgNS = "http://www.w3.org/2000/svg";
            Document document = domImpl.createDocument(svgNS, "svg", null);

            SVGGraphics2D graphics = new SVGGraphics2D(document);

            File imageSrc = new File("src/main/resources/social.png");
            BufferedImage img = ImageIO.read(imageSrc);
            graphics.drawImage(img,0,0,null);

            Writer out = new OutputStreamWriter(new FileOutputStream("src/main/resources/social.svg"), StandardCharsets.UTF_8);
            graphics.stream(out, true);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param args command arguments ( should be empty )
     * @param clientState client state ( can be logged or not )
     * @return create the SVG representation and return a specific message that will be redirected to the client
     */
    @Override
    public String executeCommand(List<String> args, ClientState clientState) {

        createSvg();
        return "social network png&svg created";
    }
}
