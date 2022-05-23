package SetsAndMapsAdvanced.Exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> phonebook = new LinkedHashMap<>();


        while (!input.equals("search")) {

            String[] inputSplit = input.trim().split("\\-");
            String name = inputSplit[0];
            String phoneNumber = inputSplit[1];

            if (!phonebook.containsKey(name)) {
                phonebook.put(name, phoneNumber);
            } else {
                phonebook.put(name, phoneNumber);
            }

            input = scanner.nextLine();

        }

        String name = scanner.nextLine();


        while (!name.equals("stop")) {
            if (phonebook.containsKey(name)) {
                System.out.printf("%s -> %s\n", name, phonebook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.\n", name);
            }


            name = scanner.nextLine();
        }

    }
}


