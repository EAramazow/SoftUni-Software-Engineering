package ExampleComparableAndComparator;

import java.util.Comparator;

public class MovieRatingComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie firstMovie, Movie secondMovie) {
        return Integer.compare((int) firstMovie.getRating(), (int) secondMovie.getRating());
    }

}
