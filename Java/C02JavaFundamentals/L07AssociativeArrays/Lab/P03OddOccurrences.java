package associativeArrays.Lab;

import java.util.*;

public class P03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        Map<String, Integer> wordsCount = new LinkedHashMap<>();

        for (String word : words) {
            String wordToLowerCase = word.toLowerCase();
            if (wordsCount.containsKey(wordToLowerCase)) {
                wordsCount.put(wordToLowerCase, wordsCount.get(wordToLowerCase) + 1);
            } else {
                wordsCount.put(wordToLowerCase, 1);
            }
        }

        List<String> odds = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                odds.add(entry.getKey());
            }
        }

        for (int i = 0; i < odds.size(); i++) {
            System.out.print(odds.get(i));
            if (i < odds.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
