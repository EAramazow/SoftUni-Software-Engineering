package ExampleComparableAndComparator;

import java.util.Comparator;

public class MovieNameComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie firstMovie, Movie secondMovie) {
        return firstMovie.getName().compareTo(secondMovie.getName());
    }

}
