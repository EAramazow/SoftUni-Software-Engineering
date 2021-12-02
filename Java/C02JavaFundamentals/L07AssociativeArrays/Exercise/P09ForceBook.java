package associativeArrays.Exercise;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> forceBook = new LinkedHashMap<>();

        while (!input.equals("Lumpawaroo")) {
            String[] splitData = input.split("\\s+");
            String separator = splitData[1];

            if (input.contains("|")) {
                String forceSide = input.split("\\s+\\|\\s+")[0];
                String forceUser = input.split("\\s+\\|\\s+")[1];
                forceBook.putIfAbsent(forceSide, new ArrayList<>());

                boolean isExist = false;
                for (List<String> list : forceBook.values()) {
                    if (list.contains(forceUser)) {
                        isExist = true;
                    }
                }
                if (!isExist) {
                    forceBook.get(forceSide).add(forceUser);
                }

            } else if (input.contains("->")) {
                String forceUser = input.split("\\s+->\\s+")[0];
                String forceSide = input.split("\\s+->\\s+")[1];

                forceBook.entrySet().forEach(entry -> entry.getValue().remove(forceUser));

//                if (!forceBook.containsKey(forceSide)) {
//                    forceBook.put(forceSide, new ArrayList<>());
//                }   -  проверката може да се замени с putIfAbsent

                forceBook.putIfAbsent(forceSide, new ArrayList<>());
                forceBook.get(forceSide).add(forceUser);
                System.out.printf("%s joins the %s side!\n", forceUser, forceSide);
            }

            input = scanner.nextLine();
        }

        forceBook.entrySet().stream().filter(entry -> entry.getValue().size() > 0)
                .sorted((e1, e2) -> {
                    int sortedResult = Integer.compare(e2.getValue().size(), e1.getValue().size());
                    if (sortedResult == 0) {
                        sortedResult = e1.getKey().compareTo(e2.getKey());
                    }
                    return sortedResult;
                }).forEach(entry -> {
            System.out.printf("Side: %s, Members: %d\n", entry.getKey(), entry.getValue().size());
            entry.getValue().stream().sorted().forEach(user -> System.out.println("! " + user));
                });
    }
}
