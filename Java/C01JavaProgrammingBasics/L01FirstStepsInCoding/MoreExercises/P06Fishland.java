package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class P06Fishland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceMackerel = Double.parseDouble(scanner.nextLine());
        double priceSprat = Double.parseDouble(scanner.nextLine());

        double kgBonito = Double.parseDouble(scanner.nextLine());
        double kgScad = Double.parseDouble(scanner.nextLine());
        int kgMussel = Integer.parseInt(scanner.nextLine());


        double priceBonito = priceMackerel + priceMackerel * 0.6;
        double sumBonito = kgBonito * priceBonito;


        double priceScad = priceSprat + priceSprat * 0.8;
        double sumScad = kgScad * priceScad;


        double priceMussel = 7.50;
        double sumMussel = kgMussel * priceMussel;

        double allSum = sumBonito + sumScad + sumMussel;



        System.out.printf("%.2f", allSum);


    }
}
