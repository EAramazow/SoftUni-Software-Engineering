package objectsAndClasses.Exercise.P01AdvertisementMessage;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.",
                "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int phrasesNum = random.nextInt(phrases.length);
            int eventsNum = random.nextInt(events.length);
            int authorsNum = random.nextInt(authors.length);
            int citiesNum = random.nextInt(cities.length);

            System.out.println(String.join(" ", phrases[phrasesNum] + " " + events[eventsNum] + " " +
                    authors[authorsNum] + " - " + cities[citiesNum]));
        }


    }
}
