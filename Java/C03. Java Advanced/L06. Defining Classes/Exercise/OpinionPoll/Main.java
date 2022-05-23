package DefiningClasses.Exercise.OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPersons = Integer.parseInt(scanner.nextLine());

        List<Person> peoples = new ArrayList<>();

        for (int i = 0; i < numberOfPersons; i++) {
            String[] input = scanner.nextLine().trim().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person person = new Person(name, age);

            peoples.add(person);
        }

        peoples.stream()
                .filter(person -> person.getAge() > 30)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(System.out::println);

    }
}
