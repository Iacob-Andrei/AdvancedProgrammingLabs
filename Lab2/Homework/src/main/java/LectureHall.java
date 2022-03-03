public class LectureHall extends Room{

    private boolean videoProjector;

    /**
     * initializes the variables
     * @param videoProjector - true if the room has a video projector, false if not
     * @param name - name of the room
     * @param capacity - the capacity
     */
    public LectureHall(boolean videoProjector, String name, int capacity) {
        this.videoProjector = videoProjector;
        this.name = name;
        this.capacity = capacity;
        this.type = "Course hall";
    }

    public boolean getVideoProjector(){
        return videoProjector;
    }

    public void setVideoProjector(boolean videoProjector){
        this.videoProjector = videoProjector;
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
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    /**
     * returns all the data from the object
     */
    public String toString(){

        if( videoProjector )
            return getName() + "(cap=" + getCapacity() + " , " + getType() + ", has video projector)" ;
        else
            return getName() + "(cap=" + getCapacity() + " , " + getType() + ", no video projector)" ;
    }

    @Override
    /**
     * overrides the equal method from Object class
     * @return true if the two rooms have the same name, false if not
     */
    public boolean equals(Object obj) {

        if (obj == null) return false;
        if (!(obj instanceof Room)) return false;

        Room that = (Room) obj;
        return getName().equals(that.getName());
    }
}
