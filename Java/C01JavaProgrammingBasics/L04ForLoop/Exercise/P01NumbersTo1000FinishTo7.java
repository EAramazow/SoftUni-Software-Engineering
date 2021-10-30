package ForLoop.Exercise;

import java.util.Scanner;

public class P01NumbersTo1000FinishTo7 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Числата до 1000, които завършват на 7
        // Вариант 1 - работи 9 пъти по-бързо от второто

        // 1. for (int i = 7; i <= 997; i+=10)
        // 2. System.out.println(i);


        // Вариант 2

        for (int i = 7; i <= 997 ; i++) {
            if (i % 10 == 7) {
                System.out.println(i);
            
        }
    }
}
}
