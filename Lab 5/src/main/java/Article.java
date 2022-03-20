public class Article extends Item{

    private String magazine;

    public Article(String id, String title, String location, String magazine) {
        super(id,title,location);
        this.magazine = magazine;
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

    public String getMagazine() {
        return magazine;
    }

    public void setMagazine(String magazine) {
        this.magazine = magazine;
    }


    @Override
    public String toString() {

        return "{\"id\":\"" +
                this.getId() +
                "\", \"title\":\"" +
                this.getTitle() +
                "\", \"location\":\"" +
                this.getLocation() +
                "\", \"magazine\":\"" +
                this.getMagazine() +
                "\"};";
    }
}
