package P02GenericSwapMethodStrings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Swap<String> swap = new Swap<>();

        for (int i = 0; i < n; i++) {
            String value = scanner.nextLine();
            swap.add(value);
        }

        String[] indexes = scanner.nextLine().split(" ");
        int firstIndex = Integer.parseInt(indexes[0]);
        int secondIndex = Integer.parseInt(indexes[1]);
        swap.swap(firstIndex, secondIndex);

        System.out.println(swap);
    }
}
