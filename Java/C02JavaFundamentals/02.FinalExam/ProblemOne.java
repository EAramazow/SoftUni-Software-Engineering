package FinalExam140821;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProblemOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Judge 70/100

        String username = scanner.nextLine();
        String commands = scanner.nextLine();

        while (!commands.equals("Sign up")) {
            String[] commandSplit = commands.split(" ");
            String commandName = commandSplit[0];

            switch (commandName) {
                case "Case":
                    username = username.toLowerCase();
                    System.out.println(username);
                    break;

                case "Reverse":
                    int startIndex = Integer.parseInt(commandSplit[1]);
                    int endIndex = Integer.parseInt(commandSplit[2]);
                    int count = 0;

                    for (int i = endIndex; i >= startIndex ; i--) {
                        if (count == endIndex) {
                            break;
                        } else {
                            char currentSymbol = username.charAt(i);
                            System.out.print(currentSymbol);
                            count++;
                        }
                    }
                    System.out.println();
                    break;
                case "Cut":
                    String substringToCut = commandSplit[1];
                    if (username.contains(substringToCut)) {
                        username = username.replaceAll(substringToCut, "");
                        System.out.println(username);
                    } else {
                        System.out.printf("The word %s doesn't contain %s.\n", username, substringToCut);
                    }
                    break;

                case "Replace":
                    String find = commandSplit[1];

                    char currentChar = find.charAt(0);
                    char replace = '0';

                    for (int i = 0; i < find.length(); i++) {
                        replace = '*';
                    }

                    for (int i = 0; i < username.length(); i++) {
                        if (username.charAt(i) == currentChar) {
                            username = username.replace(currentChar, replace);
                        }
                    }
                    System.out.println(username);
                    break;

                case "Check":
                    String check = commandSplit[1];
                    if (username.contains(check)) {
                        System.out.println("Valid");
                    } else {
                        System.out.printf("Your username must contain %s.\n", check);
                    }
                    break;
            }

            commands = scanner.nextLine();
        }


    }

}
