package midExam100721;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProblemTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> text = Arrays.stream(scanner.nextLine().split("[|]")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            String[] inputData = input.split(" ");
            String name = inputData[0];
            switch (name) {
                case "Remove":
                    int indexToRemove = Integer.parseInt(inputData[1]);
                    if (isValidIndex(indexToRemove, text.size())) {
                        text.remove(indexToRemove);
                    }
                    break;
                case "Add":
                    String elementToAdd = inputData[1];
                    int elementToAddIndex = Integer.parseInt(inputData[2]);
                    if (isValidIndex(elementToAddIndex, text.size())) {
                        text.add(elementToAddIndex, elementToAdd);
                    }
                    break;
                case "Check":
                    String checkType = inputData[1];
                    if (checkType.equals("Even")) {
                        for (int i = 0; i < text.size(); i++) {
                            if (i % 2 == 0) {
                                System.out.print(text.get(i) + " ");
                            }
                        }
                        System.out.println();
                    } else if (checkType.equals("Odd")) {
                        for (int i = 0; i < text.size(); i++) {
                            if (i % 2 != 0) {
                                System.out.print(text.get(i) + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;
            }


            input = scanner.nextLine();
        }

        System.out.print("You crafted ");
        System.out.print(text.toString().replace("[", "")
                .replace("]", "")
                .replace(",", "")
                .replace(" ", ""));
        System.out.print("!");

    }

    private static boolean isValidIndex(int index, int size) {
        return index >= 0 && index <= size - 1;
    }
}
