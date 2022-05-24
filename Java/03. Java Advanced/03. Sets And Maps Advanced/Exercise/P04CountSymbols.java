package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> map = new TreeMap<>();

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);


            if (!map.containsKey(currentChar)) {
                map.put(currentChar, 1);
            } else {
                int currentCount = map.get(currentChar);
                map.put(currentChar, currentCount + 1);
            }

        }

        map.forEach((key, value) -> {
            System.out.printf("%s: %d time/s\n", key, value);
        });
    }
}