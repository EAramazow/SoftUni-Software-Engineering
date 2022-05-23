package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> mine = new LinkedHashMap<>();

        String resource = scanner.nextLine();


        while (!resource.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!mine.containsKey(resource)) {
                mine.put(resource, quantity);
            } else {
                int currentQuantity = mine.get(resource);
                mine.put(resource, quantity + currentQuantity);
            }

            resource = scanner.nextLine();
        }

        // mine.entrySet().forEach(element -> System.out.printf("%s -> %d\n", element.getKey(), element.getValue()));

        mine.forEach((key, value) -> System.out.printf("%s -> %d\n", key, value));
    }
}
