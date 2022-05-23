package lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")) // сплитва по един или повече интервала
                .map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] inputData = input.split("\\s+"); // сплитва по един или повече интервала
            String inputName = inputData[0];
            switch (inputName) {
                case "Add":
                int numberToAdd = Integer.parseInt(inputData[1]);
                numbers.add(numberToAdd);
                    break;
                case "Insert":
                int numberToInsert = Integer.parseInt(inputData[1]);
                    int insertIndex = Integer.parseInt(inputData[2]);
                    if (isValidIndex(insertIndex, numbers.size())) {
                        numbers.add(insertIndex, numberToInsert);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(inputData[1]);
                    if (isValidIndex(indexToRemove, numbers.size())) {
                        numbers.remove(indexToRemove);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case"Shift":
                    String shiftType = inputData[1];
                    int count = Integer.parseInt(inputData[2]);
                    if (shiftType.equals("left")) {
                        shiftLeft(numbers, count);

                    } else if (shiftType.equals("right")) {
                        shiftRight(numbers, count);

                    }
                    break;
            }

            input = scanner.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }

    private static void shiftRight(List<Integer> numbers, int count) {
        for (int i = 0; i < count; i++) {
            int lastNumber = numbers.get(numbers.size() - 1);
            numbers.add(0, lastNumber);
            numbers.remove(numbers.size() - 1);
        }

    }

    private static void shiftLeft(List<Integer> numbers, int count) {
        for (int i = 0; i <count ; i++) {
            int firstNumber = numbers.get(0);
            numbers.add(firstNumber);
            numbers.remove(0);
        }
    }

    public static boolean isValidIndex(int index, int size) {
        return index >= 0 && index <= size - 1;
    }
}
