package FunctionalProgramming.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class P04AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine().trim().split(", "))
                .mapToDouble(Double::parseDouble).toArray();

        List<Double> values = new ArrayList<>();

        Arrays.stream(input).forEach(values::add);

        UnaryOperator<Double> addVAT = value -> value * 1.20;

        System.out.println("Prices with VAT:");
        values.forEach(v -> System.out.printf("%.2f%n", addVAT.apply(v)));
    }
}
