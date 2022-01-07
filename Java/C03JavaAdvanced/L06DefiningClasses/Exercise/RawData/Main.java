package DefiningClasses.Exercise.RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);

            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];

            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Tyre[] tyre = new Tyre[4];

            int tyreCount = 0;
            for (int j = 5; j < input.length; j+=2) {
                double tyrePressure = Double.parseDouble(input[j]);
                int tyreAge = Integer.parseInt(input[j + 1]);
                tyre[tyreCount] = new Tyre(tyrePressure, tyreAge);
                tyreCount++;
            }

            Car car = new Car(model, engine, cargo, tyre);
            cars.putIfAbsent(model, car);

        }

        String cargoType = scanner.nextLine();

        for (Car car : cars.values()) {
            if (cargoType.equals("flamable") && car.getCargo().getCargoType().equals("flamable")
            && car.getEngine().getEnginePower() > 250) {
                System.out.println(car);
            } else if (cargoType.equals("fragile") && car.getCargo().getCargoType().equals("fragile")
            && car.tyrePressure()) {
                System.out.println(car);
            }
        }
        

    }
}
