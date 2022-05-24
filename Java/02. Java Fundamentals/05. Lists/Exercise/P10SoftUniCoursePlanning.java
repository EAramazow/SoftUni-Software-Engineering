package lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> schedule = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("course start")) {
            String[] tokens = input.split(":");
            String commandName = tokens[0];
            String lessonTitle = tokens[1];

            switch (commandName) {
                case "Add":
                  if (!schedule.contains(lessonTitle)) {
                      schedule.add(lessonTitle);
                  }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if (!schedule.contains(lessonTitle)) {
                        schedule.add(index, lessonTitle);
                    }
                    break;
                case "Remove":
                    if (schedule.contains(lessonTitle)) {
                        schedule.remove(lessonTitle);
                    }
                    int indexLessonTitle = schedule.indexOf(lessonTitle);
                    if (schedule.get(indexLessonTitle + 1).equals(lessonTitle + "-Exercise")) {
                        schedule.remove(indexLessonTitle + 1);
                    }
                    break;
                case "Swap":
                    String lessonTitle2 = input.split(":")[2];


                    if (schedule.contains(lessonTitle) && schedule.contains(lessonTitle2)) {
                        int indexTitle1 = schedule.indexOf(lessonTitle);
                        int indexTitle2 = schedule.indexOf(lessonTitle2);

                        schedule.set(indexTitle1, lessonTitle2);
                        schedule.set(indexTitle2, lessonTitle);

                        String exercise1 = lessonTitle + "-Exercise";
                        String exercise2 = lessonTitle2 + "-Exercise";

                        if (schedule.contains(exercise1)) {
                            schedule.remove(schedule.indexOf(exercise1));
                            schedule.add(schedule.indexOf(lessonTitle + 1), exercise1);
                        }
                        if (schedule.contains(exercise2)) {
                            schedule.remove(schedule.indexOf(exercise2));
                            schedule.add(schedule.indexOf(lessonTitle2) + 1, exercise2);
                        }
                    }

                        break;

                case "Exercise":
                    String exercise = lessonTitle + "-Exercise";
                    int indexLesson = schedule.indexOf(lessonTitle);
                    if (schedule.contains(lessonTitle)) {
                        if (indexLesson == schedule.size() - 1) {
                            schedule.add(indexLesson + 1, exercise);

                        } else if (indexLesson != schedule.size() - 1 && !schedule.get(indexLesson + 1).equals(exercise)) {
                            schedule.add(indexLesson + 1, exercise);
                        }
                    } else {
                        schedule.add(lessonTitle);
                        schedule.add(exercise);
                    }
                    break;
            }




            input = scanner.nextLine();
        }
        printList(schedule);
    }

    private static void printList (List<String> elements) {
        int count = 1;

        for (String list : elements) {
            System.out.println(count + "." + list);
            count++;
        }
    }
}
