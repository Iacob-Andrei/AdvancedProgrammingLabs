package commands;

import catalog.Catalog;
import custom_exceptions.CustomException;
import items.Item;

public class ListCommand extends Command{

    public ListCommand(){
        this.name = "List Command";
        this.description = "prints the list of items on the screen.";
    }

    public void getInfo(){
        System.out.println( name + " " + description );
    }

    /**
     * prints the list of a catalog
     * @param catalog input
     */
    public void list( Catalog catalog ) {

        try{
            if( catalog == null )
                throw new CustomException("Catalog is null!");

            if( catalog.getCatalog().isEmpty() )
                throw new CustomException("Catalog array is empty!");

            for( Item item : catalog.getCatalog() )
                System.out.println(item);
        }
        catch( Exception e){
            System.err.println(e.getMessage());
        }
    }
}
