package basicSyntaxConditionalStatementsLoops.Exercise;

import java.util.Scanner;

public class P09PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double allMoney = Double.parseDouble(scanner.nextLine());
        int countStudents = Integer.parseInt(scanner.nextLine());
        double priceLightSabers = Double.parseDouble(scanner.nextLine());
        double priceRobes = Double.parseDouble(scanner.nextLine());
        double priceBelts = Double.parseDouble(scanner.nextLine());

        double allLightSabers = Math.ceil(countStudents + 0.10 * countStudents) * priceLightSabers;
        double allRobes = countStudents * priceRobes;
        double allBelts = (countStudents - countStudents / 6) * priceBelts;


        double allSum = allLightSabers + allRobes + allBelts;

        if (allMoney >= allSum) {
            System.out.printf("The money is enough - it would cost %.2flv.", allSum);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", allSum - allMoney);
        }
    }
}
