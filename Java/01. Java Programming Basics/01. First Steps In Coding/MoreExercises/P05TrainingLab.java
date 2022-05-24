package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class P05TrainingLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double w = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());


        double wCM = w / 0.010000;
        double hCM = (h / 0.010000) - 100;

        double roomW = Math.floor(wCM / 120);
        double roomH = Math.floor(hCM / 70);


        double all = Math.floor((roomW * roomH) - 3);

        System.out.printf("%.0f", all);


    }
}
