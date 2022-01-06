package textProcessing.Lab;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //EXAM PROBLEM

        StringBuilder key = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();
        while (!command.equals("Generate")) {
            String[] commandArray = command.split(">>>");
            String commandName = commandArray[0];

            switch (commandName) {
                case "Contains":
                    String wordToSearch = commandArray[1];
                    if (key.toString().contains(wordToSearch)) {
                        System.out.printf("%s contains %s\n", key, wordToSearch);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Slice":
                    int startIndex = Integer.parseInt(commandArray[1]);
                    int endIndex = Integer.parseInt(commandArray[2]);
                  //  key.replace(startIndex, endIndex, ""); или с делете
                    key.delete(startIndex, endIndex);
                    System.out.println(key);
                    break;
                case "Flip":
                    String flipCase = commandArray[1];
                    int flipStartIndex = Integer.parseInt(commandArray[2]);
                    int flipEndIndex = Integer.parseInt(commandArray[3]);
                    for (int i = flipStartIndex; i < flipEndIndex ; i++) {
                        char currentChar = key.charAt(i);
                        if (flipCase.equals("Upper")) {
                            key.setCharAt(i, Character.toUpperCase(currentChar));
                        } else {
                            key.setCharAt(i, Character.toLowerCase(currentChar));
                        }
                    }
                    System.out.println(key);
                    break;
            }


            command = scanner.nextLine();
        }

        System.out.printf("Your activation key is: %s", key);
    }
}
