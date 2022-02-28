public class Room {

    private Type type;
    private String name;
    private int capacity;

    Room(Type type, String name, int capacity){
        this.type = type;
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name + "(cap=" + capacity + ", type=" + type + ")";
    }
}
