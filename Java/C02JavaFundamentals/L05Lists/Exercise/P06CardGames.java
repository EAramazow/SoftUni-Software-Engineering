package lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class P06CardGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerHand = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondPlayerHand = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());


        while (firstPlayerHand.size() > 0 && secondPlayerHand.size() > 0) {

            int firstPlayerCard = firstPlayerHand.remove(0);
            int secondPlayerCard = secondPlayerHand.remove(0);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerHand.add(firstPlayerCard);
                firstPlayerHand.add(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerHand.add(secondPlayerCard);
                secondPlayerHand.add(firstPlayerCard);
            }
        }

        if (firstPlayerHand.size() > 0) {
            printSum(firstPlayerHand, "First");
        } else if (secondPlayerHand.size() > 0) {
            printSum(secondPlayerHand, "Second");
        }

    }

    private static void printSum(List<Integer> elements, String player) {
        int sum = 0;
        for (Integer numbers : elements) {
            sum += numbers;
        }
        System.out.println(player + " player wins! Sum: " + sum);
    }

}
