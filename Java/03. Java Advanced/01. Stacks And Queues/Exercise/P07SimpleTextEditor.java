package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> wordsStack = new ArrayDeque<>();
        StringBuilder textBuilder = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            String command = scanner.nextLine();
            String commandNumber = command.split("\\s+")[0];

            switch (commandNumber) {
                case "1":
                    String textToAdd = command.split("\\s+")[1];
                    textBuilder.append(textToAdd);
                    wordsStack.push(textBuilder.toString());
                    break;

                case "2":
                    int elements = Integer.parseInt(command.split("\\s+")[1]);
                    int startIndex = textBuilder.length() - elements;
                    textBuilder.delete(startIndex, startIndex + elements);
                    wordsStack.push(textBuilder.toString());
                    break;

                case "3":
                    int index = Integer.parseInt(command.split("\\s+")[1]);
                    System.out.println(textBuilder.charAt(index - 1));
                    break;
                case "4":
                    if (wordsStack.size() > 1) {
                        wordsStack.pop();
                        textBuilder = new StringBuilder(wordsStack.peek());
                    } else {
                        textBuilder = new StringBuilder();
                    }
                    break;
            }

        }

    }
}
