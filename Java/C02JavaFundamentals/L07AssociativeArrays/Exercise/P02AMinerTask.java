package associativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resourceInput = scanner.nextLine();
        Map<String, Integer> resourceMap = new LinkedHashMap<>();

        while (!resourceInput.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resourceMap.containsKey(resourceInput)) {
                resourceMap.put(resourceInput, quantity);
            } else {
                int currentQuantity = resourceMap.get(resourceInput);
                resourceMap.put(resourceInput, currentQuantity + quantity);
            }

            resourceInput = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : resourceMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
