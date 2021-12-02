package methods.Exercise;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        int sumOfTheFirstTwo = sumOfTheFirstTwo(first, second);

        int finalSum = subtractThirdFromSum(sumOfTheFirstTwo, third);
        System.out.println(finalSum);
    }

    private static int sumOfTheFirstTwo(int first, int second) {
        int sum = first + second;
        return sum;
    }

    private static int subtractThirdFromSum(int third, int sum) {
        int finalSum = third - sum;
        return finalSum;
    }

}
