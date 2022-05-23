package SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numArr = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> numbers = new LinkedHashMap<>();

        for (Double num : numArr) {
            if (!numbers.containsKey(num)) {
                numbers.put(num, 1);
            } else {
                numbers.put(num, numbers.get(num) + 1);
            }
        }

        for (Double number : numbers.keySet()) {
            System.out.printf("%.1f -> %d\n", number, numbers.get(number));
        }


    }
}
