package Exam23102021;

import java.util.*;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ingredients = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] freshness = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();


        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();

        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();

        Map<String, Integer> cocktails = new TreeMap<>();


        for (int ingredient : ingredients) {
            ingredientsQueue.offer(ingredient);
        }

        for (int fresh : freshness) {
            freshnessStack.push(fresh);
        }

        int pearSour = 0;
        int theHarvest = 0;
        int appleHinny = 0;
        int highFashion = 0;

        while (!ingredientsQueue.isEmpty() || !freshnessStack.isEmpty()) {
            if (ingredientsQueue.isEmpty() || freshnessStack.isEmpty()) {
                break;
            }


            int currentIngredients = ingredientsQueue.poll();
            int currentFreshness = freshnessStack.pop();
            int result = currentIngredients * currentFreshness;

            if (result == 150) {
                String cocktail = "Pear Sour";
                cocktails.put(cocktail, pearSour + 1);
                pearSour++;
            } else if (result == 250) {
                String cocktail = "The Harvest";
                cocktails.put(cocktail, theHarvest + 1);
                theHarvest++;
            } else if (result == 300) {
                String cocktail = "Apple Hinny";
                cocktails.put(cocktail, appleHinny + 1);
                appleHinny++;
            } else if (result == 400) {
                String cocktail = "High Fashion";
                cocktails.put(cocktail, highFashion + 1);
                highFashion++;
            } else {
                ingredientsQueue.offerLast(currentIngredients + 5);
            }
        }

        int totalCocktails = cocktails.size();

        if (totalCocktails >= 4 && pearSour >= 1 && theHarvest >= 1 && appleHinny >= 1 && highFashion >= 1) {
            System.out.println("It's party time! The cocktails are ready!");
            cocktails.forEach((k, v) -> System.out.printf("# %s --> %d\n", k, v));

        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
            if (!ingredientsQueue.isEmpty()) {
                int totalSum = 0;
                for (Integer integer : ingredientsQueue) {
                    totalSum += integer;
                }
                System.out.printf("Ingredients left: %d\n", totalSum);
                cocktails.forEach((k, v) -> System.out.printf("# %s --> %d\n", k, v));
            }

        }


    }
}