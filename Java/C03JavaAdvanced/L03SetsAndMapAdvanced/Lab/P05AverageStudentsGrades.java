package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> students = new TreeMap<>();

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfStudents; i++) {
            String namesAndGrades = scanner.nextLine();
            String names = namesAndGrades.trim().split("\\s+")[0];
            double grades = Double.parseDouble(namesAndGrades.trim().split("\\s+")[1]);



            if (!students.containsKey(names)) {
                students.put(names, new ArrayList<>());
            }
                students.get(names).add(grades);
        }

        students.forEach((key, value) -> {
            System.out.printf("%s -> ", key);
            value.forEach(v -> System.out.printf("%.2f ", v));
            System.out.printf("(avg: %.2f)\n", averageGrades(value));
        });


    }

    private static double averageGrades(List<Double> value) {
        double avg = 0.0;
        for (Double grade : value) {
            avg += grade;
        }
        return avg / value.size();
    }
}
