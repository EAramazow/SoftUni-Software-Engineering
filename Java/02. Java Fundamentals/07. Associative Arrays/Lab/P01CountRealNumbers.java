package associativeArrays.Lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P01CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> mapNumber = new TreeMap<>();

        for (double number : numbers) {
            if (!mapNumber.containsKey(number)) {
                mapNumber.put(number, 1);
            } else {
                int occurrences = mapNumber.get(number);
                occurrences++;
                mapNumber.put(number, occurrences);
            }

        }

        for (Map.Entry<Double, Integer> entry : mapNumber.entrySet()) {
            DecimalFormat decimalFormat = new DecimalFormat("#.########");
            System.out.printf("%s -> %d\n", decimalFormat.format(entry.getKey()), entry.getValue());
        }
    }
}
