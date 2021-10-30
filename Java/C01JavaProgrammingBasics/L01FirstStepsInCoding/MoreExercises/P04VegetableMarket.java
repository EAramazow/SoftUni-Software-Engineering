package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class P04VegetableMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceVegetable = Double.parseDouble(scanner.nextLine());
        double priceFruits = Double.parseDouble(scanner.nextLine());
        int totalKGVegetable = Integer.parseInt(scanner.nextLine());
        int totalKGFruits = Integer.parseInt(scanner.nextLine());

        double totalVegetable = priceVegetable * totalKGVegetable;
        double totalFruits = priceFruits * totalKGFruits;
        double total = (totalVegetable + totalFruits) / 1.94;

        System.out.printf("%.2f", total);

    }
}
