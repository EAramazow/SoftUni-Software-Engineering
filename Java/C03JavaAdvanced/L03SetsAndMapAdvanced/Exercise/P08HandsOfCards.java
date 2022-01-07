package SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class P08HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Set<String>> playersCardsMap = new LinkedHashMap<>();


        while (!input.equals("JOKER")) {
            String[] inputSplit = input.trim().split(": ");
            String name = inputSplit[0]; // player name
            String[] cardsSplit = inputSplit[1].split(", ");

            Set<String> cardsSet = new HashSet<>(); // taken cards

            Collections.addAll(cardsSet, cardsSplit);

            // if we already have the name

            if (playersCardsMap.containsKey(name)) {
                // we take the set with cards
                Set<String> currentCardsSet = playersCardsMap.get(name);
                // add new (currentCardSet) set to current set (cardsSet)
                currentCardsSet.addAll(cardsSet);
                playersCardsMap.put(name, currentCardsSet);
            } else {
                // if we don't have the name
                playersCardsMap.put(name, cardsSet);

            }
            input = scanner.nextLine();
        }

        playersCardsMap.entrySet().forEach(entry -> {
            String name = entry.getKey();
            Set<String> cards = entry.getValue();
            int points = getCardsPoints(cards);
            System.out.printf("%s: %d\n", name, points);
        });
    }

    private static int getCardsPoints(Set<String> cards) {
        Map<Character, Integer> pointsMap = getCardsValue();
        int sumCards = 0;

        for (String card : cards) {
            int points = 0;

            if (card.contains("10")) {
                char type = card.charAt(2);
                points = 10 * pointsMap.get(type);
            } else {
                char number = card.charAt(0);
                char type = card.charAt(1);
                points = pointsMap.get(number) * pointsMap.get(type);
            }
            sumCards += points;
        }
        return sumCards;
    }

    private static Map<Character, Integer> getCardsValue() {
        Map<Character, Integer> points = new HashMap<>();

        points.put('2', 2);
        points.put('3', 3);
        points.put('4', 4);
        points.put('5', 5);
        points.put('6', 6);
        points.put('7', 7);
        points.put('8', 8);
        points.put('9', 9);

        points.put('J', 11);
        points.put('Q', 12);
        points.put('K', 13);
        points.put('A', 14);

        points.put('S', 4);
        points.put('H', 3);
        points.put('D', 2);
        points.put('C', 1);

        return points;
    }
}
