package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P07FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String namesAndEmails = scanner.nextLine();

        Map<String, String> emails = new LinkedHashMap<>();

        while (!namesAndEmails.equals("stop")) {

            String currentMail = scanner.nextLine();

            if (currentMail.endsWith("us") ||
                    currentMail.endsWith("uk") ||
                    currentMail.endsWith("com")) {
            } else {
                emails.putIfAbsent(namesAndEmails, currentMail);
            }

            namesAndEmails = scanner.nextLine();
        }

        emails.forEach((key, value) -> System.out.printf("%s -> %s\n", key, value));
    }
}
