package FirstStepsInCoding.Exercise;

import java.util.Scanner;

public class P06CharityCampaignKaloyan {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int cooks = Integer.parseInt(scanner.nextLine());
        int cakes = Integer.parseInt(scanner.nextLine());
        int waffles = Integer.parseInt(scanner.nextLine());
        int pancakes = Integer.parseInt(scanner.nextLine());


        double sumCakes = cakes * 45;
        double sumWaffles = waffles * 5.80;
        double sumPancakes = pancakes * 3.20;

        double sumPerDay = (sumCakes + sumWaffles + sumPancakes) * cooks;
        double sumCampaing = sumPerDay * days;
        double charitySum = sumCampaing - sumCampaing * 1 / 8;

        System.out.printf("%.2f", charitySum);
    }
}
