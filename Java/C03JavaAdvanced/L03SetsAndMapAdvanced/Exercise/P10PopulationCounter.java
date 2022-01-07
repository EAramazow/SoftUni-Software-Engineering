package SetsAndMapsAdvanced.Exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> populationMap = new LinkedHashMap<>();

        while (!input.equals("report")) {
            String[] splitInput = input.split("\\|");
            String city = splitInput[0];
            String country = splitInput[1];
            int population = Integer.parseInt(splitInput[2]);


            populationMap.putIfAbsent(country, new LinkedHashMap<>());
            populationMap.get(country).putIfAbsent(city, 0);
            populationMap.get(country).put(city, population);


            input = scanner.nextLine();

        }


        populationMap.entrySet().stream()
                .sorted((first, second) -> Integer.compare(second.getValue().values().stream().mapToInt(i -> i).sum()
                        , first.getValue().values().stream().mapToInt(i -> i).sum()))
                .forEach(e -> {
                    System.out.printf("%s (total population: %d)\n",
                            e.getKey(), e.getValue().values().stream().mapToInt(i -> i).sum());

                    e.getValue().entrySet().stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                            .forEach(entry -> System.out.printf("=>%s: %d\n", entry.getKey(), entry.getValue()));
                });

    }
}
