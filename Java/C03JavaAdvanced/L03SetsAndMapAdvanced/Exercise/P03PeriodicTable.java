package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> set = new TreeSet<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().trim().split("\\s+");
            for (String element : input) {
                set.add(element);
            }
        }

        set.forEach(e -> System.out.print(e + " "));

    }
}
