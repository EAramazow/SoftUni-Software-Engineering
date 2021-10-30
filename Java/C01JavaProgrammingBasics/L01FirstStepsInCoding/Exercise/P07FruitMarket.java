package FirstStepsInCoding.Exercise;

import java.util.Scanner;

public class P07FruitMarket {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //1.	Цена на ягодите в лева – реално число в интервала [0.00 … 10000.00]
        //2.	Количеството бананите в килограми – реално число в интервала [0.00 … 10000.00]
        //3.	Количеството портокалите в килограми – реално число в интервала [0.00 … 10000.00]
        //4.	Количеството малините в килограми – реално число в интервала [0.00 … 10000.00]
        //5.	Количеството ягодите в килограми – реално число в интервала [0.00 … 10000.00]

        Double StrawPrice = Double.parseDouble(scan.nextLine());
        Double BananasQuantity = Double.parseDouble(scan.nextLine());
        Double OrangesQuantity = Double.parseDouble(scan.nextLine());
        Double RaspQuantity = Double.parseDouble(scan.nextLine());
        Double StrawQuantity = Double.parseDouble(scan.nextLine());

        //•	цената на малините е с 50% по-ниска от тази на ягодите;
        //•	цената на портокалите е с 40% по-ниска от цената на малините;
        //•	цената на бананите е с 80% по-ниска от цената на малините.

        Double RaspPrice = StrawPrice * 0.5;
        Double OrangePrice = RaspPrice * 0.6;
        Double BananaPrice = RaspPrice * 0.2;

        Double Straws = StrawPrice * StrawQuantity;
        Double Rasps = RaspPrice * RaspQuantity;
        Double Bananas = BananaPrice * BananasQuantity;
        Double Oranges = OrangePrice * OrangesQuantity;
        Double sumAll = Straws + Rasps + Bananas + Oranges;


        System.out.printf("%.2f", sumAll);
    }

}
