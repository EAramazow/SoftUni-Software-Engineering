package associativeArrays.Exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. red text
        //2.pass through all elements

        String text = scanner.nextLine();

        Map<Character, Integer> charCount = new LinkedHashMap<>();

        for (int index = 0; index <= text.length() - 1; index++) {
            char currentSymbol = text.charAt(index);
            if (currentSymbol == ' ') {
                continue; // continue to next iteration
            }

            // проверката е много важна при презаписването на МАПОВЕ

            if (!charCount.containsKey(currentSymbol)) {
                charCount.put(currentSymbol, 1);
            } else {
                int currentCount = charCount.get(currentSymbol);   // връща стойността, която стои срещу този ключ
                charCount.put(currentSymbol, currentCount + 1);
            }

        }

        //charCount.keySet() -> връща всички ключове (key)
        //charCount.values() -> връща всичко стойности (value)
        //charCount.entrySet() -> връща всички записи (key, value)

        // принтиране чрез 1. forEach
        //                 2. със stream()

        //1. forEach

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

        //2. stream

        charCount.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
