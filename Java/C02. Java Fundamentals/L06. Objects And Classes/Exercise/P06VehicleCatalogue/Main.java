package objectsAndClasses.Exercise.P06VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Vehicles> cars = new ArrayList<>();
        List<Vehicles> trucks = new ArrayList<>();


        while (!input.equals("End")) {
            String[] inputData = input.split(" ");
            String typeVehicle = inputData[0];
            String brand = inputData[1];
            String color = inputData[2];
            int hp = Integer.parseInt(inputData[3]);

            Vehicles vehicle = new Vehicles(typeVehicle, brand, color, hp);


            switch (typeVehicle) {
                case "truck":
                    trucks.add(vehicle);
                    break;
                case "car":
                    cars.add(vehicle);
                    break;
            }


            input = scanner.nextLine();
        }


        String modelInput = scanner.nextLine();
        while (!modelInput.equals("Close the Catalogue")) {

            for (Vehicles model : cars) {
                if (model.getModel().equals(modelInput)) {
                    System.out.println(model.toString());
                    modelInput = scanner.nextLine();
                } else {
                    for (Vehicles truckModel : trucks) {
                        if (truckModel.getModel().equals(modelInput)) {
                            System.out.println(truckModel.toString());
                            modelInput = scanner.nextLine();
                        }
                    }
                }
            }

        }

        System.out.println(String.format("Cars have average horsepower of: %.2f.", averageCarsHP(cars.stream().collect(Collectors.toList()))));
        System.out.println(String.format("Trucks have average horsepower of: %.2f.", averageTrucksHP(trucks.stream().collect(Collectors.toList()))));


    }

    private static double averageCarsHP (List<Vehicles> cars) {
        if (cars.size() == 0) {
            return 0.0;
        }
        double sum = 0;

        for (Vehicles car : cars) {
            sum += car.getHorsePower();
        }

        return sum / cars.size();
    }

    private static double averageTrucksHP(List<Vehicles> trucks) {
        if (trucks.size() == 0) {
            return 0.0;
        }
        double sum = 0;
        for (Vehicles truck : trucks) {
            sum += truck.getHorsePower();
        }
        return sum / trucks.size();
    }

}










