package associativeArrays.Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P03LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Integer> specialItems = new TreeMap<>();
        Map<String, Integer> junkItems = new TreeMap<>();

        specialItems.put("shards", 0);
        specialItems.put("motes", 0);
        specialItems.put("fragments", 0);

        boolean isObtained = false;

        while (!isObtained) {
           int quantity = Integer.parseInt(scanner.next());
            String material = scanner.next().toLowerCase();


            switch (material) {
                case "shards":
                    if (!specialItems.containsKey(material)) {
                        specialItems.put(material, quantity);
                    } else {
                        int currentQuantity = specialItems.get(material);
                        specialItems.put(material, quantity + currentQuantity);
                    }

                    if (specialItems.get(material) >= 250) {
                        System.out.println("Shadowmourne obtained!");
                        specialItems.put(material, specialItems.get(material) - 250);
                        isObtained = true;
                    }
                break;
                case "fragments":
                    if (!specialItems.containsKey(material)) {
                    specialItems.put(material, quantity);
                    } else {
                        int currentQuantity = specialItems.get(material);
                        specialItems.put(material, quantity + currentQuantity);
                    }
                    if (specialItems.get(material) >= 250) {
                        System.out.println("Valanyr obtained!");
                        specialItems.put(material, specialItems.get(material) - 250);
                        isObtained = true;
                    }
                    break;
                case "motes":
                    if (!specialItems.containsKey(material)) {
                        specialItems.put(material, quantity);
                    } else {
                        int currentQuantity = specialItems.get(material);
                        specialItems.put(material, quantity + currentQuantity);
                    }
                    if (specialItems.get(material) >= 250) {
                        System.out.println("Dragonwrath obtained!");
                        specialItems.put(material, specialItems.get(material) - 250);
                        isObtained = true;
                    }
                    break;
                default:
                    if (!junkItems.containsKey(material)) {
                        junkItems.put(material, quantity);
                    } else {
                        int currentQuantity = junkItems.get(material);
                        junkItems.put(material, quantity + currentQuantity);
                    }
            }

       }

       specialItems.entrySet()
               .stream()
               .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
               .forEach(material ->
                       System.out.printf("%s: %d\n", material.getKey(), material.getValue()));

       junkItems.entrySet()
               .stream()
               .sorted(Map.Entry.<String, Integer>comparingByKey())
               .forEach(material -> System.out.printf("%s: %d\n", material.getKey(), material.getValue()));
    }
}
