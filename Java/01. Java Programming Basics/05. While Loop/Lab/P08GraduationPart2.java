package WhileLoop.Lab;

import java.util.Scanner;

public class P08GraduationPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String studentName = scanner.nextLine();

        int count = 1;
        int excludedCounter = 0;
        double sumGrade = 0;

        while (count <= 12) {
            double grades = Double.parseDouble(scanner.nextLine());

            if (grades < 4.00) {
                excludedCounter++;

            } else {
                count++;
            }

//            ИЛИ
//            if (grades >= 4.00) {
//                count++;
//            } else {
//                excludedCounter++;
//
//            }

            if (excludedCounter > 1) {
                break;
            }

            sumGrade += grades;

        }

        if (excludedCounter > 1) {
            System.out.printf("%s has been excluded at %d grade\n", studentName, count);
        } else {
            System.out.printf("%s graduated. Average grade: %.2f", studentName, sumGrade / 12);
        }
    }
}
