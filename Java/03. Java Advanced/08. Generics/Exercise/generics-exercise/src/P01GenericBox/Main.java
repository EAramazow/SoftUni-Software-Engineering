package P01GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // 1. String
        Box<String> box = new Box();

        for (int i = 0; i < n; i++) {
            String value = scanner.nextLine();
            box.add(value);
        }

        System.out.println(box);


        // 2. Integer
        Box<Integer> boxInt = new Box<>();

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(scanner.nextLine());
            boxInt.add(value);
        }

        System.out.println(box);
    }
}