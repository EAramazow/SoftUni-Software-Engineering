package lists.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        List<String> namesList = new ArrayList<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String commands = scanner.nextLine();
            String[] commandsData = commands.split("\\s+");
            String names = commandsData[0];


            if (commandsData[1].equals("is") && commandsData[2].equals("going!")) {
                if (namesList.contains(names)) {
                    System.out.printf("%s is already in the list!\n", names);
                } else {
                    namesList.add(names);
                }

            } else if (commandsData[1].equals("is") && commandsData[2].equals("not")) {
                if (namesList.contains(names)) {
                    namesList.remove(names);
                } else {
                    System.out.printf("%s is not in the list!\n", names);

                }

            }
        }

        for (String names : namesList) {
            System.out.println(names);
        }

    }
}


