package FunctionalProgramming.Lab;

import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Supplier takes no parameters :


        Supplier<Integer> genRandomInt = () -> new Random().nextInt(51);

        int random = genRandomInt.get();
        System.out.println(random);
    }
}
