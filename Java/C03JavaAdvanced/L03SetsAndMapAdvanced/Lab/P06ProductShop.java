package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Double>> shops = new TreeMap<>();

        while (!input.equals("Revision")) {
            String shop = input.trim().split(", ")[0];
            String product = input.trim().split(", ")[1];
            double price = Double.parseDouble(input.trim().split(", ")[2]);


            shops.putIfAbsent(shop, new LinkedHashMap<>());
            Map<String, Double> productWithPrices = shops.get(shop);
            productWithPrices.put(product, price);


            input = scanner.nextLine();
        }

        for (String shop : shops.keySet()) {
            System.out.println(shop + "->");
            for (Map.Entry<String, Double> entry : shops.get(shop).entrySet()) {
                System.out.printf("Product: %s, Price: %.1f\n", entry.getKey(), entry.getValue());
            }
        }


    }
}
