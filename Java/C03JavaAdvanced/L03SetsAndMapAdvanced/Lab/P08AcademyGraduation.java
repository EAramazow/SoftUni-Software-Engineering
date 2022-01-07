package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        Map<String, double[]> map = new TreeMap<>();


        while (numberOfStudents-- > 0) {
            String names = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();

            map.putIfAbsent(names, grades);
        }
        map.forEach((key, value) -> {
            System.out.printf("%s is graduated with %s\n", key, averageGrade(value));
        });

    }

    private static double averageGrade(double[] grades) {
        double avg = 0.0;
        for (double grade : grades) {
            avg += grade;
        }
        return avg / grades.length;
    }
}
