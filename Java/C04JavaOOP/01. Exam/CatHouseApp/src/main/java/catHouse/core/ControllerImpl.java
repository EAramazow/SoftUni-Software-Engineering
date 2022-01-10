package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.UNSUITABLE_HOUSE;

public class ControllerImpl implements Controller {

    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl () {
        setToys();
        setHouses();
    }

    public void setToys() {
        this.toys = new ToyRepository();
    }

    public void setHouses() {
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;

        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;

            case "LongHouse":
                house = new LongHouse(name);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }
        this.houses.add(house);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);

    }

    @Override
    public String buyToy(String type) {
        Toy toy;

        switch (type) {
            case "Ball":
                toy = new Ball();
                break;

            case "Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = this.toys.findFirst(toyType);

        if (toy == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND, toyType));
        }

        this.houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().ifPresent(house -> house.buyToy(toy));

        this.toys.removeToy(toy);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {

        Cat cat = null;

        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;

            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }

        House currentHouse = this.houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);
        String result = null;


        if (currentHouse != null) {
            if (!currentHouse.getClass().getSimpleName().substring(0, 5).equals(catType.substring(0, 5))) {
                result = ConstantMessages.UNSUITABLE_HOUSE;
            } else {
                currentHouse.addCat(cat);
                result = String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
            }
        }

        return result;
    }

    @Override
    public String feedingCat(String houseName) {

        House currentHouse = this.houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);

        if (currentHouse != null) {
            currentHouse.feeding();
        }

        int feededCats;

        if (currentHouse != null) {
            feededCats = currentHouse.getCats().size();
        } else {
            feededCats = 0;
        }

        return String.format(ConstantMessages.FEEDING_CAT, feededCats);
    }

    @Override
    public String sumOfAll(String houseName) {
        House currentHouse = this.houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);

        double totalSum = 0.0;

        if (currentHouse != null) {
            double catsSum = currentHouse.getCats().stream().mapToDouble(Cat::getPrice).sum();
            double toysSum = currentHouse.getToys().stream().mapToDouble(Toy::getPrice).sum();
            totalSum = catsSum + toysSum;
        }
        return String.format(ConstantMessages.VALUE_HOUSE, houseName, totalSum);
    }

    @Override
    public String getStatistics() {
        StringBuilder result = new StringBuilder();

        this.houses.forEach(house -> result.append(house.getStatistics()).append(System.lineSeparator()));

        return result.toString();
    }
}
