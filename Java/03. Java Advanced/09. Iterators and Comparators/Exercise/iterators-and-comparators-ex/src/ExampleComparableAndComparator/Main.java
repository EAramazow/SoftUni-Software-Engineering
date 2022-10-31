package ExampleComparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Movie> movies = new ArrayList<>();

        Movie movieFirst = new Movie("Harry Potter", 9);
        Movie movieSecond = new Movie("Silicon Valley", 9.4);
        Movie movieThird = new Movie("Astronaut", 8.7);

        movies.add(movieFirst);
        movies.add(movieSecond);
        movies.add(movieThird);

        Collections.sort(movies, new MovieRatingComparator());
        Collections.sort(movies, new MovieNameComparator());

        movies.forEach(System.out::println);
        // accept methods which are comparable -> comparable criterion
        // comparable -> compareTo/сравним -> inside the class
        // comparator -> сравнител -> in different class
    }
}
