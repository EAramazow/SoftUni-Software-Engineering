package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.BaseToy;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseHouse implements House {
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cat;

    public BaseHouse(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        setCats();
        setToys();
    }

    public void setToys() {
        this.toys = new ArrayList<>();
    }

    public void setCats() {
        this.cat = new ArrayList<>();
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int sumSoftness() {

        return this.getToys().stream().mapToInt(Toy::getSoftness).sum();

    }

    @Override
    public void addCat(Cat cat) {

        if (this.cat.size() <= this.capacity) {
            this.cat.add(cat);
        } else {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
    }

    @Override
    public void removeCat(Cat cat) {
        this.cat.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        this.cat.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
        StringBuilder result = new StringBuilder();

        result.append(String.format("%s %s", this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append("Cats: ");

        if (cat.isEmpty()) {
            result.append("none");
        } else {
            String catsByName = this.cat.stream().map(Cat::getName).collect(Collectors.joining(" "));
            result.append(catsByName);
        }

        result.append(System.lineSeparator());
        result.append(String.format("Toys: %d", this.toys.size()))
                .append(System.lineSeparator())
                .append(String.format("Softness: %d", this.sumSoftness()))
                .append(System.lineSeparator());

        return result.toString();
    }

    @Override
    public String getName() {
        return this.name;
    }


    @Override
    public Collection<Cat> getCats() {
        return this.cat;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }
}
