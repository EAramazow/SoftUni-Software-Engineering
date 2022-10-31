package ExampleComparableAndComparator;

public class Movie implements Comparable<Movie> {

    private String name;
    private double rating;

    public Movie(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public Movie setName(String name) {
        this.name = name;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public Movie setRating(double rating) {
        this.rating = rating;
        return this;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public int compareTo(Movie otherMovie) {

        // comparable by only one criterion
        // -1 -> when the object is smaller
        //  0 -> when the objects are equal
        //  1 -> when the object is bigger

        return this.getName().compareTo(otherMovie.getName());
    }
}
