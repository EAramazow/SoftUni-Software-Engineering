package WhileLoop.MoreExercises;

import java.util.Scanner;

public class Number1To100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        for (int i = 2; i <100 ; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }

        }
    }
}
