package DefiningClasses.Lab.CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int carsNum = Integer.parseInt(scanner.nextLine());

        List<Car> carsInfo = new ArrayList<>();


        for (int i = 0; i < carsNum; i++) {
            String[] input = scanner.nextLine().trim().split("\\s+");
            String brand = input[0];
            String model = input[1];
            int hp = Integer.parseInt(input[2]);
            Car car = new Car(brand, model, hp);

            carsInfo.add(car);

        }

        Consumer<Car> print = System.out::println;

        carsInfo.forEach(print);

    }
}

