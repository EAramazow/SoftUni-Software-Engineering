package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P09UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        Map<String, Map<String, Integer>> usersMap = new TreeMap<>();
        //IP=192.23.30.40 message='Hello&derps.' user=destroyer

        while (!input.equals("end")) {
            String[] splitInput = input.split("\\s+");
            String IP = splitInput[0].split("=")[1];
            String username = splitInput[2].split("=")[1];


            usersMap.putIfAbsent(username, new LinkedHashMap<>());
            usersMap.get(username).putIfAbsent(IP, 0);
            usersMap.get(username).put(IP, usersMap.get(username).get(IP) + 1);

            input = scanner.nextLine();
        }

        usersMap.forEach((key, value) -> {
                    System.out.printf("%s: \n", key);
                    int count = 1;
                    for (Map.Entry<String, Integer> entry : value.entrySet()) {
                        String output = String.format(count < value.entrySet().size()
                                ? "%s => %d, " : "%s => %d.%n", entry.getKey(), entry.getValue());
                        System.out.printf("%s", output);
                        count++;
                    }
                });

    }
}
