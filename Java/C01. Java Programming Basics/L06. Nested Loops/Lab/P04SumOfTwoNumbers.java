package NestedLoops.Lab;

import java.util.Scanner;

public class P04SumOfTwoNumbers {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int start = Integer.parseInt(scanner.nextLine());
            int end = Integer.parseInt(scanner.nextLine());
            int magicNum = Integer.parseInt(scanner.nextLine());

            int count = 0;
            boolean flag = false;

            for (int i = start; i <= end; i++) { // въртене цикъл от числото старт до енд
                for (int j = start; j < end; j++) { // въртене на целия цикъл веднъж при първа итерация на първия цикъл
                    count++;
                    if (i + j == magicNum) {
                        System.out.printf("Combination N:%d (%d + %d = %d)\n", count, i, j, i + j);
                        flag = true;
                        break;
                    }

                }
                if (flag) {
                    break;
                }
            }

            if (!flag) {
                System.out.printf("%d combinations - neither equals %d\n", count, magicNum);
            }
        }
    }

