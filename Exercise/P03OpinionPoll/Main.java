package objectsAndClasses.Exercise.P03OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String personalData = scanner.nextLine();
            String[] splitData = personalData.split("\\s+");
            String name = splitData[0];
            int age = Integer.parseInt(splitData[1]);

            Person person = new Person(name, age);
            if (person.getAge() > 30) {
                people.add(person);
            }
        }

       // филтрация за оставяне на хората в списъка, които са над 30г : people.stream().filter(person -> person.getAge() > 30).collect(Collectors.toList());

        people.sort(Comparator.comparing(Person::getName));   // comparator помага за сравняване на обекти от съответни класове

        for (Person person : people) {
            System.out.println(person.getName() + " - " + person.getAge());

        }

    }
}
