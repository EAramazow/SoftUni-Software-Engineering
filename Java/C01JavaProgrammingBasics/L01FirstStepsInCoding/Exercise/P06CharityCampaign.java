package FirstStepsInCoding.Exercise;

import java.util.Scanner;

public class P06CharityCampaign {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int daysOfCampaign = Integer.parseInt(scanner.nextLine());
        int numberOfCookers = Integer.parseInt(scanner.nextLine());
        int numberOfCakes = Integer.parseInt(scanner.nextLine());
        int numberOfWaffles = Integer.parseInt(scanner.nextLine());
        int numberOfPancakes = Integer.parseInt(scanner.nextLine());

        double soldCakes = 14 * 45;
        double soldWaffles = 30 * 5.80;
        double soldPancakes = 16 * 3.20;

        double allSumPerDay = (soldCakes + soldWaffles + soldPancakes) * 8;
        double allSumCampaing = allSumPerDay * 23;
        double charitySum = allSumCampaing - allSumCampaing * 1 / 8;


        System.out.printf("%.2f", charitySum);



    }
}
