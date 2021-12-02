package associativeArrays.Exercise;

import java.util.*;

public class P07StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsGrades = new LinkedHashMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!studentsGrades.containsKey(name)) {
                studentsGrades.put(name, new ArrayList<>());
            }
            studentsGrades.get(name).add(grade);

        }

        Map<String, Double> averageGrade = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> average : studentsGrades.entrySet()) {
            double grades = average.getValue().stream().mapToDouble(e -> e).average().getAsDouble();
            if (grades >= 4.50) {
                averageGrade.put(average.getKey(), grades);
            }
        }

        averageGrade.entrySet().stream().sorted((g1, g2) -> g2.getValue().compareTo(g1.getValue()))
                .forEach(grade -> {
                    System.out.printf("%s -> %.2f\n", grade.getKey(), grade.getValue());
                });

    }
}
