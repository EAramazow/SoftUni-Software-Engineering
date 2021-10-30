package FirstStepsInCoding.Lab;

import java.util.Scanner;

public class P08PetShop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int allDogs = Integer.parseInt(scanner.nextLine());
        int otherPets = Integer.parseInt(scanner.nextLine());

        double dogsFood = allDogs * 2.50;
        double otherPetsFood = otherPets * 4.00;

        double sum = dogsFood + otherPetsFood;


        System.out.println(sum + " " + ("lv."));



    }
}
