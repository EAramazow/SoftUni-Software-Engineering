package L05Polymorphism.Exercise.P01Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vehicles car = getCar(scanner);

        Vehicles truck = getTruck(scanner);

        Map<String, Vehicles> vehiclesMap = new LinkedHashMap<>();
        vehiclesMap.put("Car", car);
        vehiclesMap.put("Truck", truck);

        readingCommands(scanner, vehiclesMap);

        vehiclesMap.values().forEach(System.out::println);

    }

    private static void readingCommands(Scanner scanner, Map<String, Vehicles> vehiclesMap) {
        String[] vehiclesInfo;
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            vehiclesInfo = scanner.nextLine().split("\\s+");
            String commandType = vehiclesInfo[0];
            String vehicleType = vehiclesInfo[1];


            switch (commandType) {
                case "Drive":
                    double distance = Double.parseDouble(vehiclesInfo[2]);
                    System.out.println(vehiclesMap.get(vehicleType).driving(distance));
                    break;

                case "Refuel":
                    double liters = Double.parseDouble(vehiclesInfo[2]);
                    vehiclesMap.get(vehicleType).refueling(liters);
                    break;
            }


        }
    }

    private static Vehicles getTruck(Scanner scanner) {
        String[] vehiclesInfo;
        vehiclesInfo = scanner.nextLine().split("\\s+");
        double truckFuelQuantity = Double.parseDouble(vehiclesInfo[1]);
        double truckLiters = Double.parseDouble(vehiclesInfo[2]);
        Vehicles truck = new Truck(truckFuelQuantity, truckLiters);
        return truck;
    }

    private static Vehicles getCar(Scanner scanner) {
        String[] vehiclesInfo = scanner.nextLine().split("\\s+");
        double carFuelQuantity = Double.parseDouble(vehiclesInfo[1]);
        double carLiters = Double.parseDouble(vehiclesInfo[2]);
        Vehicles car = new Car(carFuelQuantity, carLiters);
        return car;
    }
}
