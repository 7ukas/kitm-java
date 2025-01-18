import java.time.LocalDate;

public class Event {
    private int id;
    private String title;
    private LocalDate date;
    private String location;

    public Event(int id, String title, LocalDate date, String location) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }
}
