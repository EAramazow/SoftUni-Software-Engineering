
package L01WorkingWithAbstraction.Exercise.P06GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long capacity = Long.parseLong(scanner.nextLine());
        String[] safeContent = scanner.nextLine().split("\\s+");


        //Bag bag = new Bag(capacity);
        Map<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap<>();

        long gold = 0;
        long gem = 0;
        long cash = 0;


        for (int i = 0; i < safeContent.length; i += 2) {
            String item = safeContent[i];
            long quantity = Long.parseLong(safeContent[i + 1]);

            String typeOfTreasure = "";

            if (item.length() == 3) {
                typeOfTreasure = "Cash";
            } else if (item.toLowerCase().endsWith("gem")) {
                typeOfTreasure = "Gem";
            } else if (item.toLowerCase().equals("gold")) {
                typeOfTreasure = "Gold";
            }

            if (typeOfTreasure.equals("")) {
                continue;
            } else if (capacity < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + quantity) {
                continue;
            }

            switch (typeOfTreasure) {
                case "Gem":
                    if (!bag.containsKey(typeOfTreasure)) {
                        if (bag.containsKey("Gold")) {
                            if (quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(typeOfTreasure).values().stream().mapToLong(e -> e).sum() + quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(typeOfTreasure)) {
                        if (bag.containsKey("Gem")) {
                            if (quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(typeOfTreasure).values().stream().mapToLong(e -> e).sum() + quantity > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(typeOfTreasure)) {
                bag.put((typeOfTreasure), new LinkedHashMap<String, Long>());
            }

            if (!bag.get(typeOfTreasure).containsKey(item)) {
                bag.get(typeOfTreasure).put(item, 0L);
            }

            bag.get(typeOfTreasure).put(item, bag.get(typeOfTreasure).get(item) + quantity);

            if (typeOfTreasure.equals("Gold")) {
                gold += quantity;
            } else if (typeOfTreasure.equals("Gem")) {
                gem += quantity;
            } else if (typeOfTreasure.equals("Cash")) {
                cash += quantity;
            }
        }

        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}