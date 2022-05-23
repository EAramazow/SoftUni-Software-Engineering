package associativeArrays.Lab;

import java.util.*;

public class P02WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> synonymsMap = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            if (!synonymsMap.containsKey(word)) {
                List<String> currentSynonym = new ArrayList<>();
                currentSynonym.add(synonym);
                synonymsMap.put(word, currentSynonym);
            } else {
                List<String> currentSynonym = synonymsMap.get(word);
                currentSynonym.add(synonym);
                synonymsMap.put(word, currentSynonym);
            }
        }

        for (Map.Entry<String, List<String>> entry : synonymsMap.entrySet()) {
            String currentWord = entry.getKey();
            List<String> currentSynonym = entry.getValue();
            System.out.printf("%s - %s\n", currentWord, String.join(", ", currentSynonym));
        }


    }
}
