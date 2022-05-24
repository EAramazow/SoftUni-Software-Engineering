package FirstStepsInCoding.Exercise;

import java.util.Scanner;

public class P03DepositCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double depositSum = Double.parseDouble(scanner.nextLine());

        int termMonths = Integer.parseInt(scanner.nextLine());

        double yearInterestRate = Double.parseDouble(scanner.nextLine());

        double sum = depositSum + termMonths * ((depositSum * yearInterestRate / 100) / 12);

        System.out.println(sum);



    }
}
