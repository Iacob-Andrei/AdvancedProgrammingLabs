package commands;

import catalog.Catalog;

public class ReportCommand extends Command{

    public ReportCommand(){
        this.name = "Report command";
        this.description = "creates (and opens) an HTML report representing the content of the catalog.";
    }

    @Override
    public void getInfo() {
        System.out.println(name + " " + description);
    }

    public void report(Catalog catalog){

    }
}
