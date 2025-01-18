public class Movie implements Comparable<Movie> {
    private String title;
    private double rating;
    private int duration;

    public Movie (String title, double rating, int duration) {
        this.title = title;
        this.rating = rating;
        this.duration = duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public int compareTo(Movie other) {
        if (this.rating > other.rating) return 1;
        if (this.rating < other.rating) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "Title: " + title + " | Rating: " + rating + " | Duration: " + duration + "m";
    }
}
