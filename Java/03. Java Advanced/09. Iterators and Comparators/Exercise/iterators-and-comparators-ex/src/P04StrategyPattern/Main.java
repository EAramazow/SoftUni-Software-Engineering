package P04StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Person> nameSet = new TreeSet<>(new NameComparator());
        TreeSet<Person> ageSet = new TreeSet<>(new AgeComparator());

        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {
            String line = scanner.nextLine();
            String[] peopleParam = line.split(" ");

            Person person = new Person(peopleParam[0], Integer.parseInt(peopleParam[1]));
            nameSet.add(person);
            ageSet.add(person);
        }

        for (Person person : nameSet) {
            System.out.println(person);
        }

        System.out.println("******************************");

        for (Person person : ageSet) {
            System.out.println(person);
        }
    }
}
