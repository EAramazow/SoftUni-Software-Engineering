package lists.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> number = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int halfSize = number.size() / 2;
        for (int i = 0; i < halfSize; i++) {
                int sum = number.get(i) + number.get(number.size() - 1);
                number.set(i, sum);
                number.remove(number.size() - 1) ;

        }

        for (Integer numbers : number) {
            System.out.print(numbers + " ");
        }
    }
}
