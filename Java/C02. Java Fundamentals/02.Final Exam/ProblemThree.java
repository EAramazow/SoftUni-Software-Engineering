package FinalExam140821;

import java.util.*;

public class ProblemThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //judge 80/100

        Map<String, List<String>> guestsMenu = new TreeMap<>();

        String input = scanner.nextLine();
        int unlikeCount = 0;

        while (!input.equals("Stop")) {
            String[] inputSplit = input.split("-");
            String likeOrUnlike = inputSplit[0];
            String guest = inputSplit[1];
            String meal = inputSplit[2];

            if (likeOrUnlike.equals("Like")) {
                if (!guestsMenu.containsKey(guest)) {
                    guestsMenu.put(guest, new ArrayList<>());
                }
                guestsMenu.get(guest).add(meal);
            } else if (likeOrUnlike.equals("Unlike")) {
                if (!guestsMenu.containsKey(guest)) {
                    System.out.printf("%s is not at the party.\n", guest);

                } else if (!guestsMenu.get(guest).contains(meal)) {
                    System.out.printf("%s doesn't have the %s in his/her collection.\n", guest, meal);

                } else {
                    guestsMenu.get(guest).remove(meal);
                    System.out.printf("%s doesn't like the %s.\n", guest, meal);
                    unlikeCount++;
                }

            }
            input = scanner.nextLine();


        }

        guestsMenu.entrySet().stream().sorted(Map.Entry.<String, List<String>>comparingByValue(Comparator.comparing(List::size))
                .reversed().thenComparing(Map.Entry.comparingByKey())).forEach(entry -> {
            System.out.printf("%s: ", entry.getKey());
            String meals = String.join(", ", entry.getValue());
            System.out.println(meals);
        });
        System.out.printf("Unliked meals: %d", unlikeCount);


    }


}


