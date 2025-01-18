import java.util.Comparator;

public class Attendance {
    private Event event;
    private int attendants;

    public Attendance (Event event, int attendants) {
        this.event = event;
        this.attendants = attendants;
    }

    public Event getEvent() {
        return event;
    }

    public int getAttendants() {
        return attendants;
    }

    @Override
    public String toString() {
        return event.getId() + "," + event.getTitle() + "," + attendants + ","
                + event.getDate() + "," + event.getLocation();
    }
}
