package WhileLoop.Exercises;

import java.util.Scanner;

public class P02ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int poorGradesLimit = Integer.parseInt(scanner.nextLine());

        String problemName = scanner.nextLine();
        int poorGradesCounter = 0;
        boolean isFailed = false;
        double allGradeSum = 0;
        int allGrades = 0;
        String lastProblem = "";

        while (!problemName.equals("Enough")) { // Стринга проблемНейм го правим извън цикъла за да може да го включим като условие
            int grade = Integer.parseInt(scanner.nextLine());
            allGrades++;
            allGradeSum += grade;

            if (grade <= 4) {
                poorGradesCounter++;

                if (poorGradesLimit == poorGradesCounter) {
                    isFailed = true;
                    break;
                }

            }


            lastProblem = problemName;
            problemName = scanner.nextLine();
        }

        double avgScore = allGradeSum / allGrades;

        if (isFailed) {
            System.out.printf("You need a break, %d poor grades.", poorGradesCounter);
        } else {

            System.out.printf("Average score: %.2f\n" +
                    "Number of problems: %d\n" +
                    "Last problem: %s\n", avgScore, allGrades, lastProblem);
        }
    }
}
