package DefiningClasses.Exercise.PokemonTrainer;

import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemonCollection;

    public Trainer(String name, int numberOfBadges, List<Pokemon> pokemonCollection) {
        this.name = name;
        this.numberOfBadges = numberOfBadges;
        this.pokemonCollection = pokemonCollection;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public List<Pokemon> getPokemonCollection() {
        return pokemonCollection;
    }
}
