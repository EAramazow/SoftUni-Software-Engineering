package ForLoop.MoreExercises;

import java.util.Scanner;

public class P04Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStudents = Integer.parseInt(scanner.nextLine());

        double topStudents = 0;
        double student4 = 0;
        double student3 = 0;
        double student2 = 0;

        double averageSuccess = 0;


        for (int i = 1; i <= countStudents; i++) {
            double assessmentExam = Double.parseDouble(scanner.nextLine());

            averageSuccess += assessmentExam;

            if (assessmentExam >= 5.00) {
                topStudents++;

            } else if (assessmentExam >= 4.00 && assessmentExam <= 4.99) {
                student4++;

            } else if (assessmentExam >= 3.00 && assessmentExam <= 3.99) {
                student3++;

            } else if (assessmentExam >= 2.00 && assessmentExam <= 2.99) {
                student2++;

            }

        }

        System.out.printf("Top students: %.2f%%", topStudents / countStudents * 100);
        System.out.printf("\nBetween 4.00 and 4.99: %.2f%%", student4 / countStudents * 100);
        System.out.printf("\nBetween 3.00 and 3.99: %.2f%%", student3 / countStudents * 100);
        System.out.printf("\nFail: %.2f%%", student2 / countStudents * 100);
        System.out.printf("\nAverage: %.2f", averageSuccess / countStudents);

    }
}
