package associativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> parkingMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split(" ");
            String registerOrUnregister = commands[0];
            String name = commands[1];


            if (registerOrUnregister.equals("register")) {
                String plate = commands[2];



                if (!parkingMap.containsKey(name)) {
                    parkingMap.put(name, plate);
                    System.out.printf("%s registered %s successfully\n", name, plate);
                } else {

                    System.out.printf("ERROR: already registered with plate number %s\n", plate);
                }

            } else if (registerOrUnregister.equals("unregister")) {

                if (!parkingMap.containsKey(name)) {
                    System.out.printf("ERROR: user %s not found\n", name);

                } else {
                    parkingMap.remove(name);
                    System.out.printf("%s unregistered successfully\n", name);

                }

            }

        }

        parkingMap.entrySet().stream().forEach(entry -> System.out.printf("%s => %s\n", entry.getKey(), entry.getValue()));
    }
}
