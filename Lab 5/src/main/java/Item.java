import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "type")

@JsonSubTypes({
        @JsonSubTypes.Type(value = Article.class),
        @JsonSubTypes.Type(value = Book.class),
})

public abstract class Item {

    protected String id;
    protected String title;
    protected String location;

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
