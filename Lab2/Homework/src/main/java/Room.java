public abstract class Room {

    protected String name;
    protected int capacity;
    protected String type;

    abstract String getName();

    abstract void setName(String name);

    abstract int getCapacity();

    abstract void setCapacity(int capacity);

    abstract String getType();

    abstract void setType(String type);
}