package commands;

import catalog.Catalog;
import custom_exceptions.CustomException;
import items.Item;

public class AddCommand extends Command{

    public AddCommand(){
        this.name = "Add Command";
        this.description = "adds a new entry into the catalog.";
    }

    public void getInfo(){
        System.out.println( name + " " + description );
    }

    public void add(Catalog catalog, Item item){

        try{
            if( catalog == null )
                throw new CustomException("Catalog is null!");
            if( item == null)
                throw new CustomException("Item is null!");

            if( !catalog.getCatalog().contains(item) )
                catalog.getCatalog().add(item);

        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
