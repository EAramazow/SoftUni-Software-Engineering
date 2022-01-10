package L05Polymorphism.Exercise.P03WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String input = scanner.nextLine();


        while (!input.equals("End")) {
            String[] animalInfo = input.split("\\s+");

            Animal animal = createAnimal(animalInfo);
            animals.add(animal);

            String foodInput = scanner.nextLine();
            Food food = getFood(foodInput.split("\\s+"));

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();

        }


        animals.forEach(System.out::println);

    }

    public static Animal createAnimal(String[] animalInfo) {
        String animalType = animalInfo[0];
        String animalName = animalInfo[1];
        double animalWeight = Double.parseDouble(animalInfo[2]);
        String animalLivingRegion = animalInfo[3];

        switch (animalType) {

            case "Cat":
                return new Cat(animalName, animalType, animalWeight, animalLivingRegion, animalInfo[4]);

            case "Tiger":
                return new Tiger(animalName, animalType, animalWeight, animalLivingRegion);

            case "Zebra":
                return new Zebra(animalName, animalType, animalWeight, animalLivingRegion);

            case "Mouse":
                return new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
            default:
                throw new IllegalArgumentException("No such animal");
        }

    }

    public static Food getFood(String[] foodInput) {
        String foodType = foodInput[0];
        int quantity = Integer.parseInt(foodInput[1]);

        if (foodType.equals("Meat")) {
            return new Meat(quantity);
        } else return new Vegetable(quantity);


    }
}
