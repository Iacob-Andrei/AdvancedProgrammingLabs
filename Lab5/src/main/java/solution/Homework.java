package solution;

import catalog.Catalog;
import commands.*;
import items.*;

public class Homework {

    public static void main(String[] args) {

        Article article1 = new Article(
                "java17",
                "The Java Language Specification",
                "https://docs.oracle.com/javase/specs/jls/se17/html/index.html",
                "ORACLE"
        );

        Book book1 = new Book(
                "knuth67",
                "The Art of Computer Programming",
                "d:/books/programming/tacp.ps",
                1967,
                "Donald E. Knuth"
        );
        Catalog catalog = new Catalog("Catalog name..");

        AddCommand commandAdd = new AddCommand();
        ListCommand commandList = new ListCommand();
        ViewCommand commandView = new ViewCommand();
        ReportCommand reportCommand = new ReportCommand();
        //InfoCommand infoCommand = new InfoCommand();

        commandAdd.add(catalog, article1);
        commandAdd.add(catalog, book1);
        //commandList.list(catalog);
        //commandView.view("target/catalog.json");

        reportCommand.report(catalog);
        //infoCommand.info("target/template/report.html");
    }

}
