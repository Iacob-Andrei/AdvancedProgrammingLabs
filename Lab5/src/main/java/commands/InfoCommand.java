package commands;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.sax.BodyContentHandler;
import java.io.FileInputStream;

public class InfoCommand extends Command {

    public InfoCommand(){
        this.name = "Info command";
        this.description = "use Apache Tika in order to extract metadata from your catalog items.";
    }

    public void getInfo(){
        System.out.println( name + " " + description );
    }

    public void info(String path){

        try{
            BodyContentHandler handler = new BodyContentHandler();
            Metadata metadata = new Metadata();
            FileInputStream inputstream = new FileInputStream(path);
            ParseContext pcontext = new ParseContext();

            HtmlParser htmlparser = new HtmlParser();
            htmlparser.parse(inputstream, handler, metadata,pcontext);
            System.out.println("Contents of the document:" + handler);
            System.out.println("Metadata of the document:");
            String[] metadataNames = metadata.names();

            for(String name : metadataNames) {
                System.out.println(name + ":   " + metadata.get(name));
            }
        } catch(Exception e){
            System.err.println(e.getMessage());
        }

    }
}
