package associativeArrays.Exercise;

import java.util.*;

public class P06Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> coursesMap = new LinkedHashMap<>();

        while (!input.equals("end")) {
            String courses = input.split(" : ")[0];
            String names = input.split(" : ")[1];

            if (!coursesMap.containsKey(courses)) {
                coursesMap.put(courses, new ArrayList<>());
            }
            coursesMap.get(courses).add(names);


            input = scanner.nextLine();
        }

        coursesMap.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue().size());
                    List<String> studentNames = entry.getValue();
                    studentNames.stream().sorted().forEach(studentsNames -> System.out.println("-- " + studentsNames));
                });

    }
}
