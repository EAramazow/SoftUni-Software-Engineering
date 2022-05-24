package associativeArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P04WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        Arrays.stream(input)
                .filter(word -> word.length() % 2 == 0)
                .forEach(word -> System.out.println(word));

    }
}
