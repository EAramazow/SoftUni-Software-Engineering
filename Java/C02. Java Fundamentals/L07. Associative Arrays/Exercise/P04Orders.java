package associativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Double> totalPriceMap = new LinkedHashMap<>();
        Map<String, Double> currentOrder = new LinkedHashMap<>();


        while (!input.equals("buy")) {
            String[] splitData = input.split(" ");
            String product = splitData[0];
            double price = Double.parseDouble(splitData[1]);
            double quantity = Integer.parseInt(splitData[2]);

            if (!totalPriceMap.containsKey(product)) {
                totalPriceMap.put(product, price * quantity);
                currentOrder.put(product, quantity);
            } else {
                currentOrder.put(product, currentOrder.get(product) + quantity);
                totalPriceMap.put(product, currentOrder.get(product) * price);
            }

            input = scanner.nextLine();
        }

        totalPriceMap.entrySet().stream().forEach(entry -> System.out.printf("%s -> %.2f\n", entry.getKey(), entry.getValue()));
    }
}
