package L02Encapsulation.Exercise.P04PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaInfo = scanner.nextLine().split("\\s+");
        String name = pizzaInfo[1];
        int numberOfToppings = Integer.parseInt(pizzaInfo[2]);


        try {

            // choose a pizza
            Pizza pizza = new Pizza(name, numberOfToppings);

            String[] doughInfo = scanner.nextLine().split("\\s+");
            String flourType = doughInfo[1];
            String bakingTechnique = doughInfo[2];
            double weight = Double.parseDouble(doughInfo[3]);

            // create a dough for the pizza
            Dough dough = new Dough(flourType, bakingTechnique, weight);
            pizza.setDough(dough);


            String input = scanner.nextLine();

            while (!input.equals("END")) {
                String[] toppingInfo = input.split("\\s+");
                String toppingType = toppingInfo[1];
                double toppingWeight = Double.parseDouble(toppingInfo[2]);

                // create topping for the pizza
                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);

                input = scanner.nextLine();
            }

            System.out.println(pizza);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
