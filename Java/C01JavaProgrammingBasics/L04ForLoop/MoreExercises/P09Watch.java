package ForLoop.MoreExercises;

import java.util.Scanner;

public class P09Watch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        for (int i = 0; i < 24; i++) {
            for (int minutes = 0; minutes < 60; minutes++)
                System.out.println(i + " : " + minutes);
        }
    }
}
