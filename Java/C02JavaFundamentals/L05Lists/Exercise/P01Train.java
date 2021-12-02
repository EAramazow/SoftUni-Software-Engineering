package lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] inputData = input.split(" ");
            if (inputData[0].equals("Add")) {
                int passengers = Integer.parseInt(inputData[1]);
                wagons.add(passengers);
            } else {
                int passengersToAdd = Integer.parseInt(inputData[0]);
                for (int index = 0; index < wagons.size(); index++) {
                    int currentWagon = wagons.get(index);
                    if (currentWagon + passengersToAdd <= maxCapacity) {
                        wagons.set(index, currentWagon + passengersToAdd);  // команда Set Директно замества стойностите на индексите
                        // команда .add - слага стойността на индекса и измества останалите елементи напред, увеличава списъка (не ги замества)
                        break;
                    }
                }
            }



            input = scanner.nextLine();
        }

        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }

        // Или wagons.forEach(wagon -> System.out.println(wagon + " "));

    }
}
