public abstract class Item {

    String id;
    String title;
    String location;

    Item(String id, String title, String location){
        this.id = id;
        this.title = title;
        this.location = location;
    }

    public abstract String getId();

    public abstract void setId(String id);

    public abstract String getTitle();

    public abstract void setTitle(String title);

    public abstract String getLocation();

    public abstract  void setLocation(String location);
}
