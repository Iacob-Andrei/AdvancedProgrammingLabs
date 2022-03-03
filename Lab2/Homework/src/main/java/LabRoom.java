public class LabRoom extends Room{

    private String operatingSystem;

    public LabRoom(String operatingSystem, String name, int capacity){
        this.operatingSystem = operatingSystem;
        this.name = name;
        this.capacity = capacity;
        this.type = "Lab";
    }

    public String getOperatingSystem(){
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem){
        this.operatingSystem = operatingSystem;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getCapacity(){
        return capacity;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return getName() + "(cap=" + getCapacity() + " , " + getType() + ", " + getOperatingSystem() + ")";
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;
        if (!(obj instanceof Room)) return false;

        Room that = (Room) obj;
        return getName().equals(that.getName());
    }
}
