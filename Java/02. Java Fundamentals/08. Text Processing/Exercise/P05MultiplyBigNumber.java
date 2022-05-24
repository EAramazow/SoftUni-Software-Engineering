package textProcessing.Exercise;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class P05MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstNumber = scanner.nextLine();
        String secondNumber = scanner.nextLine();

        BigDecimal first = new BigDecimal(firstNumber);
        BigDecimal second = new BigDecimal(secondNumber);

        BigDecimal multiply = first.multiply(second);
        System.out.println(multiply);
    }
}
