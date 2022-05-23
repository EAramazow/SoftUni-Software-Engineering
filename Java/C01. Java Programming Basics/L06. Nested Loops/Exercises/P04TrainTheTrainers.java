package NestedLoops.Exercises;

import java.util.Scanner;

public class P04TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int jury = Integer.parseInt(scanner.nextLine());
        String presentation = scanner.nextLine();



        double gradeCounter = 0;
        double gradesSum = 0;
        double allGradeSum = 0;
        double averageGrade = 0;


        while (!presentation.equals("Finish")) {
                gradesSum = 0;

            for (int i = 1; i <= jury ; i++) {
                double grade = Double.parseDouble(scanner.nextLine());

                allGradeSum += grade;
                gradesSum += grade;
                gradeCounter++;
                if (i == jury) {
                    averageGrade = gradesSum / jury;
                    break;
                }

            }

            if (!presentation.equals("Finish")) {
                System.out.printf("%s - %.2f.\n", presentation, averageGrade);
            }


            presentation = scanner.nextLine();
        }

        if (presentation.equals("Finish")) {
            System.out.printf("Student's final assessment is %.2f.", allGradeSum / gradeCounter);
        }


    }
}
