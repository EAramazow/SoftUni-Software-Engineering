package SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int firstNum = Integer.parseInt(input.trim().split("\\s+")[0]);
        int secondNum = Integer.parseInt(input.trim().split("\\s+")[1]);


        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();




        while (firstNum-- > 0) {
            int numbers = Integer.parseInt(scanner.nextLine());
            firstSet.add(numbers);
        }

        while (secondNum-- > 0) {
            int numbers = Integer.parseInt(scanner.nextLine());
            secondSet.add(numbers);
        }

//        Set<Integer> duplicatedNumbers = new LinkedHashSet<>();
//
//        for (Integer num : firstSet) {
//            if (secondSet.contains(num)) {
//                duplicatedNumbers.add(num);
//            }
//        }
//
//        duplicatedNumbers.forEach(e -> System.out.print(e + " "));

//        for (Integer integer : secondSet) {
//            if (firstSet.contains(integer)) {
//                System.out.print(integer + " ");
//            }


        firstSet.retainAll(secondSet);

        firstSet.forEach(e -> System.out.print(e + " "));

//            firstSet.forEach(element -> {
//                if (secondSet.contains(element)) {
//                    System.out.print(element + " ");
//                }
//            });

    }
}

