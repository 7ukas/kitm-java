import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Inception", 9.0, 148));
        movies.add(new Movie("Titanic", 8.5, 195));
        movies.add(new Movie("Avatar", 7.9, 162));
        movies.add(new Movie("The Dark Knight", 9.1, 152));

        System.out.println(movies.toString().replaceAll(",","\n"));

        /* Sorting by rating/duration */
        Collections.sort(movies, Collections.reverseOrder());
        System.out.println(movies.toString().replaceAll(",","\n"));

        Collections.sort(movies, (m1, m2) -> m2.getDuration() - m1.getDuration());
        System.out.println(movies.toString().replaceAll(",","\n"));

        /* Filter by rating (>=8) */
        List<Movie> filteredMovies = movies.stream().filter(m -> m.getRating() >= 8.0).collect(Collectors.toList());
        filteredMovies.forEach(m -> System.out.println(m));

        /* Convert to names only */
        List<String> movieTitles = movies.stream().map(m -> m.getTitle()).collect(Collectors.toList());
        movieTitles.forEach(title -> System.out.println(title));
    }
}
