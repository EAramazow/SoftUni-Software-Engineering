package DefiningClasses.Lab.CarInfo;

public class Car {
    private String brand;
    private String model;
    private int hp;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHp() {
        return hp;
    }

    public Car(String carBrand, String carModel, int carHP) {

        this.brand = carBrand;
        this.model = carModel;
        this.hp = carHP;

    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", getBrand(), getModel(), getHp());
    }

}
