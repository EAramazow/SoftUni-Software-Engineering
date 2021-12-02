package lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commands = input.split(" ");
            String commandsData = commands[0];

            switch (commandsData) {
                case "Delete":
                    int numberToDelete = Integer.parseInt(commands[1]);
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numberToDelete == numbers.get(i)) {
                            numbers.remove(i);
                            i--;
                        }
                    }
                    break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(commands[1]);
                    int indexToInsert = Integer.parseInt(commands[2]);
                    numbers.add(indexToInsert, numberToInsert);
                    break;
            }


            input = scanner.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");

        }
    }
}
