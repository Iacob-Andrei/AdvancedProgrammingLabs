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

        Catalog catalog = new Catalog("Catalog name..");

        AddCommand commandAdd = new AddCommand();
        ListCommand commandList = new ListCommand();
        ViewCommand commandView = new ViewCommand();

        //commandAdd.add(catalog, article1);
        //commandList.list(catalog);
        //commandView.view("target/catalog.json");
    }
}
