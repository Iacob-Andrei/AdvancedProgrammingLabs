package commands;

import java.awt.*;
import java.io.File;

public class ViewCommand extends Command{

    public ViewCommand(){
        this.name = "View command";
        this.description = "opens an item using the native operating system application";
    }

    @Override
    public void getInfo() {
        System.out.println(name + " " + description);
    }

    /**
     * open an existing file using the default app on desktop
     * @param path to the file that needs to be opened
     */
    public void view(String path){

        try{
            File file = new File(path);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        }
        catch (Exception e ){
            System.err.println(e.getMessage());
        }

    }
}
