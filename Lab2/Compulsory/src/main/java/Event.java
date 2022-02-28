public class Event {

    private String name;
    private int numberOfParticipants;
    private int start;
    private int end;
    private Type type;

    public Event(String name, int numberOfParticipants, int start, int end, Type type) {
        this.name = name;
        this.numberOfParticipants = numberOfParticipants;
        this.start = start;
        this.end = end;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return getName() + "(type=" + getType() + ", size=" + getNumberOfParticipants() + ", start=" + getStart() + ", end=" + getEnd();
    }

}
