package DefiningClasses.Exercise.PokemonTrainer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> participants = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Tournament")) {
            String[] tokens = input.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            participants.putIfAbsent(trainerName, new Trainer(trainerName, 0, new ArrayList<>()));
            participants.get(trainerName).getPokemonCollection().add(pokemon);



            input = scanner.nextLine();
        }


    }
}
