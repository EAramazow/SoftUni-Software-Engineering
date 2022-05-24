package lists.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }

            String[] tokens = input.split(" ");

            switch (tokens[0]) {
                case "Contains":
                    int contains = Integer.parseInt(tokens[1]);

                    if (numbers.contains(contains)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (tokens[1].equals("even")) {
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) % 2 == 0) {
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                    } else if (tokens[1].equals("odd")) {
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) % 2 != 0) {
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                    }
                    System.out.println();
                    break;
                case "Get":
                    int sum = 0;
                    if (tokens[1].equals("sum")) {
                        for (int i = 0; i < numbers.size(); i++) {
                            sum += numbers.get(i);
                        }
                    }
                    System.out.print(sum);
                    System.out.println();
                    break;
                case "Filter":
                    int currentNumber = Integer.parseInt(tokens[2]);
                    String valueOfNumbers = "";
                    if (tokens[1].equals(">=")) {
                        for (Integer printNumbers : numbers) {
                            if (printNumbers >= currentNumber) {
                                valueOfNumbers += String.valueOf(printNumbers) + " ";
                            }
                        }
                        System.out.println(valueOfNumbers);

                    } else if (tokens[1].equals("<")) {
                        for (Integer printNumbers : numbers) {
                            if (printNumbers < currentNumber) {
                                valueOfNumbers += String.valueOf(printNumbers) + " ";
                            }
                        }
                        System.out.println(valueOfNumbers);
                    } else if (tokens[1].equals("<=")) {
                        for (Integer printNumbers : numbers) {
                            if (printNumbers <= currentNumber) {
                                valueOfNumbers += String.valueOf(printNumbers) + " ";
                            }
                        }
                    } else if (tokens[1].equals(">")) {
                        for (Integer printNumbers : numbers) {
                            if (printNumbers > currentNumber) {
                                valueOfNumbers += String.valueOf(printNumbers) + " ";
                            }
                        }
                    }
                    break;
            }
        }
    }
}
