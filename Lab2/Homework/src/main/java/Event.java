public class Event {

    private String name;
    private int numberOfParticipants;
    private int start;
    private int end;

    public Event(String name, int numberOfParticipants, int start, int end ) {
        this.name = name;
        this.numberOfParticipants = numberOfParticipants;
        this.start = start;
        this.end = end;
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

    @Override
    public String toString() {
        return getName() + "(size=" + getNumberOfParticipants() + ", start=" + getStart() + ", end=" + getEnd() + ")";
    }

}