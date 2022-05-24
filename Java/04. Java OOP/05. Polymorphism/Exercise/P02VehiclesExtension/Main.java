package L05Polymorphism.Exercise.P02VehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vehicles car = getVehicle(scanner);

        Vehicles truck = getVehicle(scanner);

        Vehicles bus = getVehicle(scanner);

        Map<String, Vehicles> vehiclesMap = new LinkedHashMap<>();
        vehiclesMap.put("Car", car);
        vehiclesMap.put("Truck", truck);
        vehiclesMap.put("Bus", bus);

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
            Vehicles vehicle = vehiclesMap.get(vehicleType);

            try {


                switch (commandType) {
                    case "Drive":
                        double distance = Double.parseDouble(vehiclesInfo[2]);
                        if (vehicle instanceof Bus) {
                            ((Bus) vehicle).setEmpty(false);
                        }
                        System.out.println(vehicle.driving(distance));
                        break;

                    case "Refuel":
                        double liters = Double.parseDouble(vehiclesInfo[2]);
                        vehiclesMap.get(vehicleType).refueling(liters);
                        break;

                    case "DriveEmpty":
                        double driveEmptyDistance = Double.parseDouble(vehiclesInfo[2]);


                        if (vehicle instanceof Bus) {
                            ((Bus) vehicle).setEmpty(true);
                        }
                        System.out.println(vehicle.driving(driveEmptyDistance));
                        break;
                }


            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Vehicles getVehicle(Scanner scanner) {
        String[] vehiclesInfo = scanner.nextLine().split("\\s+");
        String vehicleType = vehiclesInfo[0];
        double fuelQuantity = Double.parseDouble(vehiclesInfo[1]);
        double liters = Double.parseDouble(vehiclesInfo[2]);
        double tankCapacity = Double.parseDouble(vehiclesInfo[3]);
        Vehicles vehicle = null;

        switch (vehicleType) {
            case "Car":
                vehicle = new Car(fuelQuantity, liters, tankCapacity);
                break;

            case "Bus":
                vehicle = new Bus(fuelQuantity, liters, tankCapacity);
                break;

            case "Truck":
                vehicle = new Truck(fuelQuantity, liters, tankCapacity);
                break;

        }
        return vehicle;
    }

}
