package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counts = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> map = new LinkedHashMap<>();

        while (counts-- > 0) {
            String[] continentsAndCountries = scanner.nextLine().trim().split("\\s+");
            String continent = continentsAndCountries[0];
            String country = continentsAndCountries[1];
            String city = continentsAndCountries[2];


            // add continent if don't exist
            Map<String, List<String>> addedContinents = map.putIfAbsent(continent, new LinkedHashMap<>());
            Map<String, List<String>> addCountries = map.get(continent);

            // add countries if don't exist
            addCountries.putIfAbsent(country, new ArrayList<>());

            // add cities
            List<String> cities = addCountries.get(country);
            cities.add(city);

        }

        map.forEach((key, value) -> {
            System.out.printf("%s:\n", key);
            value.forEach((k, v) -> {
                System.out.printf("%s -> ", k);
                System.out.println(String.join(", ", v));
            });
        });


//        for (String c : map.keySet()) {
//            System.out.printf("%s:\n", c);
//            for (Map.Entry<String, List<String>> entry : map.get(c).entrySet()) {
//                System.out.printf("  %s -> %s \n", entry.getKey(), String.join(", ", entry.getValue()));
//            }
//        }
    }
}
