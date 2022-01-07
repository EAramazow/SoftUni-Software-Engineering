package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> usernames = new LinkedHashSet<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String commands = scanner.nextLine();
            usernames.add(commands);
        }

        usernames.forEach(username -> System.out.printf("%s\n", username));
    }
}
