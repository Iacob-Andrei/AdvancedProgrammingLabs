public class Event {

    private String name;
    private int numberOfParticipants;
    private int start;
    private int end;

    /**
     * initializes the variables
     * @param name - the name of the event
     * @param numberOfParticipants - the number of participants to the event
     * @param start - starting time of the event
     * @param end - end time of the event
     */
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
    /**
     * returns all the data from the object
     */
    public String toString() {
        return getName() + "(size=" + getNumberOfParticipants() + ", start=" + getStart() + ", end=" + getEnd() + ")";
    }

    @Override
    /**
     * overrides the equal method from Object class
     * @return true if the two events have the same name, false if not
     */
    public boolean equals(Object obj) {

        if (obj == null) return false;
            if (!(obj instanceof Event)) return false;

        Event that = (Event) obj;
        return getName().equals(that.getName());
    }
}