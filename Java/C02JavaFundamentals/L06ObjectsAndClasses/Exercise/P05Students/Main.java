package objectsAndClasses.Exercise.P05Students;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        int studentsCount = Integer.parseInt(scanner.nextLine());

        for (int student = 1; student <= studentsCount; student++) {
            String studentData = scanner.nextLine();
            String[] splitData = studentData.split("\\s+");
            String firstName = splitData[0];
            String lastName = splitData[1];
            double grade = Double.parseDouble(splitData[2]);

            Student st = new Student(firstName, lastName, grade);

            students.add(st);
        }

        // sort by descending order by grade
        // 1. ascending by grade
        // 2. after that we reversed the grades

       students = students.stream().sorted(Comparator.comparingDouble(Student::getGrade)).collect(Collectors.toList());    // ascending
        Collections.reverse(students);   // descending

        for (Student student : students) {
            System.out.println(student.toString());

        }
    }
}
