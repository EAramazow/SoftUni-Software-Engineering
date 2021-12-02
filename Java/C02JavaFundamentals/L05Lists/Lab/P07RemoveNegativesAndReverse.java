package lists.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class P07RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        // remove negative numbers

        numbers = removeNegativeNumbers(numbers);
        // print in reversed

            if (numbers.isEmpty()) {
                System.out.println("empty");
            } else {
                Collections.reverse(numbers);
                System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
            }
        }

    private static List<Integer> removeNegativeNumbers(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int element = list.get(i);
            if (element > 0) {
                list.remove(i);
                i--;
            }
        }

        return list;
    }
}
