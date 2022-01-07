package FunctionalProgramming.Lab;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P05FilterByAge {

    public static class Person {
        private final String name;
        private final int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        List<Person> peoples = IntStream.range(0, n)
                .mapToObj(ignored -> {
                    String[] split = scanner.nextLine().split(", ");
                    return new Person(split[0], Integer.parseInt(split[1]));
                }).collect(Collectors.toList());


        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String[] format = scanner.nextLine().split(" ");

        var filter = getFilter(condition, age);
        var printer = getPrinter(format);

        peoples
                .stream()
                .filter(filter)
                .forEach(printer);

    }

    private static Consumer<Person> getPrinter(String[] format) {
        if (format.length == 2) {
            return p -> System.out.println(p.name + " - " + p.age);
        } else if (format[0].equals("name")) {
            return p -> System.out.println(p.name);
        }
        return p -> System.out.println(p.age);
    }

    public static Predicate<Person> getFilter(String condition, int age) {
        if (condition.equals("older")) {
            return p -> p.age >= age;
        }
        return p -> p.age <= age;
    }
}
