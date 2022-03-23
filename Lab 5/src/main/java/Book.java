import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book extends Item {

    private int year;
    private String author;

    @JsonCreator
    public Book(  @JsonProperty("id") String id,
                  @JsonProperty("title") String title,
                  @JsonProperty("location") String location,
                  @JsonProperty("year") int year,
                  @JsonProperty("author") String author
                  ) {
        super(id,title,location);
        this.year = year;
        this.author = author;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
